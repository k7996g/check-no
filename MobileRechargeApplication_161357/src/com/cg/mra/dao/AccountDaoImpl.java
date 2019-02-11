package com.cg.mra.dao;

import java.util.Map;
import java.util.Set;

import com.cg.mra.beans.Account;
import com.cg.mra.exception.MobileRechargeException;

public class AccountDaoImpl implements AccountDao {
	
	Map<String, Account> accountEntry;
	
	public AccountDaoImpl() {
		// TODO Auto-generated constructor stub
		accountEntry = DataContainer.createCollection();
		accountEntry.put("9010210131", new Account("Prepaid", "Vaishali", 200));
		accountEntry.put("9823920123", new Account("Prepaid", "Megha", 453));
		accountEntry.put("9932012345", new Account("Prepaid", "Vikas", 631));
		accountEntry.put("9010210132", new Account("Prepaid", "Anju", 521));
		accountEntry.put("9010210133", new Account("Prepaid", "Tushar", 632));
		
	}

	@Override
	public Account getAccountDetails(String mobileNo) throws MobileRechargeException {
		// TODO Auto-generated method stub
		
		Set<String> set = accountEntry.keySet();
		String key = null;
		Account ac = null;
		
		for(String s : set){
			if(s.equals(mobileNo)){
				key = s;
			}
		}
		if(key == null){
			System.err.println("Given Account Id Does Not Exist");
			throw new MobileRechargeException("Given Account Id Does Not Exist");
		}
		else
			ac = accountEntry.get(key);
		
		return ac;
	}

	@Override
	public double rechargeAccount(String mobileNo, double rechargeAmount) throws MobileRechargeException {
		Set<String> set = accountEntry.keySet();
		String key = null;
		Account ac = null;
		double bal = 0;
		
		for(String s : set){
			if(s.equals(mobileNo)){
				key = s;
			}
		}
		
		if(key == null){
			System.err.println("Cannot Recharge Account as Given Mobile No Does Not Exists");
			throw new MobileRechargeException("Cannot Recharge Account as Given Mobile No Does Not Exists");
		}
		else{
			ac = accountEntry.get(key);
			bal = ac.getAccountBalance()+rechargeAmount;
			System.out.println("Your Account Recharged Successfully");
			System.out.println("Hello "+ac.getCustomerName()+", Available Balance is "+bal);
		}
		return bal;
	}

}
