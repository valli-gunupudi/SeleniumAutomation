package com.salesforce.automation;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.google.common.io.Files;
import com.salesforce.automation.utilities.ExtentReportsUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected static WebDriver driver = null;
	protected Wait<WebDriver> wait = null;
	protected Logger baseLog = LogManager.getLogger();	
	protected ExtentReportsUtility extentReport=ExtentReportsUtility.getInstance();
	
	@BeforeSuite
	public void setUpSuite() {
		baseLog.info("Inside beforeSuite setUpSuite");
	}
	
	@AfterSuite
	public void tearDownSuite() {
		baseLog.info("Inside afterSuite tearDownSuite");
	}
	
	@BeforeTest
	public void setUpTest() {
		baseLog.info("Inside beforeTest setUpTest");
	}
	
	@AfterTest
	public void tearDownTest() {
		baseLog.info("Inside afterTest tearDownTest");
	}
	
	@BeforeClass
	public void setUpClass() {
		baseLog.info("Inside beforeclass setUpClass");
	}
	
	@AfterClass
	public void tearDownClass() {
		baseLog.info("Inside afterclass tearDownclass");
	}	


	public void launchBrowser(String browserName) {

		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			baseLog.info("browser instance chrome created.");
			extentReport.logTestInfo("browser instance chrome created.");
			driver.manage().window().maximize();
			baseLog.info("window is maximized");
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;

		case "opera":
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			driver.manage().window().maximize();
			break;

		case "safari":
			// Safari does not require a separate driver setup, as it is included with macOS
			driver = new SafariDriver();
			break;

		default:
			baseLog.info("Unsupported browser: " + browserName);
		}

		// return driver;
	}
	
	public WebElement findElementById(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;
	}
	
	public WebElement findElementByXpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}
	
	public WebElement findElementByLinkText(String linkText) {
		WebElement element = driver.findElement(By.linkText(linkText));
		return element;
	}

	public void goToUrl(String url) {
		driver.get(url);
		baseLog.info(url + "is entered");

	}
	
	public void clickElement(WebElement ele, String objectName) {
		if (ele.isEnabled()) {
			ele.click();
			baseLog.info(objectName + "button is clicked");
			extentReport.logTestInfo(objectName + "button is clicked");
		} else {
			baseLog.info(objectName + " element is not enabled");

		}
	}
	
	public void clearElement(WebElement ele, String ObjectName) {
		if (ele.isDisplayed()) {
			ele.clear();
			baseLog.info(ObjectName + " is cleared");
		} else {
			baseLog.info(ObjectName + " element is not displayed");
		}
	}
	
	public void waitForVisibility(WebElement ele, int time, String objectName) {
		baseLog.info(objectName + " is waited for visibility ");
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void enterText(WebElement ele, String data, String objectName) {
		if (ele.isDisplayed()) {
			ele.clear();
			ele.sendKeys(data);
			baseLog.info(ele + "data is entered in " + objectName + " textbox");
			extentReport.logTestInfo(ele + "data is entered in " + objectName + " textbox");
		} else {
			baseLog.info(objectName + " element is not displayed");
		}
	}
	
	public void enterInTextBoxById(String Id,String data,String objectName) {
		WebElement element = findElementById(Id);
		enterText(element, data, objectName);
	}



	public String getTextFromElement(WebElement ele, String objectName) {
		String data = ele.getText();
		baseLog.info("text is extracted from " + objectName);
		extentReport.logTestInfo("text is extracted from " + objectName);
		return data;
	}

	public void textMatch(String expectedText, String actualText){
		baseLog.info("Actual text is:" + actualText);
		if (actualText.equalsIgnoreCase(expectedText))
			baseLog.info("text matched");
		else
			baseLog.info("text didn't match");		
	}
	
	public void selectDrpDwAllOp(WebElement ele) {
		Select dropDown = new Select(ele);
		List<WebElement> list = dropDown.getOptions();
		for (WebElement temp : list) {
			baseLog.info(temp.getText());
		}
	}
	
	public void takescreenshot(String filepath) {
		 TakesScreenshot screenCapture=(TakesScreenshot)driver;
		 File src=screenCapture.getScreenshotAs(OutputType.FILE);
		 File destination=new File(filepath);
		 try {
			Files.copy(src, destination);
			baseLog.info("captured the screen");
			extentReport.logTestInfo("captured the screen");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			baseLog.info("went wrong when capturing the screen");
		}
	}

	public void closeBrowser() {
		driver.close();
		baseLog.info("browser instance closed");
		driver = null;
	}

}