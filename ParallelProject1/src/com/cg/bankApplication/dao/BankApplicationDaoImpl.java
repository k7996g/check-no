package com.cg.bankApplication.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.cg.bankApplication.bean.Account;
import com.cg.bankApplication.bean.Customer;
import com.cg.bankApplication.bean.Wallet;

public class BankApplicationDaoImpl implements IBankApplicationDao {
	Map<Account, Customer> map = new HashMap<Account, Customer>();
	Map<Integer, String> map1 = new HashMap<Integer, String>();
	
	Account account;
	Customer customer;
	Wallet wallet;

	public BankApplicationDaoImpl() {
		account = new Account();
		wallet = new Wallet();
	}

	@Override
	public Account create(double amount, Customer customer) {
		account.setAccNo(new Random().nextInt(10000) + 1000);
		System.out.println("Your Account No is:" + account.getAccNo());
		wallet.setWalletId(account.getAccNo());
		wallet.setBalance(amount);
		account.setWallet(wallet);
		map.put(account, customer);
		return account;
	}

	@Override
	public Account deposit(int accNo, double amount) {
		for (Map.Entry<Account, Customer> m : map.entrySet()) {
			if (m.getKey().getAccNo() == accNo) {
				int balance = (int) (m.getKey().getWallet().getBalance() + amount);
				m.getKey().getWallet().setBalance(balance);
				map1.put(accNo, "You deposit amount:" + "  amount");
				return m.getKey();
			}
		}
		return null;
	}

	@Override
	public Account withdraw(int accNo, double amount) {
		for (Map.Entry<Account, Customer> m : map.entrySet()) {
			if (m.getKey().getAccNo() == accNo) {
				int balance = (int) (m.getKey().getWallet().getBalance() - amount);
				m.getKey().getWallet().setBalance(balance);
				map1.put(accNo, "You withdraw amount:" + "  amount");
				return m.getKey();
			}
		}
		return null;
	}

	@Override
	public double fundTransfer(int giverAccNo, int receiverAccNo, double amount) {
		withdraw(giverAccNo, amount);
		deposit(receiverAccNo, amount);
		map1.put(giverAccNo, "You transfer amount:" + "  amount");

		return amount;
	}

	@Override
	public HashMap<Integer, String> printTransaction(int accNo) {
		for (Map.Entry<Account, Customer> m : map.entrySet()) {
			if (m.getKey().getAccNo() == accNo) {
				System.out.println(map1);
				return (HashMap<Integer, String>) map1;

			}
		}
		return null;

	}

	@Override
	public double showBalance(int accNo) {
		for (Map.Entry<Account, Customer> m : map.entrySet()) {
			if (m.getKey().getAccNo() == accNo) {
				return m.getKey().getWallet().getBalance();

			}
		}
		return 0;
	}

}
