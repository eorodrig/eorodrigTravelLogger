package com.example.travellogger;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class NewExpenseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_expense);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_expense, menu);
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
	
	public void onClickAddExpenseButton(View view){
		
		String expenseType, expenseDescription;
		String ed, em, ey, expenseDate;
		String currency, amount;

		
		TextView dataExtractor;
		Spinner spinnerExtractor;
		
		spinnerExtractor = (Spinner)findViewById(R.id.NewExpenseTypeSpinner);
		expenseType = spinnerExtractor.getSelectedItem().toString();
	
		
		dataExtractor = (TextView)findViewById(R.id.NewExpenseDescriptionText);
		expenseDescription = dataExtractor.getText().toString();
		
		
		dataExtractor = (TextView)findViewById(R.id.NewExpenseDayText);
		ed = dataExtractor.getText().toString();
		dataExtractor = (TextView)findViewById(R.id.NewExpenseMonthText);
		em = dataExtractor.getText().toString();
		dataExtractor = (TextView)findViewById(R.id.NewExpenseYearText);
		ey = dataExtractor.getText().toString();
		expenseDate = ed + "/" + em +"/" + ey;
		
		dataExtractor = (TextView)findViewById(R.id.NewExpenseAmountText);
		amount = dataExtractor.getText().toString();
		spinnerExtractor = (Spinner)findViewById(R.id.NewExpenseCurrencySpinner);
		currency = spinnerExtractor.getSelectedItem().toString();
		
		
		if (((expenseDescription.isEmpty()) || (ed.isEmpty()) || (em.isEmpty()) || (ey.isEmpty())  ||(amount.isEmpty())))
			{ 
				Toast toast = Toast.makeText(NewExpenseActivity.this, "Complete All Fields Before Adding Expense", Toast.LENGTH_LONG);
				toast.show();

			}
		else
		{
			Expense newExpense = new Expense(expenseDate,expenseType, expenseDescription, Double.valueOf(amount), currency);
			
			ExpenseController expenseController = new ExpenseController();
			expenseController.addExpense(newExpense);
			
			//MainActivity.claimList.addClaim(newClaim);

			Toast toast = Toast.makeText(NewExpenseActivity.this, "New Claim Added", Toast.LENGTH_SHORT);
			toast.show();

			
			//toast = Toast.makeText(NewClaimActivity.this, claimController.getClaimList().getClaims().get(0).toString(), Toast.LENGTH_SHORT);
			//toast.show();
			
			onBackPressed();
		}
		

	}
}
