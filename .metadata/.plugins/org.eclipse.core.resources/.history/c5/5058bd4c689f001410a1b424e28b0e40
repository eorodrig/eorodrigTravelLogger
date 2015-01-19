package com.example.travellogger;

public class Claim {

	protected String claimName;
	protected String claimDescription;
	
	protected String startDate;
	protected String endDate;
	
	protected String currency;
	protected double totalAmount;
	
	protected String claimStatus;
	
	/**
	 * This is a the constructor for a claim. Every claim needs the following parameters.
	 * We also init the claim amount to 0.
	 * @param name = Claim Name
	 * @param description = claim description
	 * @param start = Start Date
	 * @param end = End Date
	 * @param currencyType = Currency Type for Claim
	 */
	public Claim(String name, String description, String start, String end, String currencyType) {
		this.claimName = name;
		this.claimDescription = description;
		this.startDate = start;
		this.endDate = end;
		this.currency = currencyType;
		this.totalAmount = 0;
		this.claimStatus = "Unsubmitted";
	}
	
	
	/**
	 * This method updates the Claim based on the user input
	 * @param name = Claim Name
	 * @param description = claim description
	 * @param start = Start Date
	 * @param end = End Date
	 * @param currencyType = Currency Type for Claim
	 */
	public void editClaim(String name, String description, String start, String end, String currencyType){
		this.claimName = name;
		this.claimDescription = description;
		this.startDate = start;
		this.endDate = end;
		this.currency = currencyType;
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


	/**
	 * This method returns a formatted string of a claim. It is in the form required by the ViewTestList
	 */
	public String toString(){
		
		return this.claimName + "\n" + this.claimDescription + "\n" + this.startDate + " to " + this.endDate + "\n" + "Total:" + this.currency + ":" +  this.totalAmount  ; 
	}


}
