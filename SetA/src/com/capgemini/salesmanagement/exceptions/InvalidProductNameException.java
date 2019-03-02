package com.capgemini.salesmanagement.exceptions;

public class InvalidProductNameException extends Exception	
{
	public InvalidProductNameException() {
		super("Enter valid product Description");
	}
	
}
