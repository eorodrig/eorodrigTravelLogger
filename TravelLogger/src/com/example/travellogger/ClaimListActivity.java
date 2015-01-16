package com.example.travellogger;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

public class ClaimListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_claim_list);
		
		
		ArrayList<Claim> list = new ArrayList<Claim>();
		
		
		list = MainActivity.claimList.getClaims();
	
		
		Toast toast = Toast.makeText(ClaimListActivity.this, String.valueOf(list.size()) , Toast.LENGTH_SHORT);
		toast.show();
		
		if (list.size() > 0){
		toast = Toast.makeText(ClaimListActivity.this, list.get(0).toString() , Toast.LENGTH_SHORT);
		toast.show();
		
		ArrayAdapter<Claim> claimAdapter = new ArrayAdapter<Claim>(this, android.R.layout.simple_list_item_1, list);
		
		ListView listView = (ListView) findViewById(R.id.ClaimListView);
		listView.setAdapter(claimAdapter);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.claim_list, menu);
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
	
	
	
}
