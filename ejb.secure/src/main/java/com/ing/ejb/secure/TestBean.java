package com.ing.ejb.secure;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

import org.jboss.security.annotation.SecurityDomain;

@SecurityDomain("other")
@RolesAllowed("testadmin")
@Stateless
public class TestBean implements TestINF{

	@Override
	public String hello(String name) {
		// TODO Auto-generated method stub
		return "hello I am returning from Test Bean ........";
	}

	
}
