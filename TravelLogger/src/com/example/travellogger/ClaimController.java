package com.example.travellogger;


public class ClaimController {

	private static ClaimList claimList = null;
	private static int claimListNumber = 0;
	private static Claim claimToEdit = null;
	private static boolean editStatus = false;
	
	static public ClaimList getClaimList(){
		
		if (claimList == null){
			claimList = new ClaimList();
		}
		
		
		return claimList;
		
	}
	
	public void setEditStatus(boolean status){
		this.editStatus = status;
	}
	
	public boolean getEditStatus(){
		return this.editStatus;
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
	
	public void updateClaims(Claim newClaim){
		
		claimList.updateClaim(claimListNumber, newClaim);
	}

	public void setClaimToEdit(int index) {
		claimToEdit = getClaimAtIndex(index); 
		
	}

	public void resetClaimToEdit(){
		claimToEdit = null;
	}
	
	public Claim getClaimToEdit() {
		return claimToEdit;
		
	}

	public void editClaim(Claim newClaim) {
		
		claimList.updateClaim(claimListNumber, newClaim);
		
	}
	
	
}
