package com.cg.mra.service;

import com.cg.mra.beans.Account;
import com.cg.mra.exception.MobileRechargeException;

public interface AccountService {
	
	public Account getAccountDetails(String mobileNo) throws MobileRechargeException;
	public double rechargeAccount(String mobileNo, double rechargeAmount) throws MobileRechargeException;
	public boolean validateMobNo(String mobNo);
	public boolean validateAmount(double reAmt);
	
}
