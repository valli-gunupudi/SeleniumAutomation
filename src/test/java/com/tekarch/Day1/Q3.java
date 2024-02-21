package com.tekarch.Day1;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.edgedriver().setup();		
		EdgeDriver driver = new EdgeDriver();
		driver.get("https://www.selenium.dev/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		//WebElement text = driver.findElement(By.className("d-1 fw-bold"));
		WebElement text = driver.findElement(By.className("d-1"));
		//WebElement text = driver.findElement(By.xpath("/html/body/div/main/section[1]/div/div/div/h1"));
		String actualText =text.getText();
		Thread.sleep(5000);
		String expectedText = "Selenium automates browsers. That's it!";
		
		System.out.println("Text is:" + actualText);
		if(actualText.equalsIgnoreCase(expectedText))
			System.out.println("Title Matched");
		else
			System.out.println("Title didn't match");
		driver.close();
		driver.quit();
	}

}

