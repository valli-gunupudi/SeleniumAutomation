package com.tekarch.Day8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import com.salesforce.automation.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Tables extends BaseTest {

	public void DeleteDataInTable() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://demoqa.com/webtables/");
		Thread.sleep(2000);

		List<WebElement> allData = driver.findElements(By.xpath("//*[contains(@class, 'rt-tr')]"));
		for (WebElement data : allData) {
			System.out.print(data.getText() + "");
		}
		System.out.println();
		System.out.println("=====================");
		WebElement deleteIcon = driver.findElement(By.id("delete-record-2"));

		
		
		List<WebElement> allRows = driver.findElements(By.xpath("//*[contains(@class, 'rt-tr') and @role='row']"));
		boolean pass = false;
		for (int i = 1; i <= allRows.size(); i++) {
			List<WebElement> eachRow = driver.findElements(By.xpath("//*[contains(@class, 'rt-tr-group') and @role='rowgroup']["+i+"]"));
			String val = "Alden";
			for (WebElement temp : eachRow) {
				String Text = temp.getText();
				if (Text.contains(val))
				{
					pass = true;
					break;
				}
			}

			if (pass==true) {
				for (WebElement temp : eachRow) {
					System.out.println(temp.getText());
				}
				Thread.sleep(2000);
				//WebElement deleteIcon = driver.findElement(By.id("delete-record-"+i+")"));
				deleteIcon.click();
				Thread.sleep(2000);
			}
			pass = false;
		}
	}

	public void ExtractDataInTable() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com/tables");
		Thread.sleep(2000);

		List<WebElement> allTable = driver.findElements(By.xpath("//table[@id=\"table1\"]/tbody"));
		List<WebElement> allData = driver.findElements(By.xpath("//table[@id=\"table1\"]/tbody/tr/td"));
		List<WebElement> headers = driver.findElements(By.xpath("//table[@id=\"table1\"]/thead/tr/th"));
		for (WebElement header : headers) {
			System.out.print(header.getText() + " ");
		}
		List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

		boolean pass = false;
		for (int i = 1; i <= allRows.size(); i++) {
			List<WebElement> eachRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]"));
			String val = "$50.00";
			for (WebElement temp : eachRow) {
				String Text = temp.getText();
				if (Text.contains(val))
				{
					pass = true;
					break;
				}
			}

			if (pass==true) {
				for (WebElement temp : eachRow) {
					System.out.println(temp.getText());
				}
			}
			pass = false;
		}

	}

	public void interaction_test() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://qa-tekarch.firebaseapp.com/");
		Thread.sleep(2000);
		WebElement username = driver.findElement(By.id("email_field"));
		username.sendKeys("admin123@gmail.com");

		WebElement password = driver.findElement(By.id("password_field"));
		password.sendKeys("admin123");

		WebElement loginButton = driver.findElement(By.tagName("button"));
		loginButton.click();

		Thread.sleep(2000);
		WebElement interactions = driver.findElement(By.xpath("//div[@class='navbar']/div[2]"));
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(interactions).build().perform();
		Thread.sleep(2000);
		WebElement doubleclickOption = driver.findElement(By.xpath("//a[text()='Double Click']"));
		Thread.sleep(2000);
		clickElement(doubleclickOption, "doubleclick option");

	}

	public void selectDataInTable() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://qa-tekarch.firebaseapp.com/");
		Thread.sleep(2000);
		WebElement username = driver.findElement(By.id("email_field"));
		username.sendKeys("admin123@gmail.com");

		WebElement password = driver.findElement(By.id("password_field"));
		password.sendKeys("admin123");

		WebElement loginButton = driver.findElement(By.tagName("button"));
		loginButton.click();

		Thread.sleep(5000);

		WebElement widget = driver.findElement(By.xpath("//button[contains(text(),'Widget')]"));
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		action.moveToElement(widget).build().perform();
		Thread.sleep(5000);
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

	public void AutoCompleteTest(String text) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://qa-tekarch.firebaseapp.com/");
		Thread.sleep(2000);
		WebElement username = driver.findElement(By.id("email_field"));
		username.sendKeys("admin123@gmail.com");

		WebElement password = driver.findElement(By.id("password_field"));
		password.sendKeys("admin123");

		WebElement loginButton = driver.findElement(By.tagName("button"));
		loginButton.click();

		Thread.sleep(5000);

		WebElement widget = driver.findElement(By.xpath("//button[contains(text(),'Widget')]"));
		Thread.sleep(5000);

		Actions action = new Actions(driver);
		action.moveToElement(widget).build().perform();
		Thread.sleep(5000);
		WebElement AutoComplete = driver.findElement(By.xpath("//a[contains(text(),'AutoComplete')]"));
		clickElement(AutoComplete, "auto complete link");

		Thread.sleep(5000);
		driver.findElement(By.id("myInput")).sendKeys(text.substring(0, 1));
		Thread.sleep(5000);
		List<WebElement> listOfCountries = driver.findElements(By.xpath("//div[@id='myInputautocomplete-list']//div"));
		for (WebElement country : listOfCountries) {
			if (country.getText().equalsIgnoreCase(text)) {
				country.click();
				break;
			}
		}
		Thread.sleep(5000);
		System.out.println("completed");

	}

	public void newWindow_test() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://qa-tekarch.firebaseapp.com/");
		Thread.sleep(2000);
		WebElement username = driver.findElement(By.id("email_field"));
		username.sendKeys("admin123@gmail.com");

		WebElement password = driver.findElement(By.id("password_field"));
		password.sendKeys("admin123");

		WebElement loginButton = driver.findElement(By.tagName("button"));
		loginButton.click();

		Thread.sleep(5000);

		WebElement switchToTab = driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"));
		// WebDriverWait wait = new WebDriverWait(driver, 30);
		// wait.until(ExpectedConditions.visibilityOf(switchToTab));
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		action.moveToElement(switchToTab).build().perform();
		Thread.sleep(5000);

		WebElement WindowTab = driver.findElement(By.xpath("//a[contains(text(),'Windows')]"));
		clickElement(WindowTab, "window Option");
		Thread.sleep(5000);

		WebElement windowNewWindow = driver.findElement(By.xpath("//a[2]/button"));
		clickElement(windowNewWindow, "open new window button ");
		String parentWindow = driver.getWindowHandle();

		Set<String> s = driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1 = s.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();

			if (!parentWindow.equals(child_window)) {
				driver.switchTo().window(child_window);
				System.out.println("url=" + driver.getCurrentUrl() + " and title=" + driver.getTitle());
				Thread.sleep(5000);
				driver.close();
			}

		}
		// switch to the parent window
		driver.switchTo().window(parentWindow);
		System.out.println("url=" + driver.getCurrentUrl() + " and title=" + driver.getTitle());
		/*
		 * switchToNewWindowFrom(parentWindow);
		 * switchToNewWindowFrom(driver.getWindowHandle());
		 */
		Thread.sleep(5000);
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Tables ob = new Tables();
		// ob.interaction_test();
		// ob.AutoCompleteTest("India");
		// ob.selectDataInTable();
		// ob.newWindow_test();
		 ob.DeleteDataInTable();
		//ob.ExtractDataInTable();
	}

}
