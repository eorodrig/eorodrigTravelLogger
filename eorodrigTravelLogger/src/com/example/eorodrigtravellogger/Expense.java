package com.example.eorodrigtravellogger;

import java.util.Date;

public class Expense {

	protected Date date;
	
	protected String category;
	protected String description;
	
	protected double amountSpent;
	protected String currency;
	
	
	/**
	 * This is a constructor for an expense item. Every expense needs the following information.
	 * @param expenseDate	= Date expense occurred
	 * @param category		= Category for expense
	 * @param description	= Short description of expense
	 * @param amountSpent	= Expense Amount
	 * @param currency		= Currency Type
	 */
	public Expense(Date expenseDate, String category, String description, double amountSpent, String currency){
		this.date = expenseDate;
		this.category = category;
		this.description = description;
		this.amountSpent = amountSpent;
		this.currency = currency;
	}
	
	
	
	/**
	 * This method updates the expense information based on the user information
	 * @param expenseDate	= Date expense occurred
	 * @param category		= Category for expense
	 * @param description	= Short description of expense
	 * @param amountSpent	= Expense Amount
	 * @param currency		= Currency Type
	 */
	public void updateExpense(Date expenseDate, String category, String description, double amountSpent, String currency){
		this.date = expenseDate;
		this.category = category;
		this.description = description;
		this.amountSpent = amountSpent;
		this.currency = currency;
	}
	
	
	
}
