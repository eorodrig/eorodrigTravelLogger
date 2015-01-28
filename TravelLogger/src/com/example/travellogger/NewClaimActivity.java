package com.example.travellogger;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class NewClaimActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_claim);
		
		ClaimController claimController = new ClaimController();
		
		//if not null, we edit
		if (claimController.getClaimToEdit() ==null){
			claimController.setEditStatus(false);
			
			Button button = (Button) findViewById(R.id.NewClaimAddButton);
			button.setText("Add New Claim");
		}
		else
			{
			Claim editableClaim = claimController.getClaimToEdit();
			TextView dataExtractor;
			Spinner spinnerExtractor;
			
		
			
			dataExtractor = (TextView)findViewById(R.id.NewClaimNameText);
			dataExtractor.setText(editableClaim.getName());
			
			dataExtractor = (TextView)findViewById(R.id.NewClaimDescriptionText);
			dataExtractor.setText(editableClaim.getDescription());
			
			
			
			String day, month, year;
			
			day = editableClaim.getStartDate().substring(0, 2);
			month = editableClaim.getStartDate().substring(3, 5);
			year = editableClaim.getStartDate().substring(6, 10);
			
			dataExtractor = (TextView)findViewById(R.id.NewClaimFromDayText);
			dataExtractor.setText(day);
			dataExtractor = (TextView)findViewById(R.id.NewClaimFromMonthText);
			dataExtractor.setText(month);
			dataExtractor = (TextView)findViewById(R.id.NewClaimFromYearText);
			dataExtractor.setText(year);
			
			day = editableClaim.getEndDate().substring(0, 2);
			month = editableClaim.getEndDate().substring(3, 5);
			year = editableClaim.getEndDate().substring(6, 10);
			
			dataExtractor = (TextView)findViewById(R.id.NewClaimToDayText);
			dataExtractor.setText(day);
			dataExtractor = (TextView)findViewById(R.id.NewClaimToMonthText);
			dataExtractor.setText(month);
			dataExtractor = (TextView)findViewById(R.id.NewClaimToYearText);
			dataExtractor.setText(year);
			
			
			spinnerExtractor = (Spinner)findViewById(R.id.NewClaimCurrencySpinner);
			spinnerExtractor.setSelection(editableClaim.getCurrencySpinnerID());
			
			claimController.resetClaimToEdit();
			claimController.setEditStatus(true);
			
			Button button = (Button) findViewById(R.id.NewClaimAddButton);
			button.setText("Edit Claim");

			}
		
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
			String fd, fm, fy, fromDate;
			String td, tm, ty, toDate;
			String currency;
			int currencySpinnerID;
			
			
			TextView dataExtractor;
			Spinner spinnerExtractor;
			
			dataExtractor = (TextView)findViewById(R.id.NewClaimNameText);
			claim = dataExtractor.getText().toString();		
		
			
			dataExtractor = (TextView)findViewById(R.id.NewClaimDescriptionText);
			claimDescription = dataExtractor.getText().toString();
			
			
			dataExtractor = (TextView)findViewById(R.id.NewClaimFromDayText);
			fd = dataExtractor.getText().toString();
			dataExtractor = (TextView)findViewById(R.id.NewClaimFromMonthText);
			fm = dataExtractor.getText().toString();
			dataExtractor = (TextView)findViewById(R.id.NewClaimFromYearText);
			fy = dataExtractor.getText().toString();
			fromDate = fd + "/" + fm +"/" + fy;
			
			dataExtractor = (TextView)findViewById(R.id.NewClaimToDayText);
			td = dataExtractor.getText().toString();
			dataExtractor = (TextView)findViewById(R.id.NewClaimToMonthText);
			tm = dataExtractor.getText().toString();
			dataExtractor = (TextView)findViewById(R.id.NewClaimToYearText);
			ty = dataExtractor.getText().toString();
			toDate = td + "/" + tm +"/" + ty;
			
			spinnerExtractor = (Spinner)findViewById(R.id.NewClaimCurrencySpinner);
			currency = spinnerExtractor.getSelectedItem().toString();
			currencySpinnerID = spinnerExtractor.getSelectedItemPosition();
			
			
			
			if ((claim.isEmpty()) || (claimDescription.isEmpty()) || (fd.isEmpty()) || (fm.isEmpty()) || (fy.isEmpty())  || (td.isEmpty()) || (tm.isEmpty()) || (ty.isEmpty()))
				{ 
					Toast toast = Toast.makeText(NewClaimActivity.this, "Complete All Fields Before Adding Claim", Toast.LENGTH_LONG);
					toast.show();

				}
			else
			{
				Claim newClaim = new Claim(claim, claimDescription, fromDate, toDate, currency, currencySpinnerID);
				ClaimController claimController = new ClaimController();
				
				if (claimController.getEditStatus() == false){
					claimController.addClaim(newClaim);
				}
				else
				{
					claimController.editClaim(newClaim);
				}
				
				//MainActivity.claimList.addClaim(newClaim);

				Toast toast = Toast.makeText(NewClaimActivity.this, "New Claim Added", Toast.LENGTH_SHORT);
				toast.show();
	
				
				//toast = Toast.makeText(NewClaimActivity.this, claimController.getClaimList().getClaims().get(0).toString(), Toast.LENGTH_SHORT);
				//toast.show();
				
				onBackPressed();
			}
			

		}
}