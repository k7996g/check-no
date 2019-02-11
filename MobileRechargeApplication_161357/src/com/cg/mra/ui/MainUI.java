package com.cg.mra.ui;

import java.util.Scanner;

import com.cg.mra.beans.Account;
import com.cg.mra.exception.MobileRechargeException;
import com.cg.mra.service.AccountService;
import com.cg.mra.service.AccountServiceImpl;

/**
 * 
 * Date: 22nd Oct., 2018
 * Author: Vamshidhar Thonti
 *
 */

public class MainUI {

	public static void main(String[] args) throws MobileRechargeException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		AccountService service = null;

		int option = 0;

		do {
//			This is to displaty the menu
			System.out.println("1. Account Balance Enquiry");
			System.out.println("2. Recharge Account");
			System.out.println("3. Exit");

			option = sc.nextInt();

			switch (option) {
			case 1:
				//Case1: is to take inputs from the user and to validate the user inputs
				service = new AccountServiceImpl();
				
				System.out.println("Enter Mobile No: ");
				String mobNo = sc.next();
				if(!service.validateMobNo(mobNo))
					throw new MobileRechargeException("Please Enter a Valid Mobile Number");
				
				Account acc = service.getAccountDetails(mobNo);
				
				System.out.println("Your Current Balance is Rs. "+acc.getAccountBalance());

				break;

			case 2:
				//case2: is to take input from user and recharge the account and display the current balance
				service = new AccountServiceImpl();
				
				System.out.println("Enter MobileNo: ");
				String mobileNo = sc.next();
				if(!service.validateMobNo(mobileNo))
					throw new MobileRechargeException("Inavlid Mobile Number...");
				System.out.println("Enter Recharge Amount: ");
				double reAmt = sc.nextDouble();
				if(!service.validateAmount(reAmt))
					throw new MobileRechargeException("Invalid amount entered...");
				
				service.rechargeAccount(mobileNo, reAmt);
				
				break;

			default:
			case 3:
				System.out.println("Exited...");
				break;
			}

		} while (option != 3);
		sc.close();
	}

}
