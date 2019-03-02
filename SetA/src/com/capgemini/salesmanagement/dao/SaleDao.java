package com.capgemini.salesmanagement.dao;

import java.time.LocalDate;
import java.util.HashMap;

import com.capgemini.salesmanagement.bean.Sale;
import com.capgemini.salesmanagement.util.CollectionUtil;

public class SaleDao implements	ISaleDao
{
	Sale sale = null;
	@Override
	public Sale insertSaleDetails(Sale sale) 
	{
		CollectionUtil.getCollection().put(sale.getSaleId(), sale);
		return CollectionUtil.getCollection().get(sale.getSaleId());
	}
	
	public  int generateSaleId()
	{
		return (int)(Math.random()*1000);
	}
	
	public float calculateLineTotal(float prodPrice,int quantity)
	{
		float lineTotal = prodPrice*quantity;
		return lineTotal;
	}
	
	public Sale displaySales(int prodCode, int quantity, String category, String prodDescription, float lineTotal)
	{
		sale = new Sale();
		sale.setSaleId(generateSaleId());
		sale.setProdCode(prodCode);
		sale.setQuantity(quantity);
		sale.setCategory(category);
		sale.setProductName(prodDescription);
		sale.setLineTotal(lineTotal);
		sale.setSaleDate(LocalDate.now());
		return insertSaleDetails(sale);
	}
}
