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

import android.text.format.DateFormat;

public class Expense implements Comparable<Expense>{

	//these are the basic attributes for an expense
	protected Date date;
	protected String expenseDate;
	
	protected String category;
	protected String description;
	
	protected double amountSpent;
	protected String currency;

	//these will hold the position of the spinners (For editing purposes
	protected int currencySpinnerID, categorySpinnerID;
	
	
	/**
	 * This is a constructor for an expense item. Every expense needs the following information.
	 * @param expenseDate	= Date expense occurred
	 * @param category		= Category for expense
	 * @param description	= Short description of expense
	 * @param amountSpent	= Expense Amount
	 * @param currency		= Currency Type
	 */
	public Expense(Date expenseDate, String category, String description, double amountSpent, String currency, int currencyID, int categoryID){
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
	public void updateExpense(Date expenseDate, String category, String description, double amountSpent, String currency, int currencyID, int categoryID){
		this.date = expenseDate;
		this.category = category;
		this.description = description;
		this.amountSpent = amountSpent;
		this.currency = currency;
		this.categorySpinnerID = categoryID;
		this.currencySpinnerID = currencyID;
	}
	
	
	
	/**
	 * This is needed for the view list. It will convert all of the attributes to a formatted string
	 */
	public String toString(){
		
		//this is needed to format the date
		DateFormat dateFormat = new DateFormat();
		
		//this wil format the date
		this.expenseDate = dateFormat.format("dd-MMM-yyyy", this.date).toString();
		
		//this will format the expense into a readable string
		return this.category + "\n" + this.description + "\n" + this.expenseDate +  "\n" + "Total: " + this.amountSpent  + " " +  this.currency.substring(0, 3)  ; 
		
	}
	
	//////////////////////////////////////
	/*
	 * These are the getters for the basic expense attributes
	 */
	////////////////////////////////////////////
	public Date getDate(){
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
	
	public String getCurrency(){
		return currency;
	}


	////////////////////////////
	/*
	 * This will compare the the expenses by  date
	 */
	//////////////////////////////
	/**
	 * This is the compare method required by the Collections.sort method	
	 * Expense will return -1 if:
	 * 		Caller is before the parameter
	 * 	Expense will return 1 if:
	 * 		Caller is after the parameter
	 * else it will return 0 if both dates are the same
	 */
	@Override
	public int compareTo(Expense rhs) {
		if (this.getDate().before(rhs.getDate()))
		{
			return -1;
		}
		else if (this.getDate().after(rhs.getDate()))
		{
			return 1;
		}

		return 0;
	
	}
	
}