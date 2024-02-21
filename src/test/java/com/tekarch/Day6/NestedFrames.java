package com.tekarch.Day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NestedFrames {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/nestedframes/");
		Thread.sleep(2000);

		driver.switchTo().frame("frame1").switchTo().frame(0);
		String displayText = driver.findElement(By.tagName("p")).getText();
		System.out.println(displayText);
		// System.out.println(driver.switchTo().parentFrame().getTitle());
		driver.switchTo().parentFrame();
		String text2 = driver.findElement(By.xpath("//html/body")).getText();
		System.out.println(text2);
		Thread.sleep(2000);
		driver.close();
	}

}
