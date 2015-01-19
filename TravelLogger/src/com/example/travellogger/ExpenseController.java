package com.example.travellogger;

public class ExpenseController {

	private static ExpenseList expenseList = null;
	private Claim currentClaim;
	
	static public ExpenseList getExpenseList(){
		
		if (expenseList == null){
			expenseList = new ExpenseList();
		}
		
		
		return expenseList;
		
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



	public void saveExpense() {
		ClaimController claimController = new ClaimController();
		claimController.saveClaim(currentClaim);

		
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
