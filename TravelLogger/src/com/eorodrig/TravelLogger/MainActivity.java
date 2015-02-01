package com.eorodrig.TravelLogger;


import com.eorodrig.TravelLogger.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	public static final ClaimList claimList = new ClaimList();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	


    
    
    /**
     * This is the onClick method for View/Edit/Submit Claim Button
     * @param view
     */
    public void onClickListClaims(View view){
    	Intent intent = new Intent(MainActivity.this, ClaimListActivity.class);
    	startActivity(intent);
    }
    
    

    /**
     * This is the onClick method for the View Submitted Claims Button
     * @param view
     */
    public void onClickViewSubmittedClaims(View view){
   	 	//Intent intent = new Intent(MainActivity.this, SubmittedClaimsActivity.class);
   	 //	startActivity(intent);
   }
	 
	
}
