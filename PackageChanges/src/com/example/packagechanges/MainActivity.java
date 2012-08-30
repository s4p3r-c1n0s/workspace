package com.example.packagechanges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		checkAppList();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	private void checkAppList() {
		CheckAppList chAppList = new CheckAppList();
		chAppList.execute();
	}

	class CheckAppList extends AsyncTask<Void, Void, Byte> {
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected Byte doInBackground(Void... params) {
			Byte result = 0;
			// Do your stuff
			return result;
		}

		@Override
		protected void onPostExecute(Byte result) {
			if (result == 0) {
			} else {
			}
			super.onPostExecute(result);
		}
	}

	private void check() {
		ApplicationNotification an = getPackageMap(this);
	}
	

	
	private static ApplicationNotification getPackageMap(Context context) {

        Map<String, List<ActivityNotification>> accum;
        accum = new HashMap<String, List<ActivityNotification>>(50);

        PackageManager pm = context.getPackageManager();

        Intent it = new Intent(Intent.ACTION_MAIN);
        it.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> rinfos = pm.queryIntentActivities(it, 0);

        if (rinfos != null) for (ResolveInfo ri : rinfos) {

                ActivityInfo ai = ri.activityInfo;

                if (ai == null) {
                    //Log.d("Null ActivityInfo in ResolveInfo list");
                    continue;
                }

                List<ActivityNotification> plist = accum.get(ai.packageName);
                if (plist == null) {
                    plist = new LinkedList<ActivityNotification>();
                    accum.put(ai.packageName, plist);
                }

                ActivityNotification an = new ActivityNotification();
                an.activityClass = ai.name;
                an.activityName = ai.loadLabel(pm).toString();

                plist.add(an);
            }
        //

        List<PackageInfo> packages = pm.getInstalledPackages(0);

        for(PackageInfo p : packages) {
            if (accum.get(p.packageName) == null) {
                List<ActivityNotification> plist = new LinkedList<ActivityNotification>();
                accum.put(p.packageName, plist);
            }
        }

        ApplicationNotification app = new ApplicationNotification();
        List<PackageNotification> lpn = new ArrayList<PackageNotification>(accum.size());
        app.packages = lpn;

        for (Map.Entry<String, List<ActivityNotification>> ent : accum.entrySet()) {
            PackageNotification pn = new PackageNotification();
            pn.packageName = ent.getKey();
            pn.activities = ent.getValue();
            lpn.add(pn);
        }

        return app;
    }
}
