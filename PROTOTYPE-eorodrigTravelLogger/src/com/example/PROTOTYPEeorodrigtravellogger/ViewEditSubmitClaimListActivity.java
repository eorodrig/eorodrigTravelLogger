package com.example.PROTOTYPEeorodrigtravellogger;

import java.util.ArrayList;
import java.util.Date;

import com.example.eorodrigtravellogger.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ViewEditSubmitClaimListActivity extends Activity {
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_edit_submit_claim);
		
		ListView listView = (ListView) findViewById(R.id.ClaimListView);
		ArrayList<Claim> list = new ArrayList<Claim>();
		
		Date dateA1 = new Date(2014,11,12);
		Date dateA2 = new Date(2014,12,20);
		
		Date dateB1 = new Date(2014,12,20);
		Date dateB2 = new Date(2014,12,24);
		Claim claim = new Claim("Meeting in Calgary","Team meeting for QWE Project", dateA1, dateA2, "CAD");
		Claim claim2 = new Claim("Meeting in Toronto", "Team meeting for wwwE Project", dateB1, dateB2, "USD");
		
		claim.editAmount(242.32);
		claim2.editAmount(452.12);
		
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
