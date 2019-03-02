package com.capgemini.salesmanagement.service;

import java.util.HashMap;

import com.capgemini.salesmanagement.bean.Sale;
import com.capgemini.salesmanagement.exceptions.InvalidProductCategoryException;
import com.capgemini.salesmanagement.exceptions.InvalidProductCodeException;
import com.capgemini.salesmanagement.exceptions.InvalidProductNameException;
import com.capgemini.salesmanagement.exceptions.InvalidProductPriceException;
import com.capgemini.salesmanagement.exceptions.InvalidQuantityException;

public interface ISaleService 
{
	public Sale insertSalesDetails(Sale sale);
	public void validateProductCode(int productId)throws InvalidProductCodeException;
	void validateQuantity(int quantity)throws InvalidQuantityException;
	public void validateProductCat(String prodCat) throws InvalidProductCategoryException;
	public void validateProductPrice(float price)throws InvalidProductPriceException;
	void validateProductName(String prodCat, String prodName) throws InvalidProductNameException;
	public Sale displaySales(int prodCode,int quantity,String category,String prodDescription,float prodPrice);
}
