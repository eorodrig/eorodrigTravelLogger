package com.example.travellogger;


//http://stackoverflow.com/questions/8423700/how-to-create-a-custom-exception-type-in-java
// Jan 18 340pm
public class EmptyClaimExeption extends Exception {

	public EmptyClaimExeption(){
		
	}
	
	public EmptyClaimExeption(String message)
	{
		super(message);
	}
}
