package com.example.travellogger;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class NewClaimActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_claim);
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
			
			
			if ((claim.isEmpty()) || (claimDescription.isEmpty()) || (fd.isEmpty()) || (fm.isEmpty()) || (fy.isEmpty())  || (td.isEmpty()) || (tm.isEmpty()) || (ty.isEmpty()))
				{ 
					Toast toast = Toast.makeText(NewClaimActivity.this, "Complete All Fields Before Adding Claim", Toast.LENGTH_LONG);
					toast.show();

				}
			else
			{
				Claim newClaim = new Claim(claim, claimDescription, fromDate, toDate, currency);
				ClaimController claimController = new ClaimController();
				
				claimController.addClaim(newClaim);
				
				//MainActivity.claimList.addClaim(newClaim);

				Toast toast = Toast.makeText(NewClaimActivity.this, "New Claim Added", Toast.LENGTH_SHORT);
				toast.show();
	
				
				//toast = Toast.makeText(NewClaimActivity.this, claimController.getClaimList().getClaims().get(0).toString(), Toast.LENGTH_SHORT);
				//toast.show();
				
				onBackPressed();
			}
			

		}
}
