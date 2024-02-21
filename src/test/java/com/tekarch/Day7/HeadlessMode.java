package com.tekarch.Day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessMode {
	
	public void RunHeadless() throws InterruptedException {
		ChromeOptions opt = new ChromeOptions();
		opt.setHeadless(true);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://qa-tekarch.firebaseapp.com/");
		Thread.sleep(2000);
		WebElement username = driver.findElement(By.id("email_field"));
		username.sendKeys("admin123@gmail.com");
		
		WebElement password = driver.findElement(By.id("password_field"));
		password.sendKeys("admin123");
		
		WebElement loginButton = driver.findElement(By.tagName("button"));
		loginButton.click();
		Thread.sleep(3000);
		
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		HeadlessMode ob = new HeadlessMode();
		ob.RunHeadless();
	}

}
