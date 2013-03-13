package com.netlinks.porteautomatique;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.gcm.GCMRegistrar;


public class launcherActivity extends Activity{

	public boolean isBackPressed = false;
	static final String SENDER_ID="386736547261";
	public String TAG="onCreate";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setFullscreen();
		setContentView(R.layout.launcher);
		
		//GCM
		GCMRegistrar.checkDevice(this);
		GCMRegistrar.checkManifest(this);
		final String regId = GCMRegistrar.getRegistrationId(this);
		if (regId.equals("")) {
		  
		GCMRegistrar.register(this, SENDER_ID);
		} else {
		  Log.v(TAG, "Already registered ");
		}
		
	}
	
	public void setFullscreen() {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				if (!isBackPressed) {

					final Intent mainIntent = new Intent(launcherActivity.this,
							DashboardActivity.class);
					startActivityForResult(mainIntent, 1);
					finish();
				}
				
			}
		}, 3000);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.launcher, menu);
		return false;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK) {
			finish();
			isBackPressed = true;

			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

}

