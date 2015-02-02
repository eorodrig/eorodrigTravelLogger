/*
 *     <one line to give the program's name and a brief idea of what it does.>
    Copyright (C) <2015>  <Edwin Rodriguez eorodrig@ualberta.ca>

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.eorodrig.TravelLogger;

import java.util.ArrayList;
import java.util.Collections;

public class ClaimList {

	//this is a list of claims
	protected ArrayList<Claim> claimList;
	
	//this is a list of listeners
	protected ArrayList<Listener> listeners;
	
	
	/**
	 * Constructor will init the lists
	 */
	public ClaimList(){
		claimList = new ArrayList<Claim>();
		listeners = new ArrayList<Listener>();
	}
	
	
	////////////////////////////////
	/*
	 * These are the arrayList calls
	 */
	/////////////////////////
	
	/**
	 * This will return the list of claims
	 * @return
	 */
	public ArrayList<Claim> getClaims(){
		return claimList;
	}
	
	/**
	 * This will add a claim and notify the listeners
	 * @param newClaim
	 */
	public void addClaim(Claim newClaim){
		claimList.add(newClaim);
		notifyListeners();
		
	}
	
	/**
	 * this will add a list of claims to the claim list
	 * @param list
	 */
	public void addAll(ArrayList<Claim> list) {
		this.claimList.clear();
		this.claimList.addAll(list);
	}
	
	/**
	 * this will remove the specified claim from the list
	 * @param claim
	 */
	public void removeClaim(Claim claim){
		claimList.remove(claim);
		notifyListeners();
	}
	
	/**
	 * this will update the specified claim
	 * @param index
	 * @param newClaim
	 */
	public void updateClaim(int index, Claim newClaim ){
		claimList.remove(index);
		claimList.add(index, newClaim);
		notifyListeners();
	}
	
	/**
	 * This will get a claim at a specified index of the claim list
	 *
	 * @param index
	 * @return
	 * @throws EmptyClaimException - this will throw this exception if the list is empty
	 */
	public Claim getClaim(int index) throws EmptyClaimException{
		if (claimList.size() > 0)
		return claimList.get(index);
		else
			throw new EmptyClaimException("Out of bounds");
	}
	

	/**
	 * This will get the size of the claim list
	 * @return
	 */
	public int size(){
		return this.getClaims().size();
	}
	

	///////////////////////////////////////
	/*
	 * These are the listener callers
	 */
	//////////////////////////////////////
	
	/**
	 * This will add a new listener to the list
	 * @param listener
	 */
	public void addListener(Listener listener){
		listeners.add(listener);
	}
	
	/**
	 * This will notify all listeners to update
	 */
	public void notifyListeners()
	{
		//try and catch for debugging
		//try{
			// if there are listeners... Sort claim list, then update listeners
			if (listeners.size() >  0)
				{
					Collections.sort(claimList);
				
					for (Listener listener: listeners)
						{
							listener.update();	
						}
				}
			//}
	//	catch (Exception e){
			
		//}

	}
	
	
	/**
	 * This will remove all the listeners from the listeners list
	 *	Useful for loading from GSON
	 */
	public void removeAllListeners(){
		listeners.clear();
	}



	//////////////////////////////
	/*
	 * This is the add expenses method
	 */
	////////////////////////

	/**
	 * This will add all the expenses in each claim
	 */
	public void addExpenses() {
		for (Claim claim: claimList){
			claim.sumExpenses();
		}
	}

}