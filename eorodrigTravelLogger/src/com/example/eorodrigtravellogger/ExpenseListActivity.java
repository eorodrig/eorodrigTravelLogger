package com.example.eorodrigtravellogger;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ExpenseListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_expense_list);
		
		/*
		ListView listView = (ListView) findViewById(R.id.ExpenseExpandableListView);
		ArrayList<Claim> list = new ArrayList<Claim>();
		Claim claim = new Claim("Acommedations:Hotel\n2 night Marriot Hotel\nDecember 14,2014\n$234.4 CAD");
		Claim claim2 = new Claim("Travel:Air Fair\nPlane ticket From Edmonton to Calgary\nDecember 14,2014\n$430.34 CAD");
		Claim claim3 = new Claim("Travel:Vehicle Rental\n1 day car rental\nDecember 14,2014\n$420.34 CAD");
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
		getMenuInflater().inflate(R.menu.expense_list, menu);
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
