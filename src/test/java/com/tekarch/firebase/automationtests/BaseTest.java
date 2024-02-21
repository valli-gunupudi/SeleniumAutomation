package com.tekarch.firebase.automationtests;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
// getTitle, switchToAlert acceptAlert DismissAlert getTextFromAlert
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected WebDriver driver = null;
	protected Wait<WebDriver> wait = null;
	

	public void launchBrowser(String browserName) {

		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("browser instance chrome created.");
			driver.manage().window().maximize();
			System.out.println("window is maximized");
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
			System.out.println("Unsupported browser: " + browserName);
		}

		// return driver;
	}
	
	public void goToUrl(String url) {
		driver.get(url);
		System.out.println(url + "is entered");
		
	}

	public void enterText(WebElement ele, String data, String objectName) {
		if (ele.isDisplayed()) {
			ele.clear();
			ele.sendKeys(data);
			System.out.println("username data is entered in " + objectName + " textbox");
		} else {
			System.out.println(objectName + " element is not displayed");
		}
	}
	
	public void clickElement(WebElement ele, String objectName) {
		if (ele.isEnabled()) {
			ele.click();
			System.out.println(objectName + "button is clicked");
			
		} else {
			System.out.println(objectName+" element is not enabled");
			
		}
	}
	
	public String getTextFromElement(WebElement ele, String objectName) {
		String data = ele.getText();
		System.out.println("text is extracted from "+objectName);
		return data;
	}
	
	public void closeBrowser() {
		driver.close();
		System.out.println("browser instance closed");
		driver=null;
	}
	
	
	public void maximiseBrowser() {
		driver.manage().window().maximize();
		//myLog.info("browser window has maximized");
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void refreshPage() {
		driver.navigate().refresh();
		System.out.println("page is refreshed");

	}



	public void quitBrowser() {
		driver.quit();
		System.out.println("all browser closed");
		driver=null;
		
	}

	

	public void clearElement(WebElement ele, String ObjectName) {
		if (ele.isDisplayed()) {
			ele.clear();
			System.out.println(ObjectName + " is cleared");
		} else {
			System.out.println(ObjectName + " element is not displayed");
		}
	}

	

	// ****************handling alerts reusable methods*************************

	public Alert switchToAlert() {

		Alert alert = driver.switchTo().alert();
		System.out.println("switched to alert");
		return alert;
	}

	public void AcceptAlert(Alert alert) {

		System.out.println("Alert accepted");
		alert.accept();

	}

	public String getAlertText(Alert alert, String objectname) {
		System.out.println("etracting text in the " + objectname + "alert");
		String text = alert.getText();
		System.out.println("text is extracted from alert box is==" + text);
		return text;

	}

	public void dismisAlert() {

		Alert alert = switchToAlert();
		alert.dismiss();
		System.out.println("Alert dismissed");

	}
	// ******************************alert ends**************************************

	// ******************************Action class reusable methods**************************************
	

	public void mouseOverOnElement(WebElement ele, String objName) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
		System.out.println(" cursor moved to web element " + objName);
	}

	public void ContextClickOnElement(WebElement ele, String objName) {
		Actions action = new Actions(driver);
		action.contextClick(ele).build().perform();
		System.out.println("right click persormed on web element " + objName);
	}

	// ******************************Action class reusable method ends**************************************

	// ******************************Select class reusable method starts*************************************

	public void selectByTextData(WebElement element, String text, String objName) {
		Select selectCity = new Select(element);
		selectCity.selectByVisibleText(text);
		System.out.println(objName + " selected " + text);

	}

	public void selectByIndexData(WebElement element, int index, String objName) {
		waitForVisibility(element, 5, objName);
		Select selectCity = new Select(element);
		selectCity.selectByIndex(index);
		System.out.println(objName + " selected with index=" + index);

	}

	public void selectByValueData(WebElement element, String text, String objName) {
		Select selectCity = new Select(element);
		selectCity.selectByValue(text);
		System.out.println(objName + " selected ");
	}
	
	public WebElement selectFromListUsingText(List<WebElement> list, String text) {
		WebElement element = null;
		for (WebElement i : list) {
			if (i.getText().equalsIgnoreCase(text)) {
				System.out.println("selected=" + i.getText());
				element = i;
				break;
			}

		}
		return element;

	}

	// ******************************select class reusable method ends**************************************

	// ******************************wait reusable method starts**************************************

	public void waitUntilPageLoads() {
		System.out.println("waiting until page loads with 30 sec maximum");
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	}
	public void waitForVisibility(WebElement ele, int time, int pollingtime, String objectName) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait
		.withTimeout(Duration.ofSeconds(time))
		.pollingEvery(Duration.ofSeconds(pollingtime))
		.ignoring(ElementNotInteractableException.class)
		.withMessage(objectName+" is not visible.fluent wait time expires");

		wait.until(ExpectedConditions.visibilityOf(ele));
		System.out.println(objectName + " is waited for visibility using fluent wait");
	}

	public void WaitUntilPresenceOfElementLocatedBy(By locator, String objName) {
		System.out.println("waiting for an web element " + objName + " for its visibility");
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

	}

	public void waitUntilElementToBeClickable(By locator, String objName) {
		System.out.println("waiting for an web element " + objName + " to be clickable");
		wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void waitForVisibility(WebElement ele, int time, String objectName) {
		System.out.println(objectName + " is waited for visibility ");
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void waitForAlertPresent(int time) {
		System.out.println( "waited for alert to display ");
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void switchToNewWindowFrom(String currentWindowHandle) {
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!currentWindowHandle.equalsIgnoreCase(handle))
				driver.switchTo().window(handle);
		}
		System.out.println("switched to new window");
	}
	// ******************************wait reusable method starts**************************************


	
	public void takescreenshot(String filepath) {
		 TakesScreenshot screenCapture=(TakesScreenshot)driver;
		 File src=screenCapture.getScreenshotAs(OutputType.FILE);
		 File destination=new File(filepath);
		 try {
			Files.copy(src, destination);
			System.out.println("captured the screen");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("captured the screen");
			
		}
	}
	
	public void takescreenshot(WebElement element,String filepath) {
		 File src=element.getScreenshotAs(OutputType.FILE);
		 File destination=new File(filepath);
		 try {
			Files.copy(src, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("captured the screen");
			
		}
	}

}