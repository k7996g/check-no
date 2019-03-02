package com.capgemini.salesmanagement.dao;

import java.util.HashMap;

import com.capgemini.salesmanagement.bean.Sale;

public interface ISaleDao
{
	public Sale insertSaleDetails(Sale sale);
	public float calculateLineTotal(float prodPrice,int quantity);
	public Sale displaySales(int prodCode, int quantity, String category, String prodDescription, float lineTotal);
}
