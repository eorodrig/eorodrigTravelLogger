package com.example.travellogger;

import java.util.ArrayList;
import java.util.Collection;

public class ClaimViewList {

	protected ArrayList<Claim> claimList;
	
	public ClaimViewList(){
		claimList = new ArrayList<Claim>();
	}
	
	
	public ArrayList<Claim> getClaims(){
		return claimList;
	}
	
	public void addClaim(Claim newClaim){
		claimList.add(newClaim);
	}
	
	public void removeClaim(Claim claim){
		claimList.remove(claim);
	}
	
	
}