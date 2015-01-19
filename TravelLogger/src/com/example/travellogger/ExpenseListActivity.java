package com.example.travellogger;

import java.util.ArrayList;

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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemLongClickListener;

public class ExpenseListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_expense_list);
		
		ListView listView = (ListView)findViewById(R.id.ExpenseListView);

		
		final ExpenseController expenseController = new ExpenseController();
		expenseController.setCurrentClaim();

		
		final ArrayList<Expense> expenseList = ExpenseController.getExpenseList().getExpenseList();
		
		final ArrayAdapter <Expense> expenseAdapter = new ArrayAdapter<Expense>(this, android.R.layout.simple_list_item_1, expenseList);
		
		listView.setAdapter(expenseAdapter);
		
		
		//add observer
		
		ExpenseController.getExpenseList().addListener(new Listener(){
			@Override
			public void update(){
				
				expenseController.updateExpenses();
				
				int expenseListSize = expenseList.size();
				int expenseListNewSize = ExpenseController.getExpenseList().getExpenseList().size();
					

				
				if (expenseListNewSize < expenseListSize )
				{
					expenseList.addAll(0, ExpenseController.getExpenseList().getExpenseList());
					expenseList.remove(expenseListSize);
				}
				if (expenseListNewSize > expenseListSize )
				{
					expenseList.addAll(0, ExpenseController.getExpenseList().getExpenseList());
					expenseList.remove(expenseListSize);
				}

				expenseAdapter.notifyDataSetChanged();
				
			}
		});
		
	


		listView.setOnItemLongClickListener(new OnItemLongClickListener() {

			
			//http://developer.android.com/guide/topics/ui/dialogs.html  jan  18 710pm
			@Override
			public boolean onItemLongClick(AdapterView<?> adapterView, View view,
					int position, long id) {
				
				AlertDialog.Builder builder = new AlertDialog.Builder(ExpenseListActivity.this);
				builder.setCancelable(true);
				final int finalExpensePosition = position;
				//Toast.makeText(ClaimListActivity.this, claimList.get(position).toString(), Toast.LENGTH_SHORT).show();
				
			   //builder.setItems(R.array.selected_item_list, new OnClickListener());

				builder.setItems(R.array.selected_expense_list, new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						//Toast.makeText(ClaimListActivity.this, String.valueOf(which), Toast.LENGTH_SHORT).show();
						//edit
						if (which == 0){
							ExpenseController expenseController = new ExpenseController();
							expenseController.setIndexOfCurrentExpense(finalExpensePosition);
							
							expenseController.setExpenseToEdit();
							
							//Toast.makeText(ExpenseListActivity.this, , Toast.LENGTH_SHORT).show();
					   	 	Intent intent = new Intent(ExpenseListActivity.this, NewExpenseActivity.class);
					   	 	startActivity(intent);
						}
						//delete
						if (which == 1){
							
							Expense removedExpense = expenseController.getExpense(finalExpensePosition);
							
							
							
							expenseController.removeExpense(removedExpense);

						}
							
						
					}
				});
				
			
				builder.show();
				   // return builder.create();

				              

				
				//Toast.makeText(ClaimListActivity.this, claimList.get(position).toString(), Toast.LENGTH_SHORT).show();
				// TODO Auto-generated method stub
				return false;
			}
		});
	
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.expense_list, menu);
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
	
	
	
	public void onClickNewExpenseButton(View view){
		Intent intent = new Intent(ExpenseListActivity.this, NewExpenseActivity.class);
		startActivity(intent);
	}
	
}

