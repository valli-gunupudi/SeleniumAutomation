package com.tekarch.firebase.automationtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tekarch.firebase.utilities.Constants;
import com.tekarch.firebase.utilities.PropertiesUtility;

public class BaseFirebase extends BaseTest{
	
	public void login_firebase() throws InterruptedException {
		launchBrowser("chrome");
		//PropertiesUtility pro=new PropertiesUtility();
		String url=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"url");
		String userName=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"username");
		String passWord=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"password");
		goToUrl(url);		
		Thread.sleep(5000);
		WebElement username= driver.findElement(By.id("email_field"));	
		enterText(username,userName,"username");
		WebElement password=driver.findElement(By.id("password_field"));
		enterText(password,passWord, "password");		
		WebElement loginButton= driver.findElement(By.tagName("button"));
		clickElement(loginButton, "loginbutton");
	}
}


//test1 test4 test16 test150--- application--