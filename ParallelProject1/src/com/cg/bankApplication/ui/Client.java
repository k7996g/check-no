package com.cg.bankApplication.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import com.cg.bankApplication.bean.Account;
import com.cg.bankApplication.bean.Address;
import com.cg.bankApplication.bean.Customer;
import com.cg.bankApplication.service.BankApplicationServiceImpl;
import com.cg.bankApplication.service.IBankApplicationService;

public class Client {
	static Scanner scanner = new Scanner(System.in);
	static IBankApplicationService service = new BankApplicationServiceImpl();
	static Map<Integer, String> map = new HashMap<Integer, String>();

	public static void main(String[] args) {

		showMenu();
	}

	public static void showMenu() {

		while (true) {
			System.out.println("1) Create account");
			System.out.println("2) Deposit amount");
			System.out.println("3) Withdraw amount");
			System.out.println("4) Transfer amount");
			System.out.println("5) ShowBalance");
			System.out.println("6) CheckTransaction");
			System.out.println("7) Exit");
			System.out.println("Enter Your Choice");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				createAccount();
				break;
			case 2:
				depositAmount();
				break;
			case 3:
				withdrawAmount();
				break;
			case 4:
				transferAmount();
				break;
			case 5:
				showBalance();
				break;
			case 6:
				checkTransaction();
				break;
			case 7:
				System.out.println("Thank You!");
				System.exit(0);
				break;
			default:
				System.out.println("Wrong Choice");
				break;
			}

		}
	}

	private static void checkTransaction() {
		System.out.println("Enter Your account no");
		int accNo = scanner.nextInt();
		map = service.printTransaction(accNo);
		System.out.println(map);
		System.out.println("Enter the no of transaction you want to see:");
		int n = scanner.nextInt();
		for (int i = map.size() - 1; i >= n; i--) {
			System.out.println(map.get(i));
		}
	}

	private static void showBalance() {
		System.out.println("Enter Your account no");
		int accNo = scanner.nextInt();
		System.out.println(service.showBalance(accNo));
	}

	private static void transferAmount() {
		System.out.println("Enter Your account no");
		int giverAccNo = scanner.nextInt();
		System.out.println("Enter Your  friend account no");
		int receiverAccNo = scanner.nextInt();
		System.out.println("Enter the amount which you want to transfer");
		double amount = scanner.nextDouble();
		System.out.println("You Transfer Amount " + service.fundTransfer(giverAccNo, receiverAccNo, amount)
				+ " in this account" + receiverAccNo);
	}

	private static void withdrawAmount() {
		System.out.println("Enter Your account no");
		int accNo = scanner.nextInt();
		System.out.println("Enter the amount which you want to withdraw");
		double amount = scanner.nextDouble();
		Account account = service.withdraw(accNo, amount);
		System.out.println("Your Current Balance is:" + account.getWallet().getBalance());
	}

	private static void depositAmount() {
		System.out.println("Enter Your account no");
		int accNo = scanner.nextInt();
		System.out.println("Enter the amount which you want to deposit");
		double amount = scanner.nextDouble();
		Account account = service.deposit(accNo, amount);
		System.out.println("Your Current Balance is:" + account.getWallet().getBalance());
	}

	private static void createAccount() {
		System.out.println("Enter Your Details");
		System.out.println(" ");
		System.out.println("Enter Your Name");
		scanner.nextLine();
		String customerName = scanner.nextLine();
		System.out.println("Enter Your Phone No");

		String customerNo = scanner.nextLine();
		System.out.println("Enter Your MailId");

		String customerEmail = scanner.nextLine();
		System.out.println("Enter Your Country");

		String country = scanner.nextLine();
		System.out.println("Enter Your State");

		String state = scanner.nextLine();
		System.out.println("Enter Your City");

		String city = scanner.nextLine();
		System.out.println("Enter Your street");

		String street = scanner.nextLine();
		System.out.println("Enter Your houseNo");
		int houseNo = scanner.nextInt();
		BankApplicationServiceImpl b = new BankApplicationServiceImpl();
		if (b.checkCustomerName(customerName) && b.checkCustomerNo(customerNo) && b.checkCustomerEmail(customerEmail)) {
			Customer customer = new Customer(new Random().nextInt(1000) + 1, customerName, customerNo, customerEmail,
					new Address(country, state, city, street, houseNo));
			System.out.println("Enter the amount to which you want to open your account");
			double amount = scanner.nextDouble();
			service.create(amount, customer);
		} else
			System.out.println("Details are Wrong");
	}
}
