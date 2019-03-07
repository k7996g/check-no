package com.cg.bankApplication.service;

import java.util.HashMap;
import java.util.regex.Pattern;

import com.cg.bankApplication.bean.Account;
import com.cg.bankApplication.bean.Customer;
import com.cg.bankApplication.dao.BankApplicationDaoImpl;
import com.cg.bankApplication.dao.IBankApplicationDao;

public class BankApplicationServiceImpl implements IBankApplicationService {
	IBankApplicationDao ref;

	public BankApplicationServiceImpl() {
		ref = new BankApplicationDaoImpl();
	}

	@Override
	public Account create(double amount, Customer customer) {

		return ref.create(amount, customer);

	}

	@Override
	public Account deposit(int accNo, double amount) {

		return ref.deposit(accNo, amount);
	}

	@Override
	public Account withdraw(int accNo, double amount) {

		return ref.withdraw(accNo, amount);
	}

	@Override
	public double fundTransfer(int giverAccNo, int receiverAccNo, double amount) {

		return ref.fundTransfer(giverAccNo, receiverAccNo, amount);
	}

	@Override
	public HashMap<Integer, String> printTransaction(int accNo) {
		System.out.println(ref.printTransaction(accNo));
		return ref.printTransaction(accNo);
	}

	public boolean checkCustomerName(String customerName) {
		if (Pattern.matches("[A-Z][a-z]{1,19}", customerName))
			return true;
		else
			return false;
	}

	public boolean checkCustomerNo(String customerNo) {
		if (Pattern.matches("[6-9][0-9]{9}", customerNo))
			return true;
		else
			return false;
	}

	public boolean checkCustomerEmail(String customerEmail) {
		if (Pattern.matches("\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b", customerEmail))
			return true;
		else
			return false;
	}

	@Override
	public double showBalance(int accNo) {
		
		return ref.showBalance(accNo);
	}
}
