package com.example.PROTOTYPEeorodrigtravellogger;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.eorodrigtravellogger.R;

import android.app.Activity;
import android.net.ParseException;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
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
	

	/*
	public void testing(View view)
	{
		TextView testing = (TextView)findViewById(R.id.ClaimStartDateText);
		
		SimpleDateFormat dt = new SimpleDateFormat("dd/mm/yyyy");		
		

		
		String test = "";
		Date date = new Date();
		
		
			try {
				date = dt.parse(testing.getText().toString());
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				Toast toasty = Toast.makeText(NewClaimActivity.this, "Failed", Toast.LENGTH_SHORT);
			}	
			

		test = new SimpleDateFormat("MMM dd,yyyy").format(date);
		

		
		Toast toast = Toast.makeText(NewClaimActivity.this, test , Toast.LENGTH_LONG);
		toast.show();
		
		
		
		//System.out.println(testing);
	}
*/
	

	
}
