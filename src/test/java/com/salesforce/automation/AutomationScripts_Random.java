package com.salesforce.automation;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AutomationScripts_Random extends BaseTest{
	protected Logger AutoScriptsRndm_log = LogManager.getLogger();
	
	@Test
	public void Random_TC33() throws InterruptedException {
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
		
		WebElement homeLink = driver.findElement(By.linkText("Home"));
		homeLink.click();
		Thread.sleep(2000);
		
		WebElement userLink = driver.findElement(By.xpath("//div[@id='mru005GA000008Stqj']/a"));
		userLink.click();
		Thread.sleep(2000);
		closeBrowser();
	}
	
	@Test
	public void Random_TC34() throws InterruptedException {
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
		
		WebElement homeLink = driver.findElement(By.linkText("Home"));
		homeLink.click();
		Thread.sleep(2000);
		
		WebElement userLink = driver.findElement(By.xpath("//div[@id='mru005GA000008Stqj']/a"));
		userLink.click();
		Thread.sleep(2000);
		
		WebElement Div_elem = driver.findElement(By.tagName("h3"));
		WebElement link = Div_elem.findElement(By.tagName("img"));
		link.click();
		
		// switch to iframe
		driver.switchTo().frame("contactInfoContentId");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='aboutTab']/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='lastName']")).clear();
		WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
		lastName.sendKeys("Abcd");
		Thread.sleep(2000);
		
		WebElement saveButton = driver.findElement(By.xpath("//input[@value='Save All']"));
		saveButton.click();
		Thread.sleep(2000);
		
		/*WebElement cancelButton = driver.findElement(By.xpath("//input[@value='Cancel']"));
		cancelButton.click();
		Thread.sleep(2000);*/
		closeBrowser();
	}
	
	@Test
	public void Random_TC35() throws InterruptedException {
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
		
		WebElement plusLink = driver.findElement(By.className("allTabsArrow"));
		plusLink.click();
		Thread.sleep(2000);
		
		WebElement customizeBtn = driver.findElement(By.className("btnImportant"));
		customizeBtn.click();
		Thread.sleep(2000);

		WebElement selectedTabs = driver.findElement(By.id("duel_select_1"));
		Select selectedTabsDropdown = new Select(selectedTabs);
		Thread.sleep(2000);
		selectedTabsDropdown.selectByIndex(5);
		Thread.sleep(2000);
		WebElement rmvBtn = driver.findElement(By.className("leftArrowIcon"));
		rmvBtn.click();
		Thread.sleep(2000);
		
		WebElement saveButton = driver.findElement(By.xpath("//input[@value=' Save ']"));
		saveButton.click();
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
		
		String textChk = driver.findElement(By.linkText("Accounts")).getText();
		String expectedText = "Accounts";
		if (textChk.equalsIgnoreCase(expectedText))
			AutoScriptsRndm_log.info(textChk + " matched");
		else
			AutoScriptsRndm_log.info(textChk + " didn't match");
		closeBrowser();
	}
	
	@Test
	public void Random_TC36() throws InterruptedException {
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
		
		WebElement link = driver.findElement(By.linkText("Home"));
		link.click();
		Thread.sleep(2000);
		
		WebElement currentDate = driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[2]/a"));
		currentDate.click();
		Thread.sleep(2000);
		
		WebElement e8pmlink = driver.findElement(By.xpath("//*[@id=\"p:f:j_id25:j_id61:28:j_id64\"]/a"));
		e8pmlink.click();
		Thread.sleep(2000);
		
		WebElement icon = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/div[1]/a/img"));
		icon.click();
		Thread.sleep(2000);
		
		String MainWindow = driver.getWindowHandle();

		// To handle all new opened window.
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {
			String ChildWindow = i1.next();

			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
				// Switching to Child window
				driver.switchTo().window(ChildWindow);
				Thread.sleep(2000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				String acttitle = js.executeScript("return document.title").toString();
				Thread.sleep(2000);
				AutoScriptsRndm_log.info("Title:" + acttitle);
				WebElement other = driver.findElement(By.xpath("/html/body/div[2]/ul/li[5]/a"));
				other.click();
				Thread.sleep(2000);
			}

		}
		Thread.sleep(2000);
		driver.switchTo().window(MainWindow);
		
		Thread.sleep(2000);
		WebElement saveButton = driver.findElement(By.xpath("//input[@value=' Save ']"));
		saveButton.click();
		Thread.sleep(2000);
		
		closeBrowser();
		
	}
	
	@Test
	public void Random_TC37() throws InterruptedException {
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
		
		WebElement link = driver.findElement(By.linkText("Home"));
		link.click();
		Thread.sleep(2000);
		
		WebElement currentDate = driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[2]/a"));
		currentDate.click();
		Thread.sleep(2000);
		
		WebElement e4pmlink = driver.findElement(By.xpath("//*[@id=\"p:f:j_id25:j_id61:20:j_id64\"]/a"));
		e4pmlink.click();
		Thread.sleep(2000);
		
		WebElement icon = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/div[1]/a/img"));
		icon.click();
		Thread.sleep(2000);
		
		String MainWindow = driver.getWindowHandle();

		// To handle all new opened window.
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {
			String ChildWindow = i1.next();

			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
				// Switching to Child window
				driver.switchTo().window(ChildWindow);
				Thread.sleep(2000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				String acttitle = js.executeScript("return document.title").toString();
				Thread.sleep(2000);
				AutoScriptsRndm_log.info("Title:" + acttitle);
				WebElement other = driver.findElement(By.xpath("/html/body/div[2]/ul/li[5]/a"));
				other.click();
				Thread.sleep(2000);
			}

		}
		Thread.sleep(2000);
		driver.switchTo().window(MainWindow);
		
		WebElement chkbox = driver.findElement(By.xpath("//*[@id=\"IsRecurrence\"]"));
		chkbox.click();
		Thread.sleep(2000);
		
		WebElement radiobtn = driver.findElement(By.xpath("//*[@id=\"rectypeftw\"]"));
		radiobtn.click();
		Thread.sleep(2000);
		
		LocalDate today = LocalDate.now();
        System.out.println("Current date: " + today);

        //add 1 week to the current date
        LocalDate nextWeek = today.plus(2, ChronoUnit.WEEKS);
        System.out.println("Next week: " + nextWeek);
        
        /*int year = nextWeek.getYear();
        String yr = Integer.toString(year);
        String mnth = nextWeek.getMonth().toString();
        int date = nextWeek.getDayOfMonth();
        String dt = Integer.toString(date);*/
		
        WebElement endDate = driver.findElement(By.xpath("//*[@id=\"RecurrenceEndDateOnly\"]"));
        endDate.click();
		Thread.sleep(2000);
      
		WebElement monthName = findElementById("calMonthPicker");
		Select selectMonthDropdown = new Select(monthName);
		Thread.sleep(2000);
		selectMonthDropdown.selectByVisibleText("March");
		Thread.sleep(2000);

		WebElement yearName = findElementById("calYearPicker");
		Select selectYearDropdown = new Select(yearName);
		Thread.sleep(2000);
		selectYearDropdown.selectByVisibleText("2024");
		Thread.sleep(2000);

		List<WebElement> allDays = driver.findElements(By.xpath("//table[@class='calDays']/tbody/tr/td"));
		String date = "4";
		for (WebElement temp : allDays) {
			String webDate = temp.getText();
			if (webDate.contains(date)) {
				AutoScriptsRndm_log.info(webDate);
				temp.click();
			}
		}
        
        
		Thread.sleep(2000);
		WebElement saveButton = driver.findElement(By.xpath("//input[@value=' Save ']"));
		saveButton.click();
		Thread.sleep(2000);
		
		WebElement mnthvw = driver.findElement(By.xpath("//*[@id=\"bCalDiv\"]/div/div[2]/span[2]/a[3]/img"));
		mnthvw.click();
		Thread.sleep(2000);
		
		closeBrowser();
		
	}


	public static void main(String[] args) throws InterruptedException {
		AutomationScripts_Random ob = new AutomationScripts_Random();
		//ob.Random_TC33();
		//ob.Random_TC34();
		//ob.Random_TC35();
		ob.Random_TC36();		
		//ob.Random_TC37();
	}


}
