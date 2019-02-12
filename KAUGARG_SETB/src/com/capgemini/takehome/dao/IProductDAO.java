package com.capgemini.takehome.dao;

import com.capgemini.takehome.bean.Product;
import com.capgemini.teakehome.exception.InvalidProductCodeException;

public interface IProductDAO {
	Product getProductDetails(int productCode) throws InvalidProductCodeException;
}
