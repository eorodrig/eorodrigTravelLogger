package com.example.eorodrigtravellogger;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ViewEditClaimListActivity extends Activity {
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_edit_claim);
		
		ListView listView = (ListView) findViewById(R.id.ClaimListView);
		ArrayList<Claim> list = new ArrayList<Claim>();
		Claim claim = new Claim("Meeting in Calgary\n Dec 12,2014 - Dec 20,2014\n Total: $20 CAD");
		Claim claim2 = new Claim("Meeting in Toronto\n Dec 20,2014 - Dec 24,2014\n Total: $80 USD");

		list.add(claim);
		list.add(claim2);
		
		ArrayAdapter <Claim> claimAdapter = new ArrayAdapter<Claim>(this, android.R.layout.simple_list_item_1, list);
		
		
		listView.setAdapter(claimAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_edit_claim, menu);
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
