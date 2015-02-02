package com.eorodrig.TravelLogger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.content.Context;



public class ClaimController {

	private static ClaimList claimList = null;
	private static int claimListNumber = 0;
	private static Claim claimToEdit = null;
	private static boolean editStatus = false;
	

///////////////////CLaim List operators
	
	
	//return claim list, if null return new list
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
	
	
	public Claim getClaimAtIndex(int index){
		return claimList.getClaims().get(index);
	}
	
	public void updateClaims(Claim newClaim){
		
		claimList.updateClaim(claimListNumber, newClaim);
	}

	
	
/////////////Controller operators	
	
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
	
	
	
	public void setClaimToEdit(int index) {
		claimToEdit = getClaimAtIndex(index); 
	}

	public void resetClaimToEdit(){
		claimToEdit = null;
	}
	
	
	
	public Claim getClaimToEdit() {
		return claimToEdit;
		
	}



	public void save(Context context){
		String fileName = "TravelLoggerDate.sav";
		Gson gson = new Gson();

		try {

			FileOutputStream fos = context.openFileOutput(fileName, 0);
					
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			
			//gson.toJson(claimList, osw);
			gson.toJson(claimList.getClaims(), osw);
			osw.flush();
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

	

	
	
	public void load(Context context){
		String fileName = "TravelLoggerDate.sav";
		Gson gson = new Gson();
		
		try {
			FileInputStream fis = context.openFileInput(fileName);
			InputStreamReader isr = new InputStreamReader(fis);

			Type ArrayListclaimListType = new TypeToken<ArrayList<Claim>>() {}.getType();
			
			
			ArrayList<Claim>list = new ArrayList<Claim>();
			list = gson.fromJson(isr, ArrayListclaimListType );
			claimList.addAll(list);
			
			//new TypeToken<ArrayList<String>>() {}.getType();
			isr.close();
			fis.close();
						
	
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			

	
	}

	
	public void editClaim(Claim newClaim, ExpenseList expenseList) {
		claimList.updateClaim(claimListNumber, newClaim);
		
	}
	public void editClaim(String claim, String claimDescription, Date start,
			Date end) {
		
		this.claimList.getClaims().get(claimListNumber).editClaim(claim, claimDescription, start, end);
		this.claimList.notifyListeners();
		
	}
	
	
	public void submitClaim(int index){
		claimList.getClaims().get(index).submit();
		claimList.notifyListeners();
	}
}

