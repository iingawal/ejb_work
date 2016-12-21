package com.test;

import javax.ejb.Remote;


@Remote
public interface TxTimeout {

	public String welcomeMsg(String name); 
	
}
