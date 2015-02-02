/*
 *     <one line to give the program's name and a brief idea of what it does.>
    Copyright (C) <2015>  <Edwin Rodriguez eorodrig@ualberta.ca>

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.eorodrig.TravelLogger;


import java.util.ArrayList;
import com.eorodrig.TravelLogger.R;
import android.app.Activity;
import android.app.AlertDialog;
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

public class ClaimListActivity extends Activity{

	//these are needed to update the Activity and to save
	private Context context;
	ArrayAdapter <Claim> cadp;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_claim_list);
		
		//save current context
		context = this;
		
		/*Load the GSON file*/
		ClaimController controller = new ClaimController();
		controller.load(context);
		//This will remove all the old listeners as they result in null point exceptions
		ClaimController.getClaimList().removeAllListeners();
		
		
		//this will set up the claim adapter
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

		
	@Override
	protected void onResume(){
		super.onResume();
		
		//On resume, ie return from a different activity..Add up all the expenses and refresh activity
		ClaimController.getClaimList().addExpenses();
		cadp.notifyDataSetChanged();
		
	}

	
	@Override
	protected void onPause(){
		super.onPause();

	}
	
	
	
	/**
	 * This sets up the long click listener
	 **/
	private void setupLongClickListener(ListView listView) {
		
		//set up the listener
		listView.setOnItemLongClickListener(new OnItemLongClickListener() {

			
			// Source: http://developer.android.com/guide/topics/ui/dialogs.html  jan  18 710pm
			//this will set up a long click listener
			@Override
			public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
				
				//this makes a new builder
				AlertDialog.Builder builder = new AlertDialog.Builder(ClaimListActivity.this);
				builder.setCancelable(true);
				
				//position of claim
				final int finalClaimPosition = position;

				try {
					//if the claim is editable
					if (ClaimController.getClaimList().getClaim(position).isEditable()){
						
						//this sets up the on long click menu
						builder.setItems(R.array.selected_item_list, new OnClickListener() {
							
							//this will direct the app to the correct action
							@Override
							public void onClick(DialogInterface dialog, int which) {
								//view
								if (which == 0){

									//it will change the activity to the expenseList activity
									ClaimController claimController = new ClaimController();
									claimController.setIndexOfCurrentClaim(finalClaimPosition);
							   	 	Intent intent = new Intent(ClaimListActivity.this, ExpenseListActivity.class);
							   	 	startActivity(intent);
								}
								//edit
								if (which == 1){
										
									//this will change the activity to the new claim activity
									ClaimController claimController = new ClaimController();
									claimController.setIndexOfCurrentClaim(finalClaimPosition);
											
									claimController.setClaimToEdit(finalClaimPosition);
									Intent intent = new Intent(ClaimListActivity.this, NewClaimActivity.class);
									startActivity(intent);

								}
								//delete
								if (which == 2)
								{
									
									//this will delete the selected item from the claim list
									ClaimController claimController = new ClaimController();
									Claim removedClaim = claimController.getClaimAtIndex(finalClaimPosition);
											
									claimController.removeClaim(removedClaim);
								}
								//submit
								if (which == 3){
									
									//this will submit the current claim
									ClaimController claimController = new ClaimController();
									claimController.submitClaim(finalClaimPosition);
								}	
							}					
						});
						
					}
					
					//if the claim is not editable (ie, Submitted or Approved)
					else
					{
						//this sets up the admin menu
						builder.setItems(R.array.uneditable_item_list, new OnClickListener() {
							
							//this will direct the app to the correct action
							@Override
							public void onClick(DialogInterface dialog, int which) {


								//view
								if (which == 0){
									
									//this will change the current activity to the expense list activity
									ClaimController claimController = new ClaimController();
									claimController.setIndexOfCurrentClaim(finalClaimPosition);
							   	 	Intent intent = new Intent(ClaimListActivity.this, ExpenseListActivity.class);
							   	 	startActivity(intent);
								}
								
								//approve
								if (which == 1){
									
									//this will approve the current claim
									ClaimController claimController = new ClaimController();
									claimController.approveClaim(finalClaimPosition);

								}
								
								//return
								if (which == 2){
									
									//this will return the current claim
									ClaimController claimController = new ClaimController();
									claimController.returnClaim(finalClaimPosition);

								}

							}});
					}
				} catch (EmptyClaimException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				builder.show();
				return false;
			}
		});
			
		}
	
	
	
	
	/**
	 * This will setup the Listener and add it to the listener list
	 * @param claimList
	 * @param claimAdapter
	 */
	private void setupControllerListener(final ArrayList<Claim> claimList, final ArrayAdapter<Claim> claimAdapter) {
		
		//adds the listener
		ClaimController.getClaimList().addListener(new Listener(){
			
			//we set the update method for the listener
			@Override
			public void update(){
				
				//update the current activity
				claimAdapter.notifyDataSetChanged();
				
				//save changes to file
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
