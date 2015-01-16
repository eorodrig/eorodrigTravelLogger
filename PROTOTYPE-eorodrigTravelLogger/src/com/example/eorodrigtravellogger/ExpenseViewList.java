package com.example.eorodrigtravellogger;

import java.util.ArrayList;
import java.util.Collection;

public class ExpenseViewList {

	protected ArrayList<Expense> expenseList;
	
	public ExpenseViewList(){
		expenseList = new ArrayList<Expense>();
	}
	
	
	public Collection<Expense> getExpenses(){
		return expenseList;
	}
	
	
	public void addExpense(Expense newExpense){
		expenseList.add(newExpense);
	}
	
	public void removeExpense(Expense Expense){
		expenseList.remove(Expense);
	}
}