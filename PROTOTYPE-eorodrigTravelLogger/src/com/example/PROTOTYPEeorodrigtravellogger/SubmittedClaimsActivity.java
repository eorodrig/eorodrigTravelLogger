package com.example.PROTOTYPEeorodrigtravellogger;

import java.util.ArrayList;

import com.example.eorodrigtravellogger.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SubmittedClaimsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_submitted_claims);
		
		/*
		ListView listView = (ListView) findViewById(R.id.SubmittedClaimListView);
		ArrayList<Claim> list = new ArrayList<Claim>();
		Claim claim = new Claim("Pending:	Meeting in Calgary\nDec 12,2014 - Dec 20,2014\nTotal: $20 CAD");
		Claim claim2 = new Claim("Approved:	Meeting in Toronto\nDec 20,2014 - Dec 24,2014\nTotal: $80 USD");
		Claim claim3 = new Claim("Rejected:	Meeting in NY\nOct 20,2014 - Oct 24,2014\nTotal: $245 USD");
		list.add(claim);
		list.add(claim2);
		list.add(claim3);
		ArrayAdapter <Claim> claimAdapter = new ArrayAdapter<Claim>(this, android.R.layout.simple_list_item_1, list);
		
		
		listView.setAdapter(claimAdapter);
		*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.submitted__claims, menu);
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
