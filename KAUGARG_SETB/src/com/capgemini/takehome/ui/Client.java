package com.capgemini.takehome.ui;

import java.util.Scanner;

import com.capgemini.takehome.bean.Product;
import com.capgemini.takehome.service.IProductService;
import com.capgemini.takehome.service.ProductService;
import com.capgemini.teakehome.exception.InvalidProductCodeException;
import com.capgemini.teakehome.exception.ProductCodeIsNotValidException;

public class Client {
	static IProductService service = new ProductService();
	static Product product;

	public static void main(String args[]) {
		showMenu();

	}
	//This is for showing the menu to the user
	public static void showMenu() {

		Scanner scanner = new Scanner(System.in);
		while (true) {

			System.out.println("Enter 1 for generating bill by entering product code and quantity");
			System.out.println("Enter 2 for exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				try {
					productDetails();
				} catch (ProductCodeIsNotValidException e) {
					// TODO Auto-generated catch block
					
				}
				break;
			case 2:
				System.exit(0);
				break;
			default:
				System.out.println("Wrong choice");
			}
		}
	}
//Generating and printing the bill for the user if quantity and code is correct else exception is thrown
	public static void productDetails() throws ProductCodeIsNotValidException {
		Scanner scanner = new Scanner(System.in);
		int flag = 0;
		System.out.println("Enter product details");
		System.out.println("Enter the product code");
		int code = scanner.nextInt();
		System.out.println("Enter the quantity");
		int quantity = scanner.nextInt();

		if (new ProductService().quantityValidation(quantity)) {
			try {
				product = service.getProductDetails(code);
				flag = 1;
			} catch (ProductCodeIsNotValidException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			} catch (InvalidProductCodeException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		if (flag == 1) {
			System.out.println("Product Name:\t" + product.getProductName());
			System.out.println("Product Category:\t" + product.getProductCategory());
			System.out.println("Product Price(Rs):\t" + product.getProductPrice());
			System.out.println("Quantity:\t" + quantity);
			System.out.println("Line Total:\t" + product.getProductPrice() * quantity);
		} else
			throw new ProductCodeIsNotValidException("product Code should be of 4 digits");
	}
}
