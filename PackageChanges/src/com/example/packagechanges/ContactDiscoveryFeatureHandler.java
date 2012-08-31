package com.locationlabs.v3client.feature.contact;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;

import com.locationlabs.util.debug.Log;
import com.locationlabs.util.android.LocationLabsApplication;
import com.locationlabs.v3client.DataStore;
import com.locationlabs.v3client.V3ClientBasics;
import com.locationlabs.v3client.util.Feature;
import com.locationlabs.v3client.feature.FeatureHandler;

import android.provider.ContactsContract;

public class ContactDiscoveryFeatureHandler extends FeatureHandler {
   
   private ContactObserver obs = null;
   
   public ContactDiscoveryFeatureHandler() {
      super(Feature.CONTACT_DISCOVERY);
   }
      
   public boolean setupToCurrent() {
      Context ctx = LocationLabsApplication.getAppContext();
      
      if (isActive()) {
         
         if (obs == null) {
            obs = new ContactObserver(ctx);
            
            ctx.getContentResolver().registerContentObserver(ContactsContract.Contacts.CONTENT_URI, true, obs);
            
         }
                                 
         return true;
      }
      else {
         if (obs != null) {
            ctx.getContentResolver().unregisterContentObserver(obs);
            obs = null;
         }
         return false;
      }     
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
