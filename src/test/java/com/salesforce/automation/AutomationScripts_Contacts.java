package com.salesforce.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

//@Listeners(com.salesforce.automation.MyListener.class)
public class AutomationScripts_Contacts extends BaseTest {
	
	protected Logger AutoScriptsContacts_log = LogManager.getLogger();

	@Test
	public void contacts_TC25() throws InterruptedException {
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

		WebElement link = driver.findElement(By.linkText("Contacts"));
		link.click();
		Thread.sleep(2000);

		WebElement newBtn = driver.findElement(By.xpath("//input[@name='new']"));
		newBtn.click();
		Thread.sleep(2000);

		WebElement lastName = driver.findElement(By.id("name_lastcon2"));
		enterText(lastName, "vadde", "cmpnyName");
		Thread.sleep(2000);

		WebElement accntName = driver.findElement(By.id("con4"));
		enterText(accntName, "kathriya", "cmpnyName");
		Thread.sleep(2000);

		WebElement saveButton = driver.findElement(By.xpath("//input[@value=' Save ']"));
		saveButton.click();
		Thread.sleep(2000);

		closeBrowser();
	}

	@Test
	public void contacts_TC26() throws InterruptedException {
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

		WebElement contactsLink = driver.findElement(By.linkText("Contacts"));
		contactsLink.click();
		Thread.sleep(2000);

		WebElement newViewLink = driver.findElement(By.linkText("Create New View"));
		newViewLink.click();
		Thread.sleep(2000);

		WebElement viewUnqName = driver.findElement(By.id("devname"));
		viewUnqName.sendKeys("contacts_unq_up");
		Thread.sleep(2000);

		WebElement viewName = driver.findElement(By.id("fname"));
		viewName.sendKeys("contacts up");
		Thread.sleep(2000);

		WebElement saveButton = driver.findElement(By.xpath("//input[@value=' Save ']"));
		saveButton.click();
		Thread.sleep(2000);

		closeBrowser();
	}

	@Test
	public void contacts_TC27() throws InterruptedException {
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

		WebElement contactsLink = driver.findElement(By.linkText("Contacts"));
		contactsLink.click();
		Thread.sleep(2000);

		WebElement recentlyCreated = driver.findElement(By.xpath("//select[@id='hotlist_mode']"));
		recentlyCreated.click();
		Select dropDown = new Select(recentlyCreated);
		dropDown.selectByVisibleText("Recently Created");
		Thread.sleep(2000);

		closeBrowser();
	}

	@Test
	public void contacts_TC28() throws InterruptedException {
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

		WebElement contactsLink = driver.findElement(By.linkText("Contacts"));
		contactsLink.click();
		Thread.sleep(2000);

		WebElement mycontactsview = driver.findElement(By.xpath("//select[@id='fcf']"));
		mycontactsview.click();
		Select dropDown = new Select(mycontactsview);
		dropDown.selectByVisibleText("My Contacts");
		Thread.sleep(2000);

		closeBrowser();
	}

	@Test
	public void contacts_TC29() throws InterruptedException {
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

		WebElement contactsLink = driver.findElement(By.linkText("Contacts"));
		contactsLink.click();
		Thread.sleep(2000);

		WebElement recentcontact = driver.findElement(By.linkText("Indian"));
		recentcontact.click();
		Thread.sleep(2000);

		closeBrowser();
	}

	@Test
	public void contacts_TC30() throws InterruptedException {
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

		WebElement contactsLink = driver.findElement(By.linkText("Contacts"));
		contactsLink.click();
		Thread.sleep(2000);

		WebElement newViewLink = driver.findElement(By.linkText("Create New View"));
		newViewLink.click();
		Thread.sleep(2000);

		WebElement viewUnqName = driver.findElement(By.id("devname"));
		viewUnqName.sendKeys("EFGH");
		Thread.sleep(2000);

		WebElement saveButton = driver.findElement(By.xpath("//input[@value=' Save ']"));
		saveButton.click();
		Thread.sleep(2000);

		closeBrowser();
	}

	@Test
	public void contacts_TC31() throws InterruptedException {
		launchBrowser("chrome");
		goToUrl("https://tekarch-ea-dev-ed.develop.my.salesforce.com/");
		Thread.sleep(1000);

		WebElement username = driver.findElement(By.id("username"));
		enterText(username, "valli@boxfree.com", "username");
		Thread.sleep(1000);

		WebElement password = driver.findElement(By.id("password"));
		enterText(password, "Divine86", "password");
		Thread.sleep(1000);

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickElement(loginButton, "login");
		Thread.sleep(3000);

		WebElement contactsLink = driver.findElement(By.linkText("Contacts"));
		contactsLink.click();
		Thread.sleep(2000);

		WebElement newViewLink = driver.findElement(By.linkText("Create New View"));
		newViewLink.click();
		Thread.sleep(2000);

		WebElement viewUnqName = driver.findElement(By.id("devname"));
		viewUnqName.sendKeys("EFGH");
		Thread.sleep(2000);

		WebElement viewName = driver.findElement(By.id("fname"));
		viewName.sendKeys("ABCD");
		Thread.sleep(2000);

		WebElement canButton = driver.findElement(By.xpath("//input[@value='Cancel']"));
		canButton.click();
		Thread.sleep(2000);

		closeBrowser();
	}

	@Test
	public void contacts_TC32() throws InterruptedException {
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

		WebElement contactsLink = driver.findElement(By.linkText("Contacts"));
		contactsLink.click();
		Thread.sleep(2000);

		WebElement newBtn = driver.findElement(By.xpath("//input[@name='new']"));
		newBtn.click();
		Thread.sleep(2000);

		WebElement lastName = driver.findElement(By.id("name_lastcon2"));
		enterText(lastName, "Indian", "cmpnyName");
		Thread.sleep(2000);

		WebElement accntName = driver.findElement(By.id("con4"));
		enterText(accntName, "Global Media", "cmpnyName");
		Thread.sleep(2000);

		WebElement saveButton = driver.findElement(By.xpath("//input[@value='Save & New']"));
		saveButton.click();
		Thread.sleep(2000);

		closeBrowser();
	}

	public static void main(String[] args) throws InterruptedException {
		AutomationScripts_Contacts ob = new AutomationScripts_Contacts();
		// ob.contacts_TC25();
		// ob.contacts_TC26();
		// ob.contacts_TC27();
		// ob.contacts_TC28();
		// ob.contacts_TC29();
		// ob.contacts_TC30();
		// ob.contacts_TC31();
		ob.contacts_TC32();

	}

}
