package com.capgemini.salesmanagement.service;

import java.util.HashMap;

import com.capgemini.salesmanagement.bean.Sale;
import com.capgemini.salesmanagement.dao.ISaleDao;
import com.capgemini.salesmanagement.dao.SaleDao;
import com.capgemini.salesmanagement.exceptions.InvalidProductCategoryException;
import com.capgemini.salesmanagement.exceptions.InvalidProductCodeException;
import com.capgemini.salesmanagement.exceptions.InvalidProductNameException;
import com.capgemini.salesmanagement.exceptions.InvalidProductPriceException;
import com.capgemini.salesmanagement.exceptions.InvalidQuantityException;

public class SaleService implements ISaleService 
{
	ISaleDao iSaleDao = new SaleDao();
	@Override
	public Sale insertSalesDetails(Sale sale) {
		
		return iSaleDao.insertSaleDetails(sale);
	}

	@Override
	public void validateProductCode(int productId) throws InvalidProductCodeException
	{
		if(!(productId==1001 || productId==1002 || productId==1003 || productId==1004))
		{
			throw new InvalidProductCodeException();
		}
	}

	@Override
	public void validateQuantity(int quantity) throws InvalidQuantityException
	{
		if(!(quantity>0 && quantity<5))
		{
			throw new InvalidQuantityException();
		}
	}

	@Override
	public void validateProductCat(String prodCat) throws InvalidProductCategoryException 
	{
		if(!(prodCat.equals("Electronics") || prodCat.equals("Toys")))
		{
			throw new InvalidProductCategoryException();
		}
	}

	@Override
	public void validateProductName(String prodCat,String prodName) throws InvalidProductNameException 
	{
		if(prodCat.equals("Electronics"))
		{
			if(!(prodName.equals("TV") || prodName.equals("Smart Phone") || prodName.equals("Video Game")))
			{
				throw new InvalidProductNameException();
			}
		}
		if(prodCat.equals("Toys"))
		{
			if(!(prodName.equals("Soft Toy") || prodName.equals("Telescope") || prodName.equals("Barbee Doll")))
			{
				throw new InvalidProductNameException();
			}
		}
	}

	@Override
	public void validateProductPrice(float price) throws InvalidProductPriceException 
	{
		if(!(price>200))
		{
			throw new InvalidProductPriceException();
		}
	}
	//This method updates the Collection
	@Override
	public Sale displaySales(int prodCode, int quantity, String category, String prodDescription, float prodPrice)
	{
		//call methods from dao
		float lineTotal = iSaleDao.calculateLineTotal(prodPrice, quantity);
		return iSaleDao.displaySales(prodCode, quantity, category, prodDescription, lineTotal);
	}
	
}

