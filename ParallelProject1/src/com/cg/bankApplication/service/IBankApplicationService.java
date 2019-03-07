package com.cg.bankApplication.service;

import java.util.HashMap;

import com.cg.bankApplication.bean.Account;
import com.cg.bankApplication.bean.Customer;

public interface IBankApplicationService {
	Account create(double amount,Customer customer);
	Account deposit(int accNo,double amount);
	Account withdraw(int accNo,double amount);
	double fundTransfer(int giverAccNo,int receiverAccNo,double amount);
	HashMap<Integer,String> printTransaction(int accNo);
	double showBalance(int accNo);
}