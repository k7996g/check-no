package com.cg.mra.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.mra.beans.Account;

public class DataContainer {
	
	static Map<String, Account> map;
	static Map<String, Account> createCollection(){
		
		if(map == null)
			map = new HashMap<String, Account>();
		
		return map;
	}

}
