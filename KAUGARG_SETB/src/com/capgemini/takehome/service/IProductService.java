package com.capgemini.takehome.service;

import com.capgemini.takehome.bean.Product;
import com.capgemini.teakehome.exception.InvalidProductCodeException;
import com.capgemini.teakehome.exception.ProductCodeIsNotValidException;

public interface IProductService {
Product getProductDetails(int productCode) throws ProductCodeIsNotValidException, InvalidProductCodeException;
}
