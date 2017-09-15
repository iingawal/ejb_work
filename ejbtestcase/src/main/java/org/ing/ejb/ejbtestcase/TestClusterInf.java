package org.ing.ejb.ejbtestcase;

import javax.ejb.Remote;

@Remote
public interface TestClusterInf {

	public void calltoA();
	public void toA();
	public String sayHello(int counter);
	
}
