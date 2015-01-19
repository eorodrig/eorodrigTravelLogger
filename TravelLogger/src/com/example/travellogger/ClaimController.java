package com.example.travellogger;

public class ClaimController {

	private static ClaimList claimList = null;
	private static int claimListNumber = 0;
	
	static public ClaimList getClaimList(){
		
		if (claimList == null){
			claimList = new ClaimList();
		}
		
		
		return claimList;
		
	}
	
	public void setIndexOfCurrentClaim(int index){
		claimListNumber = index;
	}
	
	public int getIndexOfCurrentClaim(){
		return claimListNumber;
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
	
	
	
	public Claim getClaimAtIndex(int index){
		return claimList.getClaims().get(index);
	}
	
	public void saveClaim(Claim newClaim){
		
		claimList.updateClaim(claimListNumber, newClaim);
	}
	
	
}
