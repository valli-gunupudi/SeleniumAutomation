package com.tekarch.Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q1 {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
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
		
		Thread.sleep(5000);
		
		WebElement name = driver.findElement(By.id("name"));
		name.sendKeys("Aana");	
		Thread.sleep(2000);
		WebElement lname = driver.findElement(By.id("lname"));
		lname.sendKeys("john");	
		Thread.sleep(2000);
		WebElement postaladdress = driver.findElement(By.id("postaladdress"));
		postaladdress.sendKeys("23045");	
		Thread.sleep(2000);
		WebElement personaladdress = driver.findElement(By.id("personaladdress"));
		personaladdress.sendKeys("xyz");	
		Thread.sleep(2000);
		
		//WebElement maleRadioBtn = driver.findElement(By.xpath("//input[@id='radiobut' and @value='male']"));
		WebElement femaleRadioBtn = driver.findElement(By.xpath("//input[@id='radiobut' and @value='female']"));
		
		if (!femaleRadioBtn.isSelected()) {
			femaleRadioBtn.click();
			System.out.println("female button is selected");
		} else {
			System.out.println("female button is already selected");
		}
		
		Thread.sleep(2000);
		
		WebElement city = driver.findElement(By.id("city"));
		Select selectCity = new Select(city);
		selectCity.selectByVisibleText("GOA");
	
		Thread.sleep(2000);
		
		WebElement course = driver.findElement(By.id("course"));
		Select selectCourse = new Select(course);
		selectCourse.selectByVisibleText("MCA");	
		
		Thread.sleep(2000);
		
		WebElement district = driver.findElement(By.id("district"));
		Select selectDistrict = new Select(district);
		selectDistrict.selectByVisibleText("GOA");		
		
		Thread.sleep(2000);
		
		WebElement state = driver.findElement(By.id("state"));
		Select selectState = new Select(state);
		selectState.selectByVisibleText("GOA");	
		
		Thread.sleep(2000);
		
		WebElement pincode = driver.findElement(By.id("pincode"));
		pincode.sendKeys("1234");	
		Thread.sleep(2000);
		WebElement emailid = driver.findElement(By.id("emailid"));
		emailid.sendKeys("abc@tekarch.com");	
		Thread.sleep(2000);
		WebElement submit = driver.findElement(By.className("bootbutton"));
		submit.click();	
		Thread.sleep(5000);
		driver.close();
	}

}
