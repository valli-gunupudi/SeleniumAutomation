package com.tekarch.Day9;

import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tekarch.firebase.utilities.ExcelUtils;

public class DataproviderTest {

	public static final String studentExcelPath = System.getProperty("user.dir")
			+ "/src/test/resources/studentRegistrationData.xlsx";

	@DataProvider(name = "studentdata")
	public Object[][] MydataProvider() {
		String[][] a = new String[5][4];

		List<List<String>> allData = ExcelUtils.readAllDataFromXl(studentExcelPath, "Sheet1");
		for (int i = 1; i < allData.size(); i++) {
			List<String> row = allData.get(i);
			int j = 0;
			for (String temp : row) {
				System.out.println(temp);
				a[i][j] = temp;
				j++;
			}
		}
		return a;

	}

	@Test(dataProvider = "studentdata")
	public void printDetails(String name, String id, String age, String role) {
		System.out.println("testscript started");
		// print single student information(name,gmail,age,role)
		System.out.println("name=" + name + " id=" + id + " age=" + age + " and role=" + role);
		System.out.println("testcript ended");
	}

}
