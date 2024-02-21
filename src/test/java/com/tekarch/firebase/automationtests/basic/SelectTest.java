package com.tekarch.firebase.automationtests.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectTest {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://qa-tekarch.firebaseapp.com/");
		Thread.sleep(5000);
		WebElement username= driver.findElement(By.id("email_field"));
		username.sendKeys("admin123@gmail.com");
		Thread.sleep(5000);
		WebElement password=driver.findElement(By.id("password_field"));
		password.sendKeys("admin123");
		Thread.sleep(5000);
		WebElement loginButton= driver.findElement(By.tagName("button"));
		loginButton.click();
		Thread.sleep(5000);
		
		WebElement cityDropDown= driver.findElement(By.id("city"));
		Select se=new Select(cityDropDown);
		//se.selectByVisibleText("MUMBAI");
		se.selectByIndex(1);
		
	}

}