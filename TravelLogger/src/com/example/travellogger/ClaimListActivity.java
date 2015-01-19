package com.example.travellogger;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ClaimListActivity extends Activity{


	
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
				int claimlistSize = claimList.size();
				int claimlistNewSize = ClaimController.getClaimList().getClaims().size();

				
				if (claimlistNewSize < claimlistSize )
				{
					claimList.addAll(0, ClaimController.getClaimList().getClaims());
					claimList.remove(claimlistSize);
				}
				if (claimlistNewSize > claimlistSize )
				{
					claimList.addAll(0, ClaimController.getClaimList().getClaims());
					claimList.remove(claimlistSize);
				}

				claimAdapter.notifyDataSetChanged();
				
			}
		});
		
		
		listView.setOnItemLongClickListener(new OnItemLongClickListener() {

			
			//http://developer.android.com/guide/topics/ui/dialogs.html  jan  18 710pm
			@Override
			public boolean onItemLongClick(AdapterView<?> adapterView, View view,
					int position, long id) {
				
				AlertDialog.Builder builder = new AlertDialog.Builder(ClaimListActivity.this);
				builder.setCancelable(true);
				final int finalClaimPosition = position;

				builder.setItems(R.array.selected_item_list, new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {

						
						if (which == 0){
							ClaimController cc = new ClaimController();
							cc.setIndexOfCurrentClaim(finalClaimPosition);
					   	 	Intent intent = new Intent(ClaimListActivity.this, ExpenseListActivity.class);
					   	 	startActivity(intent);
						}
						if (which == 1){
							
						}
						if (which == 2){
							
							ClaimController claimController = new ClaimController();
							Claim removedClaim = claimController.getClaimAtIndex(finalClaimPosition);
							
							claimController.removeClaim(removedClaim);

						}
						if (which == 3){


						}
							
						
					}
				});
				
			
				builder.show();

				return false;
			}
		});




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
