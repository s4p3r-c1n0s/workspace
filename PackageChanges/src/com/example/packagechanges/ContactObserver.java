package com.locationlabs.v3client.feature.contact;

import android.content.Context;
import com.locationlabs.util.debug.Log;

public class ContactObserver extends android.database.ContentObserver {
   private Context context = null;

   public ContactObserver(Context _context) {
      super(null);
      context = _context;
   }
   public boolean deliverSelfNotifications() {
      return true;
   }

   public void onChange(boolean selfChange) {
       Log.i("contacts updated?");
       ContactManager.sendContactList(context);
   }
}