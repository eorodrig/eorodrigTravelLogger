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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.content.Context;



public class ClaimController {

	//these are the attributes for the claim controller
	//these are all static as they need to remain in memory
	
	//claim list to hold claims
	private static ClaimList claimList = null;
	
	//the index of the current claim
	private static int claimListNumber = 0;
	
	//a temporary claim which is editable
	private static Claim claimToEdit = null;
	
	//the boolean status of the editability of the claim
	private static boolean editStatus = false;
	
	//this is the filename we save/load to/from
	private final static String FILENAME  = "TravelLoggerDate.sav";
	

	////////////////////////
	/*
	 * CLaim List operators
	 */
	///////////////////////////
	
	/**
	 * return claim list, if null return new list
	 * @return
	 */
	static public ClaimList getClaimList(){
		
		if (claimList == null){
			claimList = new ClaimList();
		}	
		return claimList;
	}
	
	/**
	 * add a claim, if claimList is empty, make a new one
	 * @param newClaim
	 */
	public void addClaim(Claim newClaim){
		if (claimList == null){
			claimList = new ClaimList();
		}
		claimList.addClaim(newClaim);
	}
	
	/**
	 * remove a claim
	 * @param newClaim
	 */
	public void removeClaim(Claim newClaim){
		claimList.removeClaim(newClaim);
		
	}
	
	/**
	 * return a claim at a selected index of the list
	 * @param index
	 * @return
	 */
	public Claim getClaimAtIndex(int index){
		return claimList.getClaims().get(index);
	}
	
	/**
	 * this will update take in the new claim and overide its previous instance in the list
	 * @param newClaim
	 */
	public void updateClaims(Claim newClaim){
		
		claimList.updateClaim(claimListNumber, newClaim);
	}

	
	/**
	 * This will call the edit claim calls and edit the current current claim
	 * @param claim
	 * @param claimDescription
	 * @param start
	 * @param end
	 */
	public void editClaim(String claim, String claimDescription, Date start,Date end) {
		
		//This will edit the claim
		this.claimList.getClaims().get(claimListNumber).editClaim(claim, claimDescription, start, end);
	
		//this will notify the listener
		this.claimList.notifyListeners();
		
	}
	
	//////////////////////////
	/*
	 * Controller operators	
	 */
	/////////////////////////////////
	
	//getters/setters for editStatus
	public void setEditStatus(boolean status){
		this.editStatus = status;
	}
	public boolean getEditStatus(){
		return this.editStatus;
	}
	
	

	//Get/Set the current Claim index (List index)
	public void setIndexOfCurrentClaim(int index){
		claimListNumber = index;
	}
	public int getIndexOfCurrentClaim(){
		return claimListNumber;
	}
	
	
	// Get/Set/Reset the editable claim
	public void setClaimToEdit(int index) {
		claimToEdit = getClaimAtIndex(index); 
	}
	public void resetClaimToEdit(){
		claimToEdit = null;
	}
	public Claim getClaimToEdit() {
		return claimToEdit;
		
	}

	
	/////////////////
	/*
	 * These are the GSON Save/Load methods
	 */
	//////////////////////////
	
	/**
	 * This will save the current claimList
	 * @param context
	 */
	public void save(Context context){
		Gson gson = new Gson();
		
		//try to save
		try {
			
			//this will create the new file and use GSON to save the claimlist to it
			FileOutputStream fos = context.openFileOutput(FILENAME, 0);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			gson.toJson(claimList, osw);
			
			//this will force it to write
			osw.flush();
			//this will close the streams
			osw.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

	

	
	/**
	 * This will load the saved file from GSON
	 * @param context
	 */
	public void load(Context context){
		
		Gson gson = new Gson();
		
		try {
			
			//This will open the Save file
			FileInputStream fis = context.openFileInput(FILENAME);
			InputStreamReader isr = new InputStreamReader(fis);
			
			//this will get the type of the claimList
			Type claimListType = new TypeToken<ClaimList>() {}.getType();
			
			//this will load the file
			claimList = gson.fromJson(isr, claimListType);

			//this will close the streams
			isr.close();
			fis.close();
						
	
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	//////////////////////////////////////
	/*
	 *These are the submit/approve/return calls for the project 
	 *they will change the status of the claim, and notify the listeners
	 */
	////////////////////////////////////
	
	public void submitClaim(int index){
		claimList.getClaims().get(index).submit();
		claimList.notifyListeners();
	}
	
	public void approveClaim(int index){
		claimList.getClaims().get(index).approve();
		claimList.notifyListeners();
	}
	
	public void returnClaim(int index){
		claimList.getClaims().get(index).returned();
		claimList.notifyListeners();
	}
}

