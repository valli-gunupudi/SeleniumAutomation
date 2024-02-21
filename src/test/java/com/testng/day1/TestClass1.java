package com.testng.day1;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestClass1 extends BaseTest  {
	@Parameters({"browser","version"})
	@Test
	public void login(String name,String ver) {
		System.out.println("in login method from testClass1");
		System.out.println("browser="+name+ " and version="+ver);
		
	}

}
// cross browser testing -- chrome,firefox,ie-- test