package com.capgemini.salesmanagement.exceptions;

public class InvalidQuantityException extends Exception
{
	public InvalidQuantityException() 
	{
		super("Enter valid quanity");
	}
}
