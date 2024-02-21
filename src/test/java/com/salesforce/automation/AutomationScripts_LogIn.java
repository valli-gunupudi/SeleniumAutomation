package com.salesforce.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesforce.automation.utilities.Constants;
import com.salesforce.automation.utilities.PropertiesUtility;

import java.io.IOException;
import java.util.Objects;

public class AutomationScripts_LogIn extends BaseTest {

	protected Logger AutoScriptsLogIn_log = LogManager.getLogger();

	@BeforeMethod
	public void setUpMethod() {
		AutoScriptsLogIn_log.info("Inside beoreMethod Testng setUpmethod");
	}

	@AfterMethod
	public void tearDownMethod() {
		AutoScriptsLogIn_log.info("Inside afterMethod Testng tearDownmethod");
	}

	@Parameters({"browser"})
	@Test // (enabled = true, priority = 3)
	public void loginErrorMessage1(@Optional("chrome") String name) throws InterruptedException, IOException {
		// launchApp
		launchBrowser(name);
		goToUrl("https://tekarch-ea-dev-ed.develop.my.salesforce.com/");
		Thread.sleep(2000);
		// Enter User Name
		WebElement username = findElementById("username");
		enterText(username, "valli@boxfree.com", "username");
		Thread.sleep(2000);
		// Clear Password field
		WebElement passwordButton = findElementById("password");
		clearElement(passwordButton, "password");
		Thread.sleep(2000);
		// Click on Log in button
		WebElement loginButton = findElementById("Login");
		clickElement(loginButton, "login");
		Thread.sleep(2000);
		// Click on Log in button result, Error message displayed
		// verification
		WebElement text = findElementByXpath("//div[@id=\"error\"]");
		String expectedText = "Please enter your password.";
		String actualText = text.getText();
		textMatch(expectedText, actualText);
		Thread.sleep(10000);
		closeBrowser();
	}

	@Test(groups = { "smoke" })
	public void loginSalesforce2() throws InterruptedException, IOException {
		// Launch SFDC application
		String userName=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"username");
		String passWord=PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,"password");	
		extentReport.logTestInfo("username and password extracted from properties file");
		
		launchBrowser("chrome");
		goToUrl("https://tekarch-ea-dev-ed.develop.my.salesforce.com/");
		Thread.sleep(2000);
		// Login to SFDC
		WebElement username = findElementById("username");
		enterText(username, userName, "username");
		Thread.sleep(2000);
		WebElement password = findElementById("password");
		password = null;
		if (Objects.nonNull(password)) {
			enterText(password, passWord, "password");
		} else {
			AutoScriptsLogIn_log.error("failure");
		}		
		Thread.sleep(2000);
		WebElement loginButton = findElementById("Login");
		clickElement(loginButton, "login");
		Thread.sleep(2000);
		// verification
		WebElement usermenu = driver.findElement(By.id("userNavLabel"));
		String expUN = "chandu rajana";
		String actUN = usermenu.getText();
		textMatch(expUN, actUN);
		Thread.sleep(10000);
		closeBrowser();
	}

	@Test // (dependsOnMethods="loginSalesforce2")
	public void rememberMe3() throws InterruptedException, IOException {
		// Launch SFDC application
		launchBrowser("chrome");
		goToUrl("https://tekarch-ea-dev-ed.develop.my.salesforce.com/");
		Thread.sleep(1000);
		// Login to SFDC with remember username check box checked
		WebElement username = findElementById("username");
		enterText(username, "valli@boxfree.com", "username");
		Thread.sleep(1000);
		WebElement password = findElementById("password");
		enterText(password, "Divine86", "password");
		Thread.sleep(1000);
		WebElement rememberMeChk = findElementByXpath("//*[@id=\"rememberUn\"]");
		if (!rememberMeChk.isSelected()) {
			rememberMeChk.click();
			AutoScriptsLogIn_log.info("Remember me check button is selected");
		}
		Thread.sleep(1000);
		WebElement loginButton = findElementById("Login");
		clickElement(loginButton, "login");
		Thread.sleep(3000);
		// Log out of SFDC
		driver.findElement(By.id("userNavLabel")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);
		// Check for Username field
		// verification
		WebElement usernameChk = findElementById("idcard-identity");
		String actualText = usernameChk.getText();
		String expectedText = "valli@boxfree.com";
		textMatch(expectedText, actualText);
		Thread.sleep(10000);
		closeBrowser();

	}

	@Test
	public void forgotPassword4a() throws InterruptedException {
		// Launch SFDC application
		launchBrowser("chrome");
		goToUrl("https://tekarch-ea-dev-ed.develop.my.salesforce.com/");
		Thread.sleep(2000);
		// Click on Forgot password
		WebElement forgotPwdLink = findElementById("forgot_password_link");
		forgotPwdLink.click();
		Thread.sleep(3000);
		// Test Forgot password
		WebElement username = findElementById("un");
		enterText(username, "valli@boxfree.com", "username");
		Thread.sleep(3000);

		WebElement continueButton = findElementById("continue");
		clickElement(continueButton, "continue");
		Thread.sleep(3000);
		// verification
		String actualText = driver.findElement(By.tagName("h1")).getText();
		String expectedText = "Check Your Email";
		textMatch(expectedText, actualText);
		Thread.sleep(10000);
		closeBrowser();

	}

	@Test(groups = { "sanity", "regression" })
	public void forgotPassword4b() throws InterruptedException {
		// Launch the application
		launchBrowser("chrome");
		goToUrl("https://tekarch-ea-dev-ed.develop.my.salesforce.com/");
		Thread.sleep(2000);
		// Enter Wrong USerName
		WebElement username = findElementById("username");
		enterText(username, "123", "username");
		Thread.sleep(2000);
		// Enter wrong PWd
		WebElement password = findElementById("password");
		enterText(password, "22131", "password");
		Thread.sleep(2000);
		// Click Login
		WebElement loginButton = findElementById("Login");
		clickElement(loginButton, "login");
		Thread.sleep(2000);
		// verification
		String expectedText = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		WebElement Text = findElementById("error");
		String actualText = Text.getText();
		textMatch(expectedText, actualText);
		Thread.sleep(10000);
		closeBrowser();
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		AutomationScripts_LogIn ob = new AutomationScripts_LogIn();
		// ob.loginErrorMessage1("chrome");
		// ob.loginSalesforce2();
		 ob.rememberMe3();
		// ob.forgotPassword4a();
		// ob.forgotPassword4b();
	}

}