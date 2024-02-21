package com.tekarch.Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.edgedriver().setup();	
		EdgeDriver driver = new EdgeDriver();
		driver.get("https://www.google.com/");
		Thread.sleep(5000);
		WebElement link = driver.findElement(By.linkText("About"));
		Thread.sleep(5000);
		link.click();
		Thread.sleep(5000);
		String expectedTitle = "Google - About Google, Our Culture & Company News";
		String actualTitle =driver.getTitle();
		System.out.println("Page title is:" + actualTitle);
		if(actualTitle.equalsIgnoreCase(expectedTitle))
			System.out.println("Title Matched");
		else
			System.out.println("Title didn't match");
		driver.close();
		driver.quit();
	}

}
