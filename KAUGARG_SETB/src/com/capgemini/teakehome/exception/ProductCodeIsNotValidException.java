package com.capgemini.teakehome.exception;
//Exception class if product code is not in proper format
public class ProductCodeIsNotValidException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductCodeIsNotValidException(String s) {
		super(s);

	}
}
