package com.example.packagechanges;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class ApplistChangeReceiver extends BroadcastReceiver {

	private static String TAG = "LOGs";
	
   /* BroadcastReceiver */
   public void onReceive(Context context, Intent intent) {
	   Toast.makeText(context, "onReceive() called", Toast.LENGTH_SHORT).show();
      
     
      
      
    		  
      
      String act = intent.getAction();
      if (Intent.ACTION_PACKAGE_ADDED.equals(act)
          || Intent.ACTION_PACKAGE_REMOVED.equals(act)) {
    	  
    	  Toast.makeText(context, "Package added or removed, sending notification", Toast.LENGTH_SHORT).show();
  
    	  Bundle extras = intent.getExtras();
          if (extras != null) {
        	  Log.d(TAG, "@@@ Bundle value : " + extras + "EXTRA_UID" + Intent.EXTRA_UID);
                    // Get data via the key
          String value1 = extras.getString(Intent.EXTRA_TEXT);
          if (value1 != null) {
        	  Toast.makeText(context, "Yes EXTRA TEXT : "+value1, Toast.LENGTH_SHORT).show();
          	} 
          String bool1 = extras.getString(Intent.EXTRA_REPLACING);
    	  if (bool1 != null){
    		  Toast.makeText(context, "Yes EXTRA REPLACING : "+bool1, Toast.LENGTH_SHORT).show();
    	  }
    	  String UID1 = extras.getString(Intent.EXTRA_UID);
    	  	if (UID1 != null){
    	  		Toast.makeText(context, "Yes EXTRA UID : "+UID1, Toast.LENGTH_SHORT).show();
    	  		Log.d(TAG, "@@@ Bundle value : " + extras);
    	  	}
          }else {
        	  Log.d(TAG, "@@@ Bundle is null");
          }
    	  
         //ApplistService.sendAppList(context);
      }
      else if (Intent.ACTION_PACKAGE_REPLACED.equals(act)) {
    	  Toast.makeText(context, "Package upgraded, checking if it's this package", Toast.LENGTH_SHORT).show();
        
         Uri data = intent.getData();
         if (data != null) {
            String scheme = data.getScheme();
            if ("package".equals(scheme)) {
               String ssp = data.getSchemeSpecificPart();
               String thispkg = context.getPackageName();
               if (thispkg.equals(ssp)) {
            	   Toast.makeText(context, "Own package replaced ; invoking startup logic", Toast.LENGTH_SHORT).show();

                  /*Autostart.disable(context);
                  BootCompletedReceiver.doStartup(context, Conf.getLong("STARTUP_DELAY_UPGRADE_MILLIS"));*/
               } else {
                  
                  Toast.makeText(context, "Package upgraded (" + ssp + ") is not this package ("+ thispkg + "), sending updated package list", Toast.LENGTH_SHORT).show();
                  //ApplistService.sendAppList(context);                  
               }
            } else {
            	Toast.makeText(context, "Unexpected scheme in URI of package upgrade intent, unable to determine package: " + scheme, Toast.LENGTH_SHORT).show();
               
            }
         } else {
        	 Toast.makeText(context, "No data in upgrade intent, unable to determine package", Toast.LENGTH_SHORT).show();
            
         }
      }
      else {
         
         Toast.makeText(context, "ApplistChangeReceiver received unexpected intent: " + intent, Toast.LENGTH_SHORT).show();
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
 ** ex: set softtabstop=3 tabstop=3 expandtab cindent shiftwidth=3 ft=java
 */
