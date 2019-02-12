package com.capgemini.takehome.dao;

import java.util.HashMap;
import java.util.Map;

import com.capgemini.takehome.bean.Product;
import com.capgemini.takehome.util.CollectionUtil;
import com.capgemini.teakehome.exception.InvalidProductCodeException;

public class ProductDAO implements IProductDAO {
	
	Map<Integer, Product> products = new HashMap<Integer, Product>();
	//Create object of type CollectionUtil
	CollectionUtil collection = new CollectionUtil();

	@Override
	public Product getProductDetails(int productCode) throws InvalidProductCodeException {
		// TODO Auto-generated method stub
           //Getting the Map from the util package to dao package
		products = collection.getList();
		for (Map.Entry<Integer, Product> product : products.entrySet()) {
			if (product.getKey() == productCode) {

				return products.get(product.getKey());

			}
		}

		throw new InvalidProductCodeException("Product code is not exist in the hashmap");

	}

}
