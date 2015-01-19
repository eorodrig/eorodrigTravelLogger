package com.example.travellogger;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

public class ClaimListActivity extends Activity implements OnItemClickListener{


	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_claim_list);
		
		ListView listView = (ListView)findViewById(R.id.ClaimListView);
		
		final ArrayList<Claim> claimList = ClaimController.getClaimList().getClaims();
		
		final ArrayAdapter <Claim> claimAdapter = new ArrayAdapter<Claim>(this, android.R.layout.simple_list_item_1, claimList);
		
		listView.setAdapter(claimAdapter);
		
		
		//add observer
		
		ClaimController.getClaimList().addListener(new Listener(){
			@Override
			public void update(){
				claimList.clear();
				claimList.addAll(ClaimController.getClaimList().getClaims());
				
				claimAdapter.notifyDataSetChanged();
				//claimList = ClaimController.getClaimList().getClaims();
			}
		});
		
		
		listView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> adapterView, View view,
					int position, long id) {
				
				Toast.makeText(ClaimListActivity.this, claimList.get(position).toString(), Toast.LENGTH_SHORT).show();
				// TODO Auto-generated method stub
				return false;
			}
		});

		/*
		ArrayList<Claim> list = new ArrayList<Claim>();
		
		//list = ClaimController.getClaimList();
	
	
		Toast toast = Toast.makeText(ClaimListActivity.this, String.valueOf(list.size()) , Toast.LENGTH_SHORT);
		toast.show();
		
		
		if (list.size() > 0){
		toast = Toast.makeText(ClaimL
		
		
		istActivity.this, list.get(0).toString() , Toast.LENGTH_SHORT);
		toast.show();
		
		ArrayAdapter<Claim> claimAdapter = new ArrayAdapter<Claim>(this, android.R.layout.simple_list_item_1, list);
		
	
		
		ListView listView = (ListView) findViewById(R.id.ClaimListView);
		listView.setAdapter(claimAdapter);
		}

*/
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
	
	public void onClaimSelect(View view){

		
		ListView listExtractor;
		int string;
		

		ListView lv = (ListView) findViewById(R.id.ClaimListView);
		
		//Listener listener = new listener();

		
		string = lv.getSelectedItemPosition();
		
		Toast toast = Toast.makeText(ClaimListActivity.this, String.valueOf(string) , Toast.LENGTH_SHORT);
		toast.show();

		
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
	long id) {
		Toast.makeText(ClaimListActivity.this, "You Clicked at ",Toast.LENGTH_SHORT).show();
	//	lv.setOnClickListener(this);
	}
}
