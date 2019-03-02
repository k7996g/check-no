package com.capgemini.salesmanagement.ui;

import java.util.Scanner;

import com.capgemini.salesmanagement.exceptions.InvalidProductCategoryException;
import com.capgemini.salesmanagement.exceptions.InvalidProductCodeException;
import com.capgemini.salesmanagement.exceptions.InvalidProductNameException;
import com.capgemini.salesmanagement.exceptions.InvalidProductPriceException;
import com.capgemini.salesmanagement.exceptions.InvalidQuantityException;
import com.capgemini.salesmanagement.service.ISaleService;
import com.capgemini.salesmanagement.service.SaleService;

public class Client 
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		int prodCode;
		int quantity;
		String category="";
		String productName="";
		String prodDescription="";
		float prodPrice;

		
		ISaleService iSale = new SaleService();
		
		while(true)
		{
			System.out.println("          MAIN MENU          ");
			System.out.println("=============================");
			System.out.println();
			
			System.out.println("Please Select The Type Of Service");
			System.out.println("---------------------------------");
			System.out.println();
			System.out.println("Press 1: Billing         Press 2: Exit");
			
			int choice = scanner.nextInt();
			
			switch(choice)
			{
				case 1:	System.out.println("Enter the product code");
						prodCode = scanner.nextInt();
						try 
						{
							iSale.validateProductCode(prodCode);
						}
						catch(InvalidProductCodeException e)
						{
							System.err.println(e.getMessage());
							System.out.println();
							break;
						}
						System.out.println("Enter the quantity");
						quantity = scanner.nextInt();
						try 
						{
							iSale.validateQuantity(quantity);
						}
						catch(InvalidQuantityException e)
						{
							System.err.println(e.getMessage());
							System.out.println();
							break;
						}
						
						System.out.println("Enter Category");
						category = scanner.next();
						try 
						{
							iSale.validateProductCat(category);
						}
						catch(InvalidProductCategoryException e)
						{
							System.err.println(e.getMessage());
							break;
						}
						
						
						System.out.println("Enter product name");
						productName = scanner.nextLine();
						productName +=scanner.nextLine();
						
						System.out.println("Enter Product Description");
						prodDescription = scanner.nextLine();
						try 
						{
							iSale.validateProductName(category, prodDescription);
						}
						catch(InvalidProductNameException e)
						{
							System.err.println(e.getMessage());
							System.out.println();
							break;
						}
						
						System.out.println("Enter product price(RS)");
						prodPrice = scanner.nextFloat();
						try 
						{
							iSale.validateProductPrice(prodPrice);
						}
						catch(InvalidProductPriceException e)
						{
							System.err.println(e.getMessage());
							System.out.println();
							break;
						}
						System.out.println(iSale.displaySales(prodCode,quantity,category,prodDescription,prodPrice)); 
						break;
						
				case 2: System.out.println("Thank you for using this application");
						System.exit(0);
						
			}
		}
	}
}
