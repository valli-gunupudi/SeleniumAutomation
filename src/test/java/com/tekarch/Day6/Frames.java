package com.tekarch.Day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/frames/");
		Thread.sleep(5000);
		
		driver.switchTo().frame("frame1");
		String text1 = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println("Text from frame1:"+text1);
		
		//driver.switchTo().defaultContent();
		driver.switchTo().parentFrame();
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='frame2']"));
		driver.switchTo().frame(frame2);
		String text2 = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println("Text from frame2:"+text2);
		
		driver.close();
	}

}
