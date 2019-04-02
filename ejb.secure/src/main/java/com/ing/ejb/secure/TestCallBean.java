package com.ing.ejb.secure;

import javax.annotation.security.RolesAllowed;
import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.jboss.security.annotation.SecurityDomain;

@SecurityDomain("other")
@RolesAllowed("jbossadmin")
@Stateless
public class TestCallBean implements TestCall{

	@EJB(lookup ="java:global/ejb.secure/TestBean!com.ing.ejb.secure.TestINF")
	private TestINF remote ;
	
	@Override
	public String hellejb() {
		// TODO Auto-generated method stub
		remote.hello("Mr Customer ..");
		return "hello returning from TestCallBean *********";
	}

}
