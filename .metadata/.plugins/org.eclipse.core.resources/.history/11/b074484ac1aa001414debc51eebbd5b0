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

import java.util.Date;

import com.eorodrig.TravelLogger.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class NewExpenseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_expense);
		
		DatePicker edp = (DatePicker) findViewById(R.id.expenseDatePicker);
		edp.setCalendarViewShown(false);
		
	}
	
	
	@Override
	protected void onResume(){

		super.onResume();
		
		//We make an expense controller
		ExpenseController expenseController = new ExpenseController();
		
		
		//if this is null, we make a new claim, else we edit a claim
		if (expenseController.getExpenseToEdit() ==null){
			this.initNewExpense(expenseController);
		}
		else
		{
			this.initEditExpense(expenseController);
		}
	}

	
	



	/*This will init the form and format it as a new expense*/
	private void initNewExpense(ExpenseController expenseController){
		expenseController.setEditStatus(false);
		
		Button button = (Button) findViewById(R.id.AddExpenseButton);			
		button.setText("Add New Expense");

		
	}
	
	/*This will init the form and format it as an edit expense form with filled out fields*/
	private void initEditExpense(ExpenseController expenseController) {
		
		//gets the current expense
		Expense editableExpense = expenseController.getExpenseToEdit();
		
		//This is the types we will use
		TextView dataExtractor;
		Spinner spinnerExtractor;
		DatePicker dateExtractor;
		
		//claim type
		spinnerExtractor = (Spinner)findViewById(R.id.NewExpenseTypeSpinner);
		spinnerExtractor.setSelection(editableExpense.getCategoryID());
		
		//claim description
		dataExtractor = (TextView)findViewById(R.id.NewExpenseDescriptionText);
		dataExtractor.setText(editableExpense.getDescription());
		
		//claim date
		dateExtractor = (DatePicker) findViewById(R.id.expenseDatePicker);
		dateExtractor.init(editableExpense.getDate().getYear()+1900, editableExpense.getDate().getMonth(), editableExpense.getDate().getDate(), null);
	
		//currency spinner
		spinnerExtractor = (Spinner)findViewById(R.id.NewExpenseCurrencySpinner);
		spinnerExtractor.setSelection(editableExpense.getCurrencyID());
		
		//amount
		dataExtractor = (TextView)findViewById(R.id.NewExpenseAmountText);
		dataExtractor.setText(editableExpense.getAmount());
		
		/*resets the edit parameter*/
		expenseController.resetExpenseToEdit();
		
		/*Sets the state of the expense to edit*/
		expenseController.setEditStatus(true);
		
		
		Button button = (Button) findViewById(R.id.AddExpenseButton);			
		button.setText("Edit Expense");
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
		Date expenseDate;
		String currency, amount;
		
		//spinner position
		int categoryID,currencyID;

		//types
		TextView dataExtractor;
		Spinner spinnerExtractor;
		DatePicker dateExtractor;
		
		//expense type
		spinnerExtractor = (Spinner)findViewById(R.id.NewExpenseTypeSpinner);
		expenseType = spinnerExtractor.getSelectedItem().toString();
		categoryID = spinnerExtractor.getSelectedItemPosition();
	
		//expense description
		dataExtractor = (TextView)findViewById(R.id.NewExpenseDescriptionText);
		expenseDescription = dataExtractor.getText().toString();
		
		//expense Date
		dateExtractor = (DatePicker)findViewById(R.id.expenseDatePicker);
		expenseDate = new Date(dateExtractor.getYear()-1900, dateExtractor.getMonth(), dateExtractor.getDayOfMonth());
		
		//amount
		dataExtractor = (TextView)findViewById(R.id.NewExpenseAmountText);
		amount = dataExtractor.getText().toString();
		
		//currency
		spinnerExtractor = (Spinner)findViewById(R.id.NewExpenseCurrencySpinner);
		currency = spinnerExtractor.getSelectedItem().toString();
		currencyID = spinnerExtractor.getSelectedItemPosition();
		
		
		//verify that the fields are filled out
		if (((expenseDescription.isEmpty()) ||(amount.isEmpty())))
			{ 
				Toast toast = Toast.makeText(NewExpenseActivity.this, "Complete All Fields Before Adding Expense", Toast.LENGTH_LONG);
				toast.show();

			}
		else
		{
			//new expense
			Expense newExpense = new Expense(expenseDate,expenseType, expenseDescription, Double.valueOf(amount), currency, currencyID, categoryID);
			
			//new expense controller
			ExpenseController expenseController = new ExpenseController();
			
			
			
			// Add new expense
			if (expenseController.getEditStatus() == false){
				Toast toast = Toast.makeText(NewExpenseActivity.this, "New Expense Added", Toast.LENGTH_SHORT);
				toast.show();
				expenseController.addExpense(newExpense);
				

			}
			
			//else edit expense
			else
			{
				expenseController.editExpense(newExpense);
				Toast toast = Toast.makeText(NewExpenseActivity.this, "Edited Expense", Toast.LENGTH_SHORT);
				toast.show();
			}

			finish();
		}
		

	}
}
