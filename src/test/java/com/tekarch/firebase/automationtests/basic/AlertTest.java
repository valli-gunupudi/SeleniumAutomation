package com.tekarch.firebase.automationtests.basic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertTest {
	public static void main(String[] args) throws InterruptedException {
		String expError="Error : The password is invalid or the user does not have a password.";
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://qa-tekarch.firebaseapp.com/");
		Thread.sleep(5000);
		WebElement username= driver.findElement(By.id("email_field"));
		username.sendKeys("admin123@gmail.com");
		//Alert al1= driver.switchTo().alert();
		Thread.sleep(5000);
		WebElement password=driver.findElement(By.id("password_field"));
		password.sendKeys("");
		Thread.sleep(5000);
		WebElement loginButton= driver.findElement(By.tagName("button"));
		loginButton.click();
		Thread.sleep(5000);
		Alert al= driver.switchTo().alert();
		String actualError=al.getText();
		if(actualError.equals(expError)) {
			System.out.println("test case passed");
		}
		else {
			System.out.println("testcase failed");
		}
		al.accept();
		driver.close();
		
		
		
	}

}
// nullpointer  elementInter