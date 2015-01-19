package com.example.travellogger;

public class ExpenseController {

	private static ExpenseList expenseList = null;
	private Claim currentClaim;
	private static int expenseListNumber = 0;
	private static Expense expenseToEdit = null;
	private static boolean editStatus = false;
	
	
	
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
		currentClaim = ClaimController.getClaimList().getClaim(currentClaimIndex);

		expenseList = currentClaim.getExpenses();
		

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



	public void setClaimToEdit(int finalClaimPosition) {
		// TODO Auto-generated method stub
		
	}

	public void editExpense(Expense newExpense) {
		expenseList.updateClaim(expenseListNumber, newExpense);
		
	}
	
	
	/*
	public Claim getClaimAtIndex(int index){
		return claimList.getClaims().get(index);
	}
	
		/*
	public void setIndexOfCurrentClaim(int index){
		claimListNumber = index;
	}
	
	public int getIndexOfCurrentClaim(){
		return claimListNumber;
	}
	
*/

	
}
