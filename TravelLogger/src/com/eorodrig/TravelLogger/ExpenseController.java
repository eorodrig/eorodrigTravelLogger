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

public class ExpenseController {

	//these are the attributes for the expense controller
	//these are all static as they need to remain in memory

	//will hold 1 claim's expense list
	private static ExpenseList expenseList = null;
	
	//will hold the current claim
	private Claim currentClaim;
	
	//will hold the list index of the current expense
	private static int expenseListNumber = 0;
	
	//these will hold the expense we wish to edit
	private static Expense expenseToEdit = null;
	//this will hold the editability of the current status
	private static boolean editStatus = false;
	
	
	
	/////////////////////////////////
	/*
	 * Expense list calls
	 */
	///////////////////////////////////////
	
	/**
	 * this return a list of expenses, if empty, it will create a new list
	 * @return
	 */
	static public ExpenseList getExpenseList(){
		
		if (expenseList == null){
			expenseList = new ExpenseList();
		}
		return expenseList;
	}
	
	/**
	 * This will get an expense at a selected index
	 * @param index
	 * @return
	 */
	public Expense getExpense(int index){
		return expenseList.getExpense(index);
	
	}
	
	/**
	 * This will add an expense to the expense list,
	 * if list is empty it will make a new list
	 * @param newExpense
	 */
	public void addExpense(Expense newExpense){
		if (expenseList == null){
			expenseList = new ExpenseList();
		}
	
		 expenseList.addExpense(newExpense);
	}
	
	
	/**
	 * this will remove the specified expense from the expense list
	 * @param expense
	 */
	public void removeExpense(Expense expense){
		expenseList.removeExpense(expense);
		
	}
	
	
	
	
	
	
	//////////////////////////////
	/*
	 * Controller calls
	 */
	////////////////////////////////
	/**
	 * This will set the current Claim using the stored index of the current claim
	 */
	public void setCurrentClaim(){
		//this will extract the current claim index
		ClaimController claimController = new ClaimController();
		int currentClaimIndex = claimController.getIndexOfCurrentClaim();
		
		//try to extract the current claim and extract that claims expense list
		try{
			currentClaim = ClaimController.getClaimList().getClaim(currentClaimIndex);
			expenseList = currentClaim.getExpenses();
		}
		catch(EmptyClaimException e)
		{
			
		}
	}
	
	
	//this will set/get/reset the expense edit
	public void setExpenseToEdit() {
		expenseToEdit = getExpense(expenseListNumber);
		
	}
	public void resetExpenseToEdit(){
		this.expenseToEdit = null;
	}
	
	public Expense getExpenseToEdit(){
		return expenseToEdit;
	}
	
	
	
	//getter/setter values for edit flag
	public void setEditStatus(boolean status){
		this.editStatus = status;
	}
	public boolean getEditStatus(){
		return this.editStatus;
	}
	
	
	/**
	 * This will update the expenses to the claimList
	 */
	public void updateExpenses() {
		ClaimController claimController = new ClaimController();
		claimController.updateClaims(currentClaim);
	}


	//this will set/get the index of the current expense
	public void setIndexOfCurrentExpense(int position) {
		expenseListNumber = position;
	}
	
	public int getIndexOfCurrentExpense() {
		return expenseListNumber;
	}


	/**
	 * This will update the current expense with the editted values
	 * @param newExpense
	 */
	public void editExpense(Expense newExpense) {
		expenseList.updateClaim(expenseListNumber, newExpense);
		
	}
	
	
	/**This will check to see if the current claim is editable*/
	public boolean isEditable(){
		if (currentClaim.isEditable())
		{
			return true;
		}
		return false;
	}
	

	
}
