package com.eorodrig.TravelLogger;

import java.util.ArrayList;
import java.util.Date;

import android.text.format.DateFormat;

public class Claim {

	protected String claimName;
	protected String claimDescription;
	
	protected String startDate;
	protected String endDate;
	
	protected Date start;
	protected Date end;

	protected double totalAmount;
	
	protected String claimStatus;
	
	
	protected ExpenseList expenseList;
	
	
	/**
	 * This is a the constructor for a claim. Every claim needs the following parameters.
	 * We also init the claim amount to 0.
	 * @param name = Claim Name
	 * @param description = claim description
	 * @param start = Start Date
	 * @param end = End Date
	 * @param currencyType = Currency Type for Claim
	 */
	public Claim(String name, String description, Date start, Date end) {
		this.claimName = name;
		this.claimDescription = description;
		this.start = start;
		this.end = end;
		this.totalAmount = 0;
		this.claimStatus = "In Progress";
		this.expenseList = new ExpenseList();

	}
	
		
	/**
	 * This updates the claim amount
	 * @param newAmount = the new amount for the claim
	 */
	public void editAmount(double newAmount){
		this.totalAmount = newAmount;
	}
	
	
	/**
	 * This will return the status of a claim.
	 * @return	= Status of the claim
	 */
	public String getStatus(){
		return this.claimStatus;
	}
	
	/**
	 * This updates the claim status
	 * @param status = the new claim status
	 */
	public void setStatus(String status){
		this.claimStatus = status;
	}

	
	/*
	 * Editting claim methods
	 */
	
	/**
	 * This is is a master edit claim method. it updates a claim
	 * We also init the claim amount to 0.
	 * @param name = Claim Name
	 * @param description = claim description
	 * @param start = Start Date
	 * @param end = End Date
	 * @param currencyType = Currency Type for Claim
	 */
	public void editClaim(String name, String description, Date start, Date end) {
		this.claimName = name;
		this.claimDescription = description;
		this.start = start;
		this.end = end;

	}
	
	/**
	 * This gets the name of the claim
	 * @return
	 */
	public String getName(){
		return this.claimName;
	}
	
	
	/**
	 * This gets the description of the claim
	 * @return
	 */
	public String getDescription(){
		return claimDescription;
	}
	
	
	/**
	 * This gets the start date for the claim
	 * @return
	 */
	public Date getStartDate(){
		return start;
	}
	
	
	/**
	 * This gets the end date for the claim
	 * @return
	 */
	public Date getEndDate(){
		return end;
	}


	/**
	 * This gets all the expenses associated with a claim
	 * @return
	 */
	
	public ExpenseList getExpenses(){
		
		return this.expenseList;
	}
	
	
	/*
	 * This is needed for the listView
	 * 
	 */
	/**
	 * This method returns a formatted string of a claim. It is in the form required by the ViewTestList
	 */
	public String toString(){
		
		DateFormat dateFormat = new DateFormat();
		
		
		this.startDate = dateFormat.format("dd-MMM-yyyy", this.start).toString();
		this.endDate = dateFormat.format("dd-MMM-yyyy", this.end).toString();
		
		return this.claimName + "\n" + this.claimDescription + "\n" + this.startDate + " to " + this.endDate + "\n" + "Total: " + this.totalAmount   ; 
	}


}
