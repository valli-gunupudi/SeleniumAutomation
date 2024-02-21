package com.testng.day1;

import org.testng.annotations.Test;

public class TestNgTestOne  extends BaseTest {//class

	@Test(enabled = true,priority = 3)
	public void testscript_1() { // testng test method
		System.out.println("im am in testscript_1 method in TestNgTestOne class");
	}

	@Test(priority = -1)
	public void testscript_2() {
		System.out.println("im am in testscript_2 method in TestNgTestOne class");
		//int i=10/0;
		//System.out.println("after exception");
	}

	@Test(enabled =true,priority =0,dependsOnMethods ="testscript_1" )
	public void testscript_3() {
		System.out.println("im am in testscript_3 method in TestNgTestOne class");
	}

}
// testng configuration--testng.xml--