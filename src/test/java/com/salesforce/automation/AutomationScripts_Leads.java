package com.salesforce.automation;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AutomationScripts_Leads extends BaseTest {
	
	protected Logger AutoScriptsLeads_log = LogManager.getLogger();
	

	@Test
	public void TC20_leadsTab() throws InterruptedException {
		launchBrowser("chrome");
		goToUrl("https://tekarch-ea-dev-ed.develop.my.salesforce.com/");
		Thread.sleep(2000);
		WebElement username = driver.findElement(By.id("username"));
		enterText(username, "valli@boxfree.com", "username");
		Thread.sleep(2000);
		WebElement password = driver.findElement(By.id("password"));
		enterText(password, "Divine86", "password");
		Thread.sleep(2000);

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickElement(loginButton, "login");

		Thread.sleep(2000);

		WebElement link = driver.findElement(By.linkText("Leads"));
		link.click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"userNavLabel\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);

		closeBrowser();
	}

	@Test
	public void TC21_leadsSelectView() throws InterruptedException {
		launchBrowser("chrome");
		goToUrl("https://tekarch-ea-dev-ed.develop.my.salesforce.com/");

		Thread.sleep(2000);
		WebElement username = driver.findElement(By.id("username"));
		enterText(username, "valli@boxfree.com", "username");

		WebElement password = driver.findElement(By.id("password"));
		enterText(password, "Divine86", "password");
		Thread.sleep(2000);

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickElement(loginButton, "login");
		Thread.sleep(2000);

		WebElement link = driver.findElement(By.linkText("Leads"));
		link.click();
		Thread.sleep(2000);

		WebElement viewLeads = driver.findElement(By.id("fcf"));
		viewLeads.click();
		Select selectLeadsDropdown = new Select(viewLeads);
		Thread.sleep(2000);
		List<WebElement> list = selectLeadsDropdown.getOptions();
		for (WebElement temp : list) {
			AutoScriptsLeads_log.info(temp.getText());
		}
		
		driver.findElement(By.xpath("//*[@id=\"userNavLabel\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);

		closeBrowser();
	}

	@Test
	public void TC22_defaultView() throws InterruptedException {
		launchBrowser("chrome");
		goToUrl("https://tekarch-ea-dev-ed.develop.my.salesforce.com/");
		Thread.sleep(2000);
		
		WebElement username = driver.findElement(By.id("username"));
		enterText(username, "valli@boxfree.com", "username");

		WebElement password = driver.findElement(By.id("password"));
		enterText(password, "Divine86", "password");
		Thread.sleep(2000);

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickElement(loginButton, "login");
		Thread.sleep(2000);

		WebElement link = driver.findElement(By.linkText("Leads"));
		link.click();
		Thread.sleep(2000);
		
		WebElement viewLeads = driver.findElement(By.id("fcf"));
		//viewLeads.click();
		Select selectLeadsDropdown = new Select(viewLeads);
		Thread.sleep(2000);
		selectLeadsDropdown.selectByIndex(1);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"userNavLabel\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);
		
		WebElement username1 = driver.findElement(By.id("username"));
		enterText(username1, "valli@boxfree.com", "username");
		WebElement password1 = driver.findElement(By.id("password"));
		enterText(password1, "Divine86", "password");
		Thread.sleep(2000);
		WebElement loginButton1 = driver.findElement(By.id("Login"));
		clickElement(loginButton1, "login");
		Thread.sleep(2000);
		WebElement link1 = driver.findElement(By.linkText("Leads"));
		link1.click();
		Thread.sleep(2000);
		
		WebElement goButton = driver.findElement(By.xpath("//input[@value=' Go! ']"));
		clickElement(goButton, "Go");
		
		driver.findElement(By.xpath("//*[@id=\"userNavLabel\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);
		
		closeBrowser();
	}

	@Test
	public void TC23() throws InterruptedException {
		launchBrowser("chrome");
		goToUrl("https://tekarch-ea-dev-ed.develop.my.salesforce.com/");

		Thread.sleep(1000);
		WebElement username = driver.findElement(By.id("username"));
		enterText(username, "valli@boxfree.com", "username");

		WebElement password = driver.findElement(By.id("password"));
		enterText(password, "Divine86", "password");
		Thread.sleep(1000);

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickElement(loginButton, "login");
		Thread.sleep(3000);

		WebElement link = driver.findElement(By.linkText("Leads"));
		link.click();
		Thread.sleep(2000);

		WebElement viewLeads = driver.findElement(By.id("fcf"));
		Select selectLeadsDropdown = new Select(viewLeads);
		Thread.sleep(2000);
		selectLeadsDropdown.selectByVisibleText("Today's Leads");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"userNavLabel\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);
		
		closeBrowser();

	}

	@Test
	public void TC24() throws InterruptedException {
		launchBrowser("chrome");
		goToUrl("https://tekarch-ea-dev-ed.develop.my.salesforce.com/");

		Thread.sleep(1000);
		WebElement username = driver.findElement(By.id("username"));
		enterText(username, "valli@boxfree.com", "username");

		WebElement password = driver.findElement(By.id("password"));
		enterText(password, "Divine86", "password");
		Thread.sleep(1000);

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickElement(loginButton, "login");
		Thread.sleep(3000);

		WebElement link = driver.findElement(By.linkText("Leads"));
		link.click();
		Thread.sleep(2000);
		
		WebElement newBtn = driver.findElement(By.xpath("//input[@value=' New ']"));
		newBtn.click();
		Thread.sleep(2000);

		WebElement lastName = driver.findElement(By.id("name_lastlea2"));
		enterText(lastName, "ABCDE", "lastName");
		Thread.sleep(2000);
		
		WebElement cmpnyName = driver.findElement(By.id("lea3"));
		enterText(cmpnyName, "ABCDE", "cmpnyName");
		Thread.sleep(2000);
		
		WebElement saveButton = driver.findElement(By.xpath("//input[@value=' Save ']"));
		saveButton.click();
		Thread.sleep(2000);
		
		String textChk = driver.findElement(By.className("topName")).getText();
		String expectedText = "ABCDE";
		if (textChk.equalsIgnoreCase(expectedText))
			AutoScriptsLeads_log.info(textChk + " matched");
		else
			AutoScriptsLeads_log.info(textChk + " didn't match");
		
		driver.findElement(By.xpath("//*[@id=\"userNavLabel\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);

		closeBrowser();
	}

	public static void main(String[] args) throws InterruptedException {
		AutomationScripts_Leads ob = new AutomationScripts_Leads();
		 ob.TC20_leadsTab();
		 ob.TC21_leadsSelectView();
		 ob.TC22_defaultView();
		 ob.TC23();
		 ob.TC24();
	}

}