package com.testng.day1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	@BeforeTest
	public void setUpTest(){
		System.out.println("inside beforeTest BaseTestNG class setUpTest");
			
	}
	
	@BeforeMethod
	public void setUpMethod(){
		System.out.println("inside beforeMethod +++++++++TestNgTestOne class setUpMethod");
			
	}
	
	@AfterTest
	public static void tearDownTest() {
		
		System.out.println("inside afterTest BaseTestNG class tearDownTest");
	}
	
	@BeforeClass
	public static void setUpClass() {
		System.out.println("inside beforeclass   setUpClass");
	}
	@AfterClass
	public static void tearDownclass() {
		System.out.println("inside afterclass  tearDownclass");
	}
	
	@BeforeSuite
	public static void setUpSuite() {
		System.out.println("inside beforeSuite BaseTestNG class setUpSuite");
		
		
	}
	@AfterSuite
	public static void tearDownSuite() {
		System.out.println("inside afterSuite BaseTestNG class tearDownSuite");
	}

	
	
}
