package com.example.travellogger;

import java.util.ArrayList;


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
	


	
	public Claim getClaim(int index){
		return claimList.get(index);
	
	}
	
	public void updateClaim(int index, Claim newClaim){
		claimList.remove(index);
		claimList.add(index, newClaim);
		notifyListeners();
	}
	
	public int size(){
		return this.getClaims().size();
	}
	
	public void addListener(Listener listener){
		listeners.add(listener);
	}
	
	private void notifyListeners(){
		for (Listener listener: listeners){
			listener.update();
		}
		
	}
	
	private void removeListener(Listener listener){
		listeners.remove(listener);
	}
	
	public void removeAllListeners(){
		listeners.clear();
	}
	
	
	
}