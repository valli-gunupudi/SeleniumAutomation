package com.tekarch.Day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q1_SeleniumRadio {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.letskodeit.com/practice");
		Thread.sleep(2000);
		driver.navigate().to("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Walking benefits");
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().back();
;		//WebElement username = driver.findElement(By.id("email_field"));
		//username.sendKeys("admin123@gmail.com");
		//WebElement password = driver.findElement(By.id("password_field"));
		//password.sendKeys("admin123");
		//WebElement loginButton = driver.findElement(By.tagName("button"));
		//loginButton.click();
		//Thread.sleep(5000);

		WebElement hondaRadioBtn = driver.findElement(By.xpath("//input[@id='hondaradio' and @value='honda']"));

		if (!hondaRadioBtn.isSelected()) {
			hondaRadioBtn.click();
			System.out.println("Honda radio button is selected");
		} else {
			System.out.println("Honda radio button is already selected");
		}
		
		Thread.sleep(2000);
		
		WebElement hondaCheckBtn = driver.findElement(By.xpath("//input[@id='hondacheck' and @value='honda']"));
		WebElement bmwCheckBtn = driver.findElement(By.xpath("//input[@id='bmwcheck' and @value='bmw']"));
		WebElement benzCheckBtn = driver.findElement(By.xpath("//input[@id='benzcheck' and @value='benz']"));
		
		if (!hondaCheckBtn.isSelected()) {
			hondaCheckBtn.click();
			System.out.println("Honda check button is selected");
		} 
		if (!bmwCheckBtn.isSelected()) {
			bmwCheckBtn.click();
			System.out.println("BMW check button is selected");
		}
		if (!benzCheckBtn.isSelected()) {
			System.out.println("Benz check button is not selected");
		}
		Thread.sleep(5000);
		
		WebElement hideBtn = driver.findElement(By.xpath("//input[@id='hide-textbox' and @value='Hide']"));
		//WebElement showBtn = driver.findElement(By.xpath("//input[@id='show-textbox' and @value='Show']"));

		if (!hideBtn.isSelected()) {
			hideBtn.click();
			System.out.println("Text box is now hidden");
		} else {
			//showBtn.click();
			System.out.println("The box can be seen");
		}
		
		Thread.sleep(2000);
		
		WebElement disableBtn = driver.findElement(By.xpath("//input[@id='disabled-button' and @value='Disable']"));
		
		if (!disableBtn.isSelected()) {
			disableBtn.click();
			System.out.println("Text box is now disabled");
		} else {
			System.out.println("The box is enabled");
		}
		
		Thread.sleep(5000);
		driver.close();
	}
}