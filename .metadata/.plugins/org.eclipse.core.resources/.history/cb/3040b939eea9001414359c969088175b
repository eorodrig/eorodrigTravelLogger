package com.example.travellogger;

import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

public class NewClaimActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_claim);
		
		/*This inits the Date pickers*/
		DatePicker fdp = (DatePicker) findViewById(R.id.fromDate);
		DatePicker tdp = (DatePicker) findViewById(R.id.toDatePicker);
		fdp.setCalendarViewShown(false);
		tdp.setCalendarViewShown(false);
		
	}
	
	

	@Override
	protected void onResume(){
		super.onResume();
		/*Claim controller for the app*/
		ClaimController claimController = new ClaimController();
		
		
		//if this is null, we make a new claim, else we edit a claim
		if (claimController.getClaimToEdit() ==null){
			this.initNewClaim(claimController);
		}
		else
			{
			this.initEditClaim(claimController);
			}
		
	}
	

	/*This will make format the page so that it looks like a new claim*/
	private void initNewClaim(ClaimController claimController){
		claimController.setEditStatus(false);
		
		Button button = (Button) findViewById(R.id.NewClaimAddButton);
		button.setText("Add New Claim");
	}
	

	/*This will extract the claim information and place it their fields*/
	private void initEditClaim(ClaimController claimController) {
		
		/*Extracts the claim we need to edit*/
		Claim editableClaim = claimController.getClaimToEdit();
		
		/*These Things we need to edit*/
		TextView dataExtractor;
		DatePicker datePicker;
		
		
		/*We set the claim name*/
		dataExtractor = (TextView)findViewById(R.id.NewClaimNameText);
		dataExtractor.setText(editableClaim.getName());
		
		/*we set the claim description*/
		dataExtractor = (TextView)findViewById(R.id.NewClaimDescriptionText);
		dataExtractor.setText(editableClaim.getDescription());
		
		/*we set the claim from date*/
		datePicker = (DatePicker) findViewById(R.id.fromDate);
		datePicker.init(editableClaim.getStartDate().getYear()+1900, editableClaim.getStartDate().getMonth(), editableClaim.getStartDate().getDate(), null);
		
		/*we set the claim from date*/
		datePicker = (DatePicker) findViewById(R.id.toDatePicker);
		datePicker.init(editableClaim.getEndDate().getYear()+1900, editableClaim.getEndDate().getMonth(), editableClaim.getEndDate().getDate(), null);
		
		
		/*resets the edit parameter*/
		claimController.resetClaimToEdit();
		
		/*Sets the state of the claim to edit*/
		claimController.setEditStatus(true);
		
		Button button = (Button) findViewById(R.id.NewClaimAddButton);
		button.setText("Edit Claim");
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_claim, menu);
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
	
	
	
	
	public void onClickAddClaimButton(View view){
		
		
			
			String claim, claimDescription;
			Date start,end;
			
			
			TextView dataExtractor;
			DatePicker dateExtractor;
		
			/*These will extract the data fields from the new claim/edit claim page*/
			
			/*extract claim name*/
			dataExtractor = (TextView)findViewById(R.id.NewClaimNameText);
			claim = dataExtractor.getText().toString();		
		
			/*extract claim description*/
			dataExtractor = (TextView)findViewById(R.id.NewClaimDescriptionText);
			claimDescription = dataExtractor.getText().toString();
		
			/*from Date*/
			dateExtractor = (DatePicker) findViewById(R.id.fromDate);
			start = new Date(dateExtractor.getYear()-1900, dateExtractor.getMonth(), dateExtractor.getDayOfMonth());
			
			/*to Date*/
			dateExtractor = (DatePicker) findViewById(R.id.toDatePicker);
			end = new Date(dateExtractor.getYear()-1900, dateExtractor.getMonth(), dateExtractor.getDayOfMonth());
			
			
			/*verify that the fields are field in*/
			if ((claim.isEmpty()) || (claimDescription.isEmpty()) )
				{ 
					Toast toast = Toast.makeText(NewClaimActivity.this, "Complete All Fields Before Adding Claim", Toast.LENGTH_LONG);
					toast.show();

				}
			/*Add the claim*/
			else
			{
				Claim newClaim = new Claim(claim, claimDescription, start, end);
				ClaimController claimController = new ClaimController();
				
				if (claimController.getEditStatus() == false){
					claimController.addClaim(newClaim);
					Toast toast = Toast.makeText(NewClaimActivity.this, "New Claim Added", Toast.LENGTH_SHORT);
					toast.show();
				}
				else
				{
					claimController.editClaim(newClaim);
					Toast toast = Toast.makeText(NewClaimActivity.this, "Edited Claim", Toast.LENGTH_SHORT);
					toast.show();
				}		

				finish();
			}
		}
}
