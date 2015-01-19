package com.example.travellogger;

public class ClaimController {

	private static ClaimList claimList = null;
	
	static public ClaimList getClaimList(){
		
		if (claimList == null){
			claimList = new ClaimList();
		}
		
		
		return claimList;
		
	}
	
	public void addClaim(Claim newClaim){
		if (claimList == null){
			claimList = new ClaimList();
		}
		claimList.addClaim(newClaim);
	}
	
	public void removeClaim(Claim newClaim){
		claimList.removeClaim(newClaim);
	}
	
	
}
