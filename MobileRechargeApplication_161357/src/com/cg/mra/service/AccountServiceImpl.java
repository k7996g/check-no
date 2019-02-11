package com.cg.mra.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.mra.beans.Account;
import com.cg.mra.dao.AccountDao;
import com.cg.mra.dao.AccountDaoImpl;
import com.cg.mra.exception.MobileRechargeException;

public class AccountServiceImpl implements AccountService {
	
	AccountDao dao;
	//This constructor is used to create a link between service and DAO layer
	public AccountServiceImpl() {
		// TODO Auto-generated constructor stub
		dao = new AccountDaoImpl();
	}

//	This method is used to get the account details of the given mobile number
	@Override
	public Account getAccountDetails(String mobileNo) throws MobileRechargeException {
		// TODO Auto-generated method stub
		if(!validateMobNo(mobileNo))
			throw new MobileRechargeException("Invalid Mobile Number");
		else
			return dao.getAccountDetails(mobileNo);
	}

//	This method is used to recharge the account of the given mobile number
	@Override
	public double rechargeAccount(String mobileNo, double rechargeAmount) throws MobileRechargeException {
		// TODO Auto-generated method stub
		return dao.rechargeAccount(mobileNo, rechargeAmount);
	}

//	method to validate the mobile number using pattern class
	@Override
	public boolean validateMobNo(String mobNo) {
		// TODO Auto-generated method stub
		Pattern pat = Pattern.compile("[6-9][0-9]{9}");
		Matcher mat = pat.matcher(mobNo);
		return mat.matches();
	}

	//Method to validate the amount
	@Override
	public boolean validateAmount(double reAmt) {
		// TODO Auto-generated method stub
		Pattern pat = Pattern.compile("[1-9][0-9.]{0,15}");
		Matcher mat = pat.matcher(String.valueOf(reAmt));
		return mat.matches();
	}

}
