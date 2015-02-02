package com.eorodrig.TravelLogger;


import java.util.ArrayList;









import com.eorodrig.TravelLogger.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
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

	private Context context;
	ArrayAdapter <Claim> cadp;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_claim_list);
		context = this;
		
		/*Load the GSON file*/
		ClaimController controller = new ClaimController();
		controller.load(context);
		
		ListView listView = (ListView)findViewById(R.id.ClaimListView);
		final ArrayList<Claim> claimList = ClaimController.getClaimList().getClaims();
		final ArrayAdapter <Claim> claimAdapter = new ArrayAdapter<Claim>(this, android.R.layout.simple_list_item_1, claimList);
		listView.setAdapter(claimAdapter);
		cadp = claimAdapter;
		
		
		/*This sets up a controller for the listview*/
		this.setupControllerListener(claimList, claimAdapter);
		
		/*This sets up the listener*/
		this.setupLongClickListener(listView);

		
		}
		//add observer
		
	@Override
	protected void onResume(){
		super.onResume();

		//ClaimController.getClaimList().addExpenses();
		//cadp.notifyDataSetChanged();
		
		ListView listView = (ListView)findViewById(R.id.ClaimListView);
		final ArrayList<Claim> claimList = ClaimController.getClaimList().getClaims();
		final ArrayAdapter <Claim> claimAdapter = new ArrayAdapter<Claim>(this, android.R.layout.simple_list_item_1, claimList);
		listView.setAdapter(claimAdapter);
		cadp = claimAdapter;
		cadp.notifyDataSetChanged();
		
		/*This sets up a controller for the listview*/
		this.setupControllerListener(claimList, claimAdapter);
	}

	
	@Override
	protected void onPause(){
		super.onPause();

	}
	
	
	/*This sets up the long click listener*/
	private void setupLongClickListener(ListView listView) {
		
		//set up the listener
		listView.setOnItemLongClickListener(new OnItemLongClickListener() {

			
			//http://developer.android.com/guide/topics/ui/dialogs.html  jan  18 710pm
			@Override
			public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
				
				//this makes a new builder
				AlertDialog.Builder builder = new AlertDialog.Builder(ClaimListActivity.this);
				builder.setCancelable(true);
				
				//position of claim
				final int finalClaimPosition = position;

				//this sets up the menu items for the on hold menu
				builder.setItems(R.array.selected_item_list, new OnClickListener() {
					
					//this will direct the app to the correct action
					@Override
					public void onClick(DialogInterface dialog, int which) {

						//view
						if (which == 0){

							ClaimController claimController = new ClaimController();
							claimController.setIndexOfCurrentClaim(finalClaimPosition);
					   	 	Intent intent = new Intent(ClaimListActivity.this, ExpenseListActivity.class);
					   	 	startActivity(intent);
						}
						//edit
						if (which == 1){
							ClaimController claimController = new ClaimController();
							claimController.setIndexOfCurrentClaim(finalClaimPosition);
							
							claimController.setClaimToEdit(finalClaimPosition);
					   	 	Intent intent = new Intent(ClaimListActivity.this, NewClaimActivity.class);
					   	 	startActivity(intent);
							
						}
						//delete
						if (which == 2){
							
							ClaimController claimController = new ClaimController();
							Claim removedClaim = claimController.getClaimAtIndex(finalClaimPosition);
							
							claimController.removeClaim(removedClaim);
							
						}
						//submit
						if (which == 3){


						}
							
						
					}
				});
				
			
				builder.show();

				return false;
			}
		});
			
		}
	
	
	
	
	//this will set up the controller listener
	private void setupControllerListener(final ArrayList<Claim> claimList, final ArrayAdapter<Claim> claimAdapter) {
		
		//adds the listener
		ClaimController.getClaimList().addListener(new Listener(){
			
			//we set the update method for the listener
			@Override
			public void update(){


				claimAdapter.notifyDataSetChanged();
				
				ClaimController controller = new ClaimController();
				
				controller.save(context);
				
				
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
	
	/**
	 * This is the onClick method for the Add New Claim Button
	 * @param view
	 */
    public void onClickAddNewClaim(View view){
   	 	Intent intent = new Intent(ClaimListActivity.this, NewClaimActivity.class);
   	 	startActivity(intent);
   }

}
