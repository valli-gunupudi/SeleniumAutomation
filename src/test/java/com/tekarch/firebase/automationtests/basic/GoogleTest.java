package com.tekarch.firebase.automationtests.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		Thread.sleep(5000);
		
		 WebElement searchBoxEle=driver.findElement(By.name("q"));
		 searchBoxEle.sendKeys("selenium");
		 driver.findElement(By.linkText("About")).click();
		 //searchBoxEle.sendKeys("selenium");
		 

	}

}