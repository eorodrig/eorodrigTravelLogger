package com.eorodrig.TravelLogger;

public class ExpenseController {

	private static ExpenseList expenseList = null;
	private Claim currentClaim;
	private static int expenseListNumber = 0;
	private static Expense expenseToEdit = null;
	private static boolean editStatus = false;
	
	
	//get the list of expenses for a claim
	static public ExpenseList getExpenseList(){
		
		if (expenseList == null){
			expenseList = new ExpenseList();
		}
		
		
		return expenseList;
		
	}
	
	

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
	
	
	public Expense getExpense(int index){
		return expenseList.getExpense(index);
	
	}
	
	public void addExpense(Expense newExpense){
		if (expenseList == null){
			expenseList = new ExpenseList();
		}
	
		 expenseList.addExpense(newExpense);
	}
	
	public void removeExpense(Expense expense){
		expenseList.removeExpense(expense);
		
	}
	
	public void setCurrentClaim(){
		ClaimController claimController = new ClaimController();
		int currentClaimIndex = claimController.getIndexOfCurrentClaim();
		try{
			currentClaim = ClaimController.getClaimList().getClaim(currentClaimIndex);
			expenseList = currentClaim.getExpenses();
		}
		catch(EmptyClaimException e)
		{
			
		}
		

		
		

	}



	public void updateExpenses() {
		ClaimController claimController = new ClaimController();
		claimController.updateClaims(currentClaim);

		
	}



	public void setIndexOfCurrentExpense(int position) {
		this.expenseListNumber = position;
		
	}
	
	public int getIndexOfCurrentExpense() {
		return this.expenseListNumber;
		
	}



	public void editExpense(Expense newExpense) {
		expenseList.updateClaim(expenseListNumber, newExpense);
		
	}
	
	
	public boolean isEditable(){
		if (currentClaim.isEditable())
		{
			return true;
		}
		return false;
	}
	

	
}
