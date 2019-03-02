package com.capgemini.salesmanagement.test;

import org.junit.Test;

import com.capgemini.salesmanagement.exceptions.InvalidProductCategoryException;
import com.capgemini.salesmanagement.exceptions.InvalidProductCodeException;
import com.capgemini.salesmanagement.exceptions.InvalidProductNameException;
import com.capgemini.salesmanagement.exceptions.InvalidProductPriceException;
import com.capgemini.salesmanagement.exceptions.InvalidQuantityException;
import com.capgemini.salesmanagement.service.ISaleService;
import com.capgemini.salesmanagement.service.SaleService;

public class TestBillingApplication 
{
	ISaleService iSaleTest = new SaleService();
	
	@Test(expected = InvalidProductCodeException.class)
	public void whenProductCodeIsNotValid() throws InvalidProductCodeException 
	{
		iSaleTest.validateProductCode(1005);
	}
	
	@Test(expected = InvalidQuantityException.class)
	public void whenQauntityIsNotValid() throws InvalidQuantityException 
	{
		iSaleTest.validateQuantity(5);
	}
	
	@Test(expected = InvalidProductCategoryException.class)
	public void whenProdutCategoryIsNotValid() throws InvalidProductCategoryException 
	{
		iSaleTest.validateProductCat("Abc");
	}
	
	@Test(expected = InvalidProductNameException.class)
	public void whenProductDescriptionIsNotValid() throws InvalidProductNameException
	{
		iSaleTest.validateProductName("Electronics", "abc");
	}
	
	@Test(expected = InvalidProductPriceException.class)
	public void whenProductPriceIsNotValid() throws InvalidProductPriceException
	{
		iSaleTest.validateProductPrice(21);
	}
}	
