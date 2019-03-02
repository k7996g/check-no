package com.capgemini.salesmanagement.exceptions;

public class InvalidProductPriceException extends Exception
{
	public InvalidProductPriceException() 
	{
		super("Enter valid Product Price");
	}
}
