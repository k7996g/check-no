package com.capgemini.salesmanagement.exceptions;

public class InvalidProductCategoryException extends Exception
{
	public InvalidProductCategoryException() {
		super("Enter valid product category");
	}
}
