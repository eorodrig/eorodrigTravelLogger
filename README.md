# eorodrigTravelLogger
This is an expense claim application for cmput 301.


This is my submission for Assignment1
Walkthrough: https://www.youtube.com/watch?v=_0mKJ3j5_ck

Part A: Directory description
Part B: References
Part C: app info
Part D: known issues and failed requirements
Part E: Future implementations (if required)

Part A: Directory description

Directory:
	PROTOTYPE-eorodrigTravelLogger
		This holds the initial prototype of the app
	TravelLogger
		This holds the project for the assignment
	Docs
		This holds the UML files (Visio and pdf)
	AdditonalResources
		This holds all potential and used images
		ReferenceGuide contains all the sources (URL, date accessed)


Part B: References

These are the references which were used:
	how to add background
		www.compiletimeerror.com/2013/01/how-to-set-background-image-in-android.html#.VLXY43snfbM
		Accessed 2015 Jan 13 @ 7:48pm   

	date formatting
		http://stackoverflow.com/questions/5799140/java-get-month-string-from-integer
		Accessed 2015 jan 14 @10:55
 	
	date formatting
		http://stackoverflow.com/questions/17674308/date-from-edittext
		Accessed 2015 jan 14 @11:45 	

	GSON references
		http://stackoverflow.com/questions/5813434/trouble-with-gson-serializing-an-arraylist-of-pojos  
		Accesed jan 31/2015 @ 1050pm
		http://stackoverflow.com/questions/6173400/how-to-programmatically-hide-a-button-in-android-sdk
		Accessed feb 2 @12:52 am

	UIDialog Reference
		http://developer.android.com/guide/topics/ui/dialogs.html
		Accesed Jan  18 710pm



Part C: app info

This app is a expense logging application for android 4.2 (API 17)

It allows a user to make a claim, edit a claim and delete a claim.
Each claim has the ability to contain expenses which the user has the option to: Add new expenses, delete expenses or edit expenses.
The user has the ability to "Submit" a claim which will lock the claim in view only mode.
The user can also has administrator privileges so they can approve/return submitted claims.
	Approved claims remain locked in view only mode.
	Return claims are re-opened to edits.
All claims and claim information is persistant.
	Saves to "TravelLoggerData.sav" file on the device.
	Will create the file if its not existant.
All claims and expenses are also sorted and displayed by start date, then end date (if applicable)
Basic I/O for the program has been tested an accounted for:
	No empty fields allowed when creating/editing claims/expenses.
	



Part D: known issues and failed requirements

Due to time limitations, Emails were not implemented.
I/O not implemented:
	Date restrictions on expenses.
		IE. an expense has the current ability to be outside the claim's date range.
	Date Boundaries on claims.
		IE. A start date which is after the end date is acceptable.
Memory Limitations of the program not calculated
On a physical device, the input fields do not close the virtual keboard.


Part E: Future implementations (if required)

The main activity will be implemented (Splash menu)  --Functional but removed
	This will allow a distinct seperation of roles between users and administrators.
	The implementation of the admin Activity.
Email support

