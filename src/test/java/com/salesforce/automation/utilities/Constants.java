package com.salesforce.automation.utilities;

public class Constants {

	public static final String CUR_DIR = System.getProperty("user.dir");
	public static final String APPLICATION_PROPERTIES = CUR_DIR
			+ "/src/test/resources/applicationProperties.properties";
	public static final String STUDETN_REGI_DATA_XLSX=CUR_DIR+"/src/test/resources/studentRegistrationData.xlsx";
	public static final String SPARKS_HTML_REPORT_PATH=CUR_DIR+"/reports/report.html";
	public static final String SCREENSHOTS_DIRECTORY_PATH=CUR_DIR+"/reports/screenshots/";
	
	public static void main(String[] args) {
		System.out.println(CUR_DIR);
	}

}