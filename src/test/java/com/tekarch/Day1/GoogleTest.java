package com.tekarch.Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.edgedriver().setup();
		/*EdgeDriver driver = new EdgeDriver();
		driver.get("https://www.google.com/");
		Thread.sleep(5000);
		WebElement searchBoxEle = driver.findElement(By.name("q"));
		searchBoxEle.sendKeys("selenium");
		Thread.sleep(5000);
		searchBoxEle.sendKeys(Keys.RETURN);*/
		
		EdgeDriver driver = new EdgeDriver();
		driver.get("https://www.walmart.com/");
		Thread.sleep(5000);
		WebElement searchBoxEle = driver.findElement(By.name("q"));
		searchBoxEle.sendKeys("baby diapers");
		Thread.sleep(5000);
		searchBoxEle.sendKeys(Keys.RETURN);
	}

}
