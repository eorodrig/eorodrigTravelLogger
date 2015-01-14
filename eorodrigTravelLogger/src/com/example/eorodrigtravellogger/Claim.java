package com.example.eorodrigtravellogger;

public class Claim {

	protected String claimName;
	
	protected String startDate;
	protected String endDate;
	
	protected String currency;
	protected double totalAmount;
	
	public Claim(String claimName) {
		this.claimName = claimName;
	}
	
	public String toString(){
		return claimName;
	}

}
