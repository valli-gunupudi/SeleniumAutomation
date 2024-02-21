package com.tekarch.firebase.automationtests.basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class findElementsTest {
	public static void main(String[] args) {
		//
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.letskodeit.com/practice");
		 WebElement ele= driver.findElement(By.xpath("//*[@id='checkbox-example-div']/fieldset/label"));
		 System.out.println(ele.getText());
		 List<WebElement> listOfcar= driver.findElements(By.xpath("//*[@id='checkbox-example-div']/fieldset/label"));
		 System.out.println(listOfcar.get(1).getText());
		 
	}

}