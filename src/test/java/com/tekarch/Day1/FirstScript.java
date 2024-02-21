package com.tekarch.Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstScript {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver=new EdgeDriver();
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
		
	}

}
