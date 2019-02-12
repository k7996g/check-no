package com.capgemini.teakehome.exception;
// Exception class for quantity less than zero
public class QuantityLessThanZeroException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	QuantityLessThanZeroException(String s) {
		super(s);

	}
}
