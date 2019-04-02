package com.ing.ejb.secure;

import javax.ejb.Remote;

@Remote
public interface TestINF {

	String hello(String name);
}
