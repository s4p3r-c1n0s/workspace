package com.locationlabs.v3client.feature.contact;

import static com.locationlabs.build.BuildSettings.DEBUG;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.PhoneLookup;

import com.locationlabs.util.android.AndroidUtil;
import com.locationlabs.util.android.LocationLabsApplication;
import com.locationlabs.util.debug.Log;
import com.locationlabs.util.debug.Test;
import com.locationlabs.util.java.Conf;
import com.locationlabs.util.java.StrUtil;
import com.locationlabs.v3client.DataStore;
import com.locationlabs.v3client.V3ApiService;
import com.locationlabs.v3client.V3ClientBasics;
import com.locationlabs.v3client.factory.NotificationFactory;
import com.locationlabs.v3client.model.notification.ContactNotification;
import com.locationlabs.v3client.model.notification.EmailNotification;
import com.locationlabs.v3client.model.notification.Notification;
import com.locationlabs.v3client.model.notification.NumberNotification;
import com.locationlabs.v3client.util.Feature;
import com.locationlabs.v3client.util.NotificationV4Request;


/** the ContactManager provides static methods that query the Contacts 
 *  content resolver, and to create notifications based on them.
 */
public class ContactManager extends IntentService {

   public static final String ACTION_CHECK_CONTACTS = "com.locationlabs.v3client.action.CHECK_CONTACTS";

   public ContactManager() { super ("ContactManager"); }
   
   private static Intent getContactListIntent(Context ctx) {

      Intent s = new Intent(ACTION_CHECK_CONTACTS);
      s.setClass(ctx, ContactManager.class);
      return s;
   }
   
   public static void sendContactList(Context context) {

      DataStore ds = V3ClientBasics.getDataStore(context);
      if (ds.getFeatureState(Feature.CONTACT_DISCOVERY) == false) {
         Log.d("Feature.CONTACT_DISCOVERY not enabled; doing nothing");
         return;
      }
          
      Intent it = getContactListIntent(context); 
      AndroidUtil.startServiceLocal(context, it);
   }

   // onHandleIntent won't be called until the Intent is actually handled, sequentially.
   // override this just so that we can log when the Intent's are received and queued.
   @Override
   public int onStartCommand (Intent intent, int flags, int startId) {
      Log.d("ContactManager started with intent: " +
            (intent == null ? intent : intent.getAction()));
      return super.onStartCommand(intent, flags, startId);
   }
   
   @Override
   protected void onHandleIntent(Intent intent) {
      Log.d("ContactManager handling intent: " +
            (intent == null ? intent : intent.getAction()));

      if (ACTION_CHECK_CONTACTS.equals(intent.getAction())) {
         Log.v("got CHECK_CONTACTS intent");
         checkContactList();
      }
      else {
         Log.dw("Unknown intent:" + intent);
      }
   }

   private static List<ContactNotification> currentContacts = null;
   private static List<ContactNotification> storedContacts = null;
   private static int currentContactHash = 0;
   
   public static NotificationV4Request getCurrentContactNotification() {
      if (currentContacts == null) return null; // as no diffs would be there

      Context context  = LocationLabsApplication.getAppContext();
      List diffList = calculateDiffNotifications();
      Notification not = NotificationFactory.getHeartbeatNotification(System.currentTimeMillis());
      not.setContact((diffList == null)? currentContacts : diffList);
      
      String baseUrl = V3ClientBasics.getBaseUrl(context);
      NotificationV4Request nr = new NotificationV4Request(baseUrl, not);

      return nr;
   }

   private void checkContactList() {
      DataStore ds = V3ClientBasics.getDataStore(this);
      
      long lastCheck = ds.getLastContactCheckTime();
      long now = System.currentTimeMillis();
      
      long contactCheckMillis = Conf.getInt("MIN_CONTACT_CHECK_INTERVAL_SEC") * 1000L;
      if (now < lastCheck + contactCheckMillis) {
         Log.d("Too recently checked contacts; schedule for later");
         
         AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);

         Intent it = getContactListIntent(this); 
         PendingIntent pi = PendingIntent.getService((Context)this, 0, it, 0);
         am.cancel(pi);
         am.set(AlarmManager.RTC_WAKEUP, lastCheck + contactCheckMillis, pi);
      }
      else {
         Log.i("begin contacts");
         initStoredContactsList();
         List<ContactNotification> list = getContactList(this);
               
         int hash = list.hashCode();
         
         int oldHash = ds.getLastSentContactHash();
         
         if (hash != oldHash) {
            if (DEBUG) {
               Log.i("end contacts (Contact list hash " 
                     + hash + " different from old hash " + oldHash + ")");
            }
            else {
               Log.i("end contacts");
            }
                     
            currentContacts = list;
            currentContactHash = hash;
            ds.setLastContactCheckTime(System.currentTimeMillis());
            
            V3ApiService.sendContactList(this);
         }
         else {
            Log.i("end contacts ==");
            ds.setLastContactCheckTime(System.currentTimeMillis());
            storedContacts.clear();
         }        
      }
   }

   public static void sentSuccessfully(Context ctx, Notification sent, String serverReturnedhash) {
      Log.d("server returned hash is : " + serverReturnedhash);
      
      boolean isValidDigestHash = inspectDigestHash(serverReturnedhash);
      if(isValidDigestHash) {
         int contactListHash;
         if (sent.getContact() == currentContacts) {
            contactListHash = currentContactHash;
            Log.i("contacts sent");
            saveContactListAsBaseline(ctx, currentContacts);
         } else {
            contactListHash = sent.getContact().hashCode();
            Log.i("contacts sent, newer avail");
            // New set of contacts are available so make the intent to send the contact list again
            sendContactList(ctx);
         }
         
         DataStore ds = V3ClientBasics.getDataStore(ctx);
         ds.setLastSentContactHash(contactListHash);
         ds.setContactListNotificationDigestHash(serverReturnedhash);
         
         currentContacts = null;
         currentContactHash = 0; 
      } else {
         resendEntireListNow(ctx);
      }
   }
   
   /**
    * Inspects the digest hash returned from the server and checks if its a valid hash
    * "-" and "?" are the values counted as invalid
    */
   private static boolean inspectDigestHash(String hash) {
      if(hash.equals("-") || hash.equals("?")) {
         return false;
      } else {
         return true;
      }
   }

   /**
    * Removes the contact last check time and sends the intent to send entire contact list now
    */
   private static void resendEntireListNow(Context context) {
      DataStore ds = V3ClientBasics.getDataStore(context);
      ds.setLastContactCheckTime(0); // removing the contact last check time
      ds.setLastSavedContactList(null);
      sendContactList(context);
   }

   /**
    * Saves the contact list as the baseline for the future for calculating the difference made by the user
    */
   private static void saveContactListAsBaseline(Context context, List list) {
      DataStore ds = V3ClientBasics.getDataStore(context);
         
         ObjectMapper mapper = new ObjectMapper();
         mapper.getSerializationConfig().setSerializationInclusion(Inclusion.NON_NULL);
         try {
            String ret = mapper.writeValueAsString(list);
            ds.setLastSavedContactList(ret);
        } catch (Exception e) {
           e.printStackTrace();
            Log.e("got json error " + e);
        }
   }
   
   /**
    * Fetches the already stored list of contacts from the prefs as a baseline for the diff calculation 
    */
   private static void initStoredContactsList() {
      DataStore ds = V3ClientBasics.getDataStore(LocationLabsApplication.getAppContext());
      JSONArray storedJsonArray;
      if(ds.getLastSavedContactList() == null) {
         Log.d("Strored string for contacts is null");
         return;
      }
      try {
         storedJsonArray = new JSONArray(ds.getLastSavedContactList());
         ObjectMapper mapper = new ObjectMapper();
         if(storedContacts == null) {
            storedContacts = new ArrayList<ContactNotification>();
         }
         storedContacts.clear();
         for (int i = 0; i < storedJsonArray.length(); i++) {
               storedContacts.add(mapper.readValue(storedJsonArray.getJSONObject(i).toString(),
                     ContactNotification.class));
         }
         Log.d("Size of the list fetched from the prefs : " + storedContacts.size());
      } catch (JSONException e1) {
         Log.d("error in init stored list ", e1);
      } catch (JsonParseException e) {
         Log.d("error in init stored list ", e);
      } catch (JsonMappingException e) {
         Log.d("error in init stored list ", e);
      } catch (IOException e) {
         Log.d("error in init stored list ", e);
      }
     
   }
   
   /** 
    * Gives the list of diffs in the current contacts and previous(stored) contact list
    * @return list of diffs
    */
   private static List calculateDiffNotifications() {
      Log.d("calculating diffs");
      if(storedContacts == null || storedContacts.isEmpty()) {
         Log.d("returning current contact list as diff");
         return currentContacts;
      }
      ArrayList<ContactNotification> diffList = new ArrayList<ContactNotification>();
      for(ContactNotification not : currentContacts) {
         if(storedContacts.contains(not)) {
            storedContacts.remove(not);
            Log.d("this contact is not changed, not including in diff list :  " + not.name);
         } else {
            // Those contacts which are present in the current list
            // and not in the stored list are either modified one or the newly added one
            // For the modified ones, we mark their new value as the added one and the old value as the deleted one
            Log.d("adding to contact diff list : " + not.name);
            not.type = ContactNotification.TYPE_CONTACT_ADDED;
            diffList.add(not);
         }
      }
      
      Log.d("To be deleted entries are " + storedContacts.size());
      for(ContactNotification not : storedContacts) {
         // Elements remaining in the stored list are either the deleted ones or the modified ones
         // So for the modified ones, we mark their old value (present in this list)
         // as the removed type.
         not.type = ContactNotification.TYPE_CONTACT_REMOVED;
         diffList.add(0, not);
      }
      
      // Adding the last hash value stored in the prefs to the top of the diff list
      DataStore ds = V3ClientBasics.getDataStore(LocationLabsApplication.getAppContext());
      ContactNotification baseline = new ContactNotification(ContactNotification.TYPE_CONTACT_BASELINE);
      baseline.hash = "" + ds.getContactListNotificationDigestHash();
      diffList.add(baseline);
      
      Log.d("size of the diff list : " + diffList.size());
      Log.d("Diff list is : " + diffList.toString());
      
      return diffList;
   }

   /** this method (and the ContactsContract api) are disgusting
    */
   public static List<ContactNotification> getContactList(Context context) {
      List<ContactNotification> map = new LinkedList<ContactNotification>();
      
      Cursor cursor = context.getContentResolver().query(Contacts.CONTENT_URI, 
                                                         null, null, 
                                                         null, null); 
      while (cursor.moveToNext()) { 
         String contactId = cursor.getString(cursor.getColumnIndex(Contacts._ID)); 
         String name = cursor.getString(cursor.getColumnIndex(Contacts.DISPLAY_NAME)); 

         ContactNotification cn = new ContactNotification();
         cn.name = (name);

         boolean hasPhone = false;

         Log.v("got name " + name);
         
         if (cursor.getInt(cursor.getColumnIndex(Contacts.HAS_PHONE_NUMBER)) == 1) {
            //Log.v("has phone");
            Cursor phones = context.getContentResolver().query(Phone.CONTENT_URI, 
                                                               null, 
                                                               Phone.CONTACT_ID +" = "+ contactId, 
                                                               null, null); 
            List<NumberNotification> list = new LinkedList<NumberNotification>();
            while (phones.moveToNext()) { 
               NumberNotification nn = new NumberNotification();
               String num = phones.getString(phones.getColumnIndex(Phone.NUMBER));
               nn.number = num;
               int ptype = phones.getInt(phones.getColumnIndex(Phone.TYPE));
               nn.type = (context.getString(Phone.getTypeLabelResource(ptype)).toLowerCase());
               if (StrUtil.hasText(num)) {
                  list.add(nn);
                  hasPhone = true;
               }
            } 
            cn.numbers = list;
            phones.close();
         }
         
         Cursor emails = context.getContentResolver().query(Email.CONTENT_URI, 
                                                            null, 
                                                            Email.CONTACT_ID + " = " + contactId, 
                                                            null, null); 

         List<EmailNotification> list = null;
         while (emails.moveToNext()) { 
            String emailAddress = emails.getString(emails.getColumnIndex(Email.DATA)); 
            Log.v("got emailAddress " + emailAddress);

            if (!StrUtil.hasText(emailAddress)) continue;

            if(list == null) 
               list = new LinkedList<EmailNotification>();

            EmailNotification en = new EmailNotification();
            en.email = emailAddress;
            int etype = emails.getInt(emails.getColumnIndex(Email.TYPE));
            en.type = (context.getString(Email.getTypeLabelResource(etype)).toLowerCase());
            list.add(en);
         } 
         
         if(list != null) cn.emails = list;
         
         emails.close(); 
         
         // NOT sending bare email contacts
         if (hasPhone) {
            map.add(cn);
         }
      }
      cursor.close(); 

      return map;
   }
   
   public static String getDisplayName(Context context, String phoneNumber) {
      Log.d("looking up display name for phone number: " + phoneNumber);
      Uri uri = Uri.withAppendedPath(PhoneLookup.CONTENT_FILTER_URI, Uri.encode(phoneNumber));
      Cursor names = context.getContentResolver().query(uri, 
                                                        new String[]{ PhoneLookup.DISPLAY_NAME }, 
                                                        /* selection */ null, 
                                                        /* selectionArgs */ null, 
                                                        /* sortOrder */ null);
      Test.avouch(names.getColumnCount() == 1, 
                  "Expect one and only one column for phone number to display name lookup");
      //Log.v("columns: " + Arrays.asList(names.getColumnNames()));
      String displayName = null;
      while (displayName == null && names.moveToNext()) {
         int idx = names.getColumnIndex(PhoneLookup.DISPLAY_NAME);
         Test.avouch(idx != -1, "Display name column not found");
         // if there are multiple rows, we don't care, we're just going to return 
         //    the first meaningful one found
         String name = names.getString(idx);
         Log.v("got a row: " + name);
         if (name != null && !"".equals(name)) {
            displayName = name;
         }
      }
      if (names != null) {
         names.close();
      }
      return displayName;
   }

   public static void print(Context context) {
      List<ContactNotification> map = getContactList(context);
      Log.d("Contacts: " + map);
   }

}

/*
** Local Variables:
**   c-basic-offset: 3
**   tab-width: 3
**   indent-tabs-mode: nil
** End:
**
** vim: softtabstop=3 tabstop=3 expandtab cindent shiftwidth=3
**
*/
