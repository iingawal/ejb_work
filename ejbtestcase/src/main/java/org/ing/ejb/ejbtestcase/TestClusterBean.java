package org.ing.ejb.ejbtestcase;

import javax.ejb.Stateless;

@Stateless
public class TestClusterBean implements TestClusterInf {

	@Override
	public void calltoA() {
		// TODO Auto-generated method stub
		System.out.println("in calltoA() method");
		System.out.println("calling toA() method");

		toA();
	}

	@Override
	public void toA() {
		// TODO Auto-generated method stub
		System.out.println("in toA() method");
		System.out.println("calling sayHello() method");

		sayHello(4);

	}

	@Override
	public String sayHello(int limit) {
		
		int counter=0;
	// TODO Auto-generated method stub
		while(counter<limit)
		{
			try{

				Thread.sleep(1000);
				System.out.println("hi");
						
				counter++;
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return "printed for "+limit +" times";

	}

}
