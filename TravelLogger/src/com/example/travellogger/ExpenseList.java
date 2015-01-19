package com.example.travellogger;

import java.util.ArrayList;


public class ExpenseList {

	protected ArrayList<Expense> expenseList;
	protected ArrayList<Listener> listeners;
	
	public ExpenseList(){
		expenseList = new ArrayList<Expense>();
		listeners = new ArrayList<Listener>();
	}
	
	
	public ArrayList<Expense> getExpenseList(){
		return expenseList;
	}
	
	
	public void addExpense(Expense newExpense){
		expenseList.add(newExpense);
		notifyListeners();
	}
	
	public void removeExpense(Expense Expense){
		expenseList.remove(Expense);
		notifyListeners();
	}
	
	
	public void addListener(Listener listener){
		listeners.add(listener);
	}
	
	private void notifyListeners(){
		for (Listener listener: listeners){
			listener.update();
		}
		
	}
	
	private void removeListener(Listener listener){
		listeners.remove(listener);
	}
	
	public void removeAllListeners(){
		listeners.clear();
	}
	
	
	
}