package com.example.PROTOTYPEeorodrigtravellogger;

import java.util.ArrayList;
import java.util.Collection;

public class ClaimViewList {

	protected ArrayList<Claim> claimList;
	
	public ClaimViewList(){
		claimList = new ArrayList<Claim>();
	}
	
	
	public Collection<Claim> getClaims(){
		return claimList;
	}
	
	public void addClaim(Claim newClaim){
		claimList.add(newClaim);
	}
	
	public void removeClaim(Claim claim){
		claimList.remove(claim);
	}
	
	/*edit claim
	public void editClaim(){
		
		claimList.
	}
	*/
}
