package com.tekarch.firebase.utilities;

public class Constants {

	public static final String CUR_DIR = System.getProperty("user.dir");
	public static final String APPLICATION_PROPERTIES = CUR_DIR
			+ "/src/test/resources/applicationProperties.properties";
	
	
	public static void main(String[] args) {
		System.out.println(CUR_DIR);
	}

}