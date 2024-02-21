package com.tekarch.Day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalculatorOperating {
	
	public void calc_TC1() throws InterruptedException {
		ChromeOptions opt = new ChromeOptions();
		//opt.setHeadless(true);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(opt);

		driver.manage().window().maximize();

		driver.get("https://qa-tekarch.firebaseapp.com/");
		Thread.sleep(2000);
		WebElement username = driver.findElement(By.id("email_field"));
		username.sendKeys("admin123@gmail.com");
		
		WebElement password = driver.findElement(By.id("password_field"));
		password.sendKeys("admin123");
		
		WebElement loginButton = driver.findElement(By.tagName("button"));
		loginButton.click();
		Thread.sleep(2000);
		
		WebElement calcLink = driver.findElement(By.xpath("//*[@id=\"user_div\"]/div[1]/a[2]"));
		calcLink.click();
		Thread.sleep(2000);
		
		WebElement firstVal7 = driver.findElement(By.xpath("//input[@type='button' and @value='7']"));
		firstVal7.click();
		Thread.sleep(2000);
		
		WebElement addOp = driver.findElement(By.xpath("//input[@type='button' and @value='+']"));
		addOp.click();
		Thread.sleep(2000);
		
		WebElement firstVal5 = driver.findElement(By.xpath("//input[@type='button' and @value='5']"));
		firstVal5.click();
		Thread.sleep(2000);
		
		WebElement eqOp = driver.findElement(By.xpath("//input[@type='button' and @value='=']"));
		eqOp.click();
		Thread.sleep(2000);
		
		WebElement display = driver.findElement(By.xpath("//input[@id=\"display\"]"));
		String Text = display.getAttribute("value");
		System.out.println("The value is:"+Text);
		String expectedText = "12";
		if (Text.equalsIgnoreCase(expectedText))
			System.out.println(Text + " matched");
		else
			System.out.println(Text + " didn't match");
		
		
		
		driver.close();
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		CalculatorOperating ob = new CalculatorOperating();
		 ob.calc_TC1();
	}

}
