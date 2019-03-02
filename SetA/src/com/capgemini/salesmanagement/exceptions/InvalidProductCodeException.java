package com.capgemini.salesmanagement.exceptions;

public class InvalidProductCodeException extends Exception
{
	public InvalidProductCodeException() 
	{
		super("Enter Valid Product Code");
	}
}
