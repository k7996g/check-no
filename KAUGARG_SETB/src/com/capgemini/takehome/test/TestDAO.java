package com.capgemini.takehome.test;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.takehome.bean.Product;
import com.capgemini.takehome.dao.IProductDAO;
import com.capgemini.takehome.dao.ProductDAO;
import com.capgemini.teakehome.exception.InvalidProductCodeException;

public class TestDAO {
	@Before
	public void runEachTimeBeforeTestCase() {
		System.out.println("Run each time");
	}

	@Test
	public void test1DAO() throws InvalidProductCodeException {
		IProductDAO dao = new ProductDAO();

		Product product = dao.getProductDetails(1001);
		System.out.println(product);
	}

	@Test
	public void test2DAO() throws InvalidProductCodeException {
		IProductDAO dao = new ProductDAO();

		Product product = dao.getProductDetails(1002);
		System.out.println(product);
	}

	@Test
	public void test3DAO() throws InvalidProductCodeException {
		IProductDAO dao = new ProductDAO();

		Product product = dao.getProductDetails(1003);
		System.out.println(product);
	}

	@Test
	public void test4DAO() throws InvalidProductCodeException {
		IProductDAO dao = new ProductDAO();

		Product product = dao.getProductDetails(1004);
		System.out.println(product);
	}

	@Test
	public void test5DAO() {
		IProductDAO dao = new ProductDAO();

		try {
			dao.getProductDetails(1005);
		} catch (InvalidProductCodeException e) {
			// TODO Auto-generated catch block
			System.out.println("Product code is not exist in the hashmap");
		}
	}

	@Test
	public void test6DAO() {
		IProductDAO dao = new ProductDAO();

		try {
			dao.getProductDetails(1006);
		} catch (InvalidProductCodeException e) {
			// TODO Auto-generated catch block
			System.out.println("Product code is not exist in the hashmap");
		}
	}

	@Test
	public void test7DAO() {
		IProductDAO dao = new ProductDAO();

		try {
			dao.getProductDetails(1007);
		} catch (InvalidProductCodeException e) {
			// TODO Auto-generated catch block
			System.out.println("Product code is not exist in the hashmap");
		}
	}
	@Test
	public void test8DAO()
	{IProductDAO dao = new ProductDAO();

	try {
		dao.getProductDetails(1008);
	} catch (InvalidProductCodeException e) {
		// TODO Auto-generated catch block
		System.out.println("Product code is not exist in the hashmap");
	}
}
}
