package com.example.PROTOTYPEeorodrigtravellogger;

import com.example.eorodrigtravellogger.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;

public class MainActivity extends Activity {

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
    
    
    /*Buttons*/
    /*This is the View Edit Submit button*/
    public void onClickViewEditSubmitClaim(View view){
    	 Intent intent = new Intent(MainActivity.this, ViewEditSubmitClaimListActivity.class);
    	 startActivity(intent);
    }
    
    /*This is the make new claim button*/
    public void onClickAddNewClaim(View view){
   	 	Intent intent = new Intent(MainActivity.this, NewClaimActivity.class);
   	 	startActivity(intent);
   }
    
    /*This is the view submitted claims button*/
    public void onClickViewSubmittedClaims(View view){
   	 	Intent intent = new Intent(MainActivity.this, SubmittedClaimsActivity.class);
   	 	startActivity(intent);
   }
    
    
}
