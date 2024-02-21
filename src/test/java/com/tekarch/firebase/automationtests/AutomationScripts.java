package com.tekarch.firebase.automationtests;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class AutomationScripts extends BaseFirebase {

	public void succesfullLogin_firrebase() throws InterruptedException {
		String exptext = "Student Registration Form";
		launchBrowser("chrome");
		String expTitle = "Selenium";
		goToUrl("https://qa-tekarch.firebaseapp.com/");
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		String title = driver.getTitle();
		System.out.println("title=" + title);
		if (expTitle.equals(title)) {
			System.out.println("title matched");
		} else {
			System.out.println("title not matched");
		}

		WebElement username = driver.findElement(By.id("email_field"));
		enterText(username, "admin123@gmail.com", "username");

		WebElement password = driver.findElement(By.id("password_field"));
		enterText(password, "admin123", "password");

		WebElement loginButton = driver.findElement(By.tagName("button"));
		clickElement(loginButton, "loginbutton");

		WebElement TextElement = driver.findElement(By.tagName("h1"));// 10th sec-- continue
		// WebDriverWait wait=new WebDriverWait(driver,30);
		// wait.until(ExpectedConditions.visibilityOf(TextElement));

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		// wait.withTimeout(30,TimeUnit.SECONDS);
		/*
		 * wait.withTimeout(Duration.ofSeconds(30));
		 * wait.pollingEvery(Duration.ofSeconds(2));
		 * wait.ignoring(NoSuchElementException.class);
		 * wait.withMessage("fluent wait expires");
		 * wait.until(ExpectedConditions.visibilityOf(TextElement));
		 */

		wait.withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class).withMessage("fluent wait expires")
				.until(ExpectedConditions.visibilityOf(TextElement));

		String actText = getTextFromElement(TextElement, "student registration element");
		System.out.println("text extracted=" + actText);
		if (actText.equals(exptext)) {
			System.out.println("succesfullLogin_firrebase testcase passed...");
		} else {
			System.out.println("succesfullLogin_firrebase testcase failed...");
		}
		closeBrowser();

	}

	public void invalidLogin_firebase1A() throws InterruptedException {
		String expError = "Error : The password is invalid or the user does not have a password.";
		launchBrowser("chrome");
		goToUrl("https://qa-tekarch.firebaseapp.com/");
		Thread.sleep(5000);
		WebElement username = driver.findElement(By.id("email_field"));
		enterText(username, "admin123@gmail.com", "username");
		// Alert al1= driver.switchTo().alert();

		WebElement password = driver.findElement(By.id("password_field"));
		enterText(password, "", "password");

		WebElement loginButton = driver.findElement(By.tagName("button"));
		clickElement(loginButton, "loginbutton");

		Alert al = driver.switchTo().alert();// Alert switchToAler(){}
		String actualError = al.getText();

		if (actualError.equals(expError)) {
			System.out.println("test case passed");
		} else {
			System.out.println("testcase failed");
		}
		al.accept();
		driver.close();

	}

	public void interaction_test() throws InterruptedException {
		login_firebase();
		Thread.sleep(5000);
		WebElement interaction = driver.findElement(By.xpath("//div[@class='navbar']/div[2]"));
		Actions action = new Actions(driver);
		action.moveToElement(interaction).build().perform();
		WebElement doubleclickOption = driver.findElement(By.xpath("//a[text()='Double Click']"));
		clickElement(doubleclickOption, "doubleclick option");

	}

	public void newWindow_test() throws InterruptedException {
		login_firebase();
		Thread.sleep(8000);
		WebElement switchToTab = driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"));
		// WebDriverWait wait = new WebDriverWait(driver, 30);
		// wait.until(ExpectedConditions.visibilityOf(switchToTab));
		mouseOverOnElement(switchToTab, "SwitchTo Tab");

		WebElement WindowTab = driver.findElement(By.xpath("//a[contains(text(),'Windows')]"));
		clickElement(WindowTab, "window Option");

		WebElement windowNewWindow = driver.findElement(By.xpath("//a[2]/button"));
		clearElement(windowNewWindow, "open new window button ");
		String parentWindow = driver.getWindowHandle();
		switchToNewWindowFrom(parentWindow);
		System.out.println("url=" + driver.getCurrentUrl() + " and title=" + driver.getTitle());
		switchToNewWindowFrom(driver.getWindowHandle());
		System.out.println("url=" + driver.getCurrentUrl() + " and title=" + driver.getTitle());

		Thread.sleep(5000);
		driver.quit();
	}

	public void AutoCompleteTest(String text) throws InterruptedException {
		login_firebase();
		WebElement widget = driver.findElement(By.xpath("//button[contains(text(),'Widget')]"));
		waitForVisibility(widget, 30, "widget elemnt");
		mouseOverOnElement(widget, "widget elemnt");
		WebElement AutoComplete = driver.findElement(By.xpath("//a[contains(text(),'AutoComplete')]"));
		clickElement(AutoComplete, "auto complete link");
		Thread.sleep(5000);
		driver.findElement(By.id("myInput")).sendKeys(text.substring(0, 1));
		List<WebElement> listOfCountries = driver.findElements(By.xpath("//div[@id='myInputautocomplete-list']//div"));
		for (WebElement country : listOfCountries) {
			if (country.getText().equalsIgnoreCase(text)) {
				country.click();
				break;
			}
		}
		System.out.println("completed");

	}

	public void selectDataInTable() throws InterruptedException {
		login_firebase();
		WebElement widget = driver.findElement(By.xpath("//button[contains(text(),'Widget')]"));
		waitForVisibility(widget, 30, "widget elemnt");
		mouseOverOnElement(widget, "widget elemnt");
		WebElement TableLink = driver.findElement(By.xpath("//a[contains(text(),'Table')]"));
		clickElement(TableLink, "table link");
		Thread.sleep(5000);
		WebElement allTable = driver.findElement(By.xpath("//table/tbody"));
		List<WebElement> headers = allTable.findElements(By.xpath("//tr/th"));
		for (WebElement header : headers) {
			System.out.print(header.getText() + " ");
		}
		List<WebElement> allData = allTable.findElements(By.xpath("//tr/td"));
		for (WebElement data : allData) {
			System.out.println(data.getText());
		}
	}

	public void FileUploadTest() throws InterruptedException, AWTException {
		login_firebase();
		WebElement fileUploadLink = driver.findElement(By.xpath("//a[text()='File Upload']"));
		waitForVisibility(fileUploadLink, 30, "file upload link");
		clickElement(fileUploadLink, "file upload link");

		WebElement clearButton = driver.findElement(By.xpath("//button[text()='Clear']"));
		waitForVisibility(clearButton, 5, "clear button");
		clickElement(clearButton, "clear button element");

		WebElement browseButton = driver.findElement(By.id("logo"));
		waitForVisibility(browseButton, 30, "choose file button");
		// clickElement(browseButton, "choose file button");
		// browseButton.sendKeys("C:\\Users\\divya\\OneDrive\\Desktop\\google.png");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", browseButton);

		StringSelection stringSelection = new StringSelection("C:\\Users\\divya\\OneDrive\\Desktop\\google5555.png");
		Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
		clpbrd.setContents(stringSelection, null);

		System.out.println("copied to clipboard");
		Thread.sleep(5000);
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);

		// rb.keyPress(KeyEvent.VK_ENTER);
		// rb.keyRelease(KeyEvent.VK_ENTER);

	}

	public static void main(String[] args) throws InterruptedException, AWTException {
		AutomationScripts ob = new AutomationScripts();
		// ob.succesfullLogin_firrebase();
		// ob.invalidLogin_firebase1A();
		// ob.interaction_test();
		ob.AutoCompleteTest("uganda");
		ob.selectDataInTable();
		ob.FileUploadTest();
	}

}
