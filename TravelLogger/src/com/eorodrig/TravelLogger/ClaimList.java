package com.eorodrig.TravelLogger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;


public class ClaimList {

	protected ArrayList<Claim> claimList;
	protected ArrayList<Listener> listeners;
	
	
	
	public ClaimList(){
		claimList = new ArrayList<Claim>();
		listeners = new ArrayList<Listener>();
	}
	
	
	
	public ArrayList<Claim> getClaims(){
		return claimList;
	}
	
	
	public void addClaim(Claim newClaim){
		claimList.add(newClaim);
		notifyListeners();
		
	}
	
	public void removeClaim(Claim claim){
		claimList.remove(claim);
		notifyListeners();
	}
	
	public void updateClaim(int index, Claim newClaim ){
		claimList.remove(index);
		claimList.add(index, newClaim);
		notifyListeners();
	}


	
	
	public Claim getClaim(int index) throws EmptyClaimException{
		if (claimList.size() > 0)
		return claimList.get(index);
		else
			throw new EmptyClaimException("Out of bounds");
	}
	

	
	public int size(){
		return this.getClaims().size();
	}
	

	
	public void addListener(Listener listener){
		listeners.add(listener);
	}
	
	public void notifyListeners(){
		if (listeners.size() >0)
			{
				Collections.sort(claimList);
			
				for (Listener listener: listeners){
		
				listener.update();
			
			
				}
		
			}
		
		
		
	}
	
	private void removeListener(Listener listener){
		listeners.remove(listener);
	}
	
	public void removeAllListeners(){
		listeners.clear();
	}



	public void addAll(ArrayList<Claim> list) {
		this.claimList.addAll(list);
	
		
	}



	public void addExpenses() {
		for (Claim claim: claimList){
	
			claim.sumExpenses();
			
			
		}
		
	}

	

	/*
	

		

*/


}