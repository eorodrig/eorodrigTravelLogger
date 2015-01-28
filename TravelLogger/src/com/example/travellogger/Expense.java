package com.example.travellogger;

public class Expense {

	protected String date;
	
	protected String category;
	protected String description;
	
	protected double amountSpent;
	protected String currency;
	
	
	
	protected int currencySpinnerID, categorySpinnerID;
	
	
	/**
	 * This is a constructor for an expense item. Every expense needs the following information.
	 * @param expenseDate	= Date expense occurred
	 * @param category		= Category for expense
	 * @param description	= Short description of expense
	 * @param amountSpent	= Expense Amount
	 * @param currency		= Currency Type
	 */
	public Expense(String expenseDate, String category, String description, double amountSpent, String currency, int currencyID, int categoryID){
		this.date = expenseDate;
		this.category = category;
		this.description = description;
		this.amountSpent = amountSpent;
		this.currency = currency;
		this.categorySpinnerID = categoryID;
		this.currencySpinnerID = currencyID;
	}
	
	
	
	/**
	 * This method updates the expense information based on the user information
	 * @param expenseDate	= Date expense occurred
	 * @param category		= Category for expense
	 * @param description	= Short description of expense
	 * @param amountSpent	= Expense Amount
	 * @param currency		= Currency Type
	 */
	public void updateExpense(String expenseDate, String category, String description, double amountSpent, String currency, int currencyID, int categoryID){
		this.date = expenseDate;
		this.category = category;
		this.description = description;
		this.amountSpent = amountSpent;
		this.currency = currency;
		this.categorySpinnerID = categoryID;
		this.currencySpinnerID = currencyID;
	}
	
	
	public String toString(){
		
		return this.category + "\n" + this.description + "\n" + this.date +  "\n" + "Total: " + this.amountSpent  + " " +  this.currency.substring(0, 3)  ; 

		
	}
	
	public String getDate(){
		return date;
	}
	
	public int getCategoryID(){
		return categorySpinnerID;
	}
	
	public String getDescription(){
		return description;
	}
	
	public String getAmount(){
		return String.valueOf(amountSpent);
	}
	
	public int getCurrencyID(){
		return currencySpinnerID;
	}
	
}