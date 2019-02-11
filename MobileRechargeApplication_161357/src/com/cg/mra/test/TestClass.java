package com.cg.mra.test;

import org.junit.Test;

import com.cg.mra.exception.MobileRechargeException;
import com.cg.mra.service.AccountService;
import com.cg.mra.service.AccountServiceImpl;

public class TestClass {
	
//	Testing all the possible cases for the method rechargeAmount
	
	AccountService as = new AccountServiceImpl();
	
	@Test (expected = MobileRechargeException.class)
	public void TestOnRechargeAccountMethodV2() throws MobileRechargeException{
		as.rechargeAccount("78945621", 123);
		as.rechargeAccount("7894581230", 0);
		as.rechargeAccount("8125407963", -45);
		
	}
	@Test (expected = MobileRechargeException.class)
	public void TestOnRechargeAccountMethodV3() throws MobileRechargeException{
		as.rechargeAccount("@@#^%", 45654);
		as.rechargeAccount(" ", -45643);
		as.rechargeAccount("	", -45643);
		as.rechargeAccount("afsfAAF#%#", -45643);
		as.rechargeAccount("", -45643);
		
		
	}

}
