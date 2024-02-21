package com.testng.day1;

import org.testng.annotations.Test;

public class TestNgTestTwo extends BaseTest{

	@Test
	public static void testscript_1() { // testng test method
		System.out.println("im am in testscript_1 method in TestNgTestTwo class");
	}

	@Test
	public static void testscript_2() {
		System.out.println("im am in testscript_2 method in TestNgTestTwo class");
	}

	@Test
	public static void testscript_3() {
		System.out.println("im am in testscript_3 method in TestNgTestTwo class");
	}

}
