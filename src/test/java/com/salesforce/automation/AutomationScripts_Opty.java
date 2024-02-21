package com.salesforce.automation;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AutomationScripts_Opty extends BaseTest {
	protected Logger AutoScriptsOpty_log = LogManager.getLogger();

	@Test
	public void selectDateDynmc() throws InterruptedException {
		launchBrowser("chrome");
		goToUrl("https://tekarch-ea-dev-ed.develop.my.salesforce.com/");
		Thread.sleep(2000);

		WebElement username = findElementById("username");
		enterText(username, "valli@boxfree.com", "username");

		WebElement password = findElementById("password");
		enterText(password, "Divine86", "password");
		Thread.sleep(2000);

		WebElement loginButton = findElementById("Login");
		clickElement(loginButton, "login");
		Thread.sleep(2000);

		WebElement link = findElementByXpath("//*[@id=\"Opportunity_Tab\"]/a");
		link.click();
		Thread.sleep(2000);

		WebElement newBtn = findElementByXpath("//input[@value=' New ']");
		newBtn.click();
		Thread.sleep(2000);

		WebElement closeDt = findElementById("opp9");
		closeDt.click();
		Thread.sleep(2000);

		WebElement monthName = findElementById("calMonthPicker");
		Select selectMonthDropdown = new Select(monthName);
		Thread.sleep(2000);
		selectMonthDropdown.selectByVisibleText("January");
		Thread.sleep(2000);

		WebElement yearName = findElementById("calYearPicker");
		Select selectYearDropdown = new Select(yearName);
		Thread.sleep(2000);
		selectYearDropdown.selectByVisibleText("2026");
		Thread.sleep(2000);

		List<WebElement> allDays = driver.findElements(By.xpath("//table[@class='calDays']/tbody/tr/td"));
		String date = "15";
		for (WebElement temp : allDays) {
			String webDate = temp.getText();
			if (webDate.contains(date)) {
				AutoScriptsOpty_log.info(webDate);
				temp.click();
			}
		}

		closeBrowser();
	}

	@Test
	public void optyDropDown_TC15() throws InterruptedException {
		launchBrowser("chrome");
		goToUrl("https://tekarch-ea-dev-ed.develop.my.salesforce.com/");
		Thread.sleep(2000);

		WebElement username = findElementById("username");
		enterText(username, "valli@boxfree.com", "username");

		WebElement password = findElementById("password");
		enterText(password, "Divine86", "password");
		Thread.sleep(2000);

		WebElement loginButton = findElementById("Login");
		clickElement(loginButton, "login");
		Thread.sleep(2000);

		WebElement link = findElementByXpath("//*[@id=\"Opportunity_Tab\"]/a");
		link.click();
		Thread.sleep(2000);

		WebElement viewOpty = findElementById("fcf");
		selectDrpDwAllOp(viewOpty);
		Thread.sleep(2000);

		closeBrowser();
	}

	@Test
	public void createNewOpty_TC16() throws InterruptedException {
		launchBrowser("chrome");
		goToUrl("https://tekarch-ea-dev-ed.develop.my.salesforce.com/");
		Thread.sleep(2000);

		WebElement username = findElementById("username");
		enterText(username, "valli@boxfree.com", "username");

		WebElement password = findElementById("password");
		enterText(password, "Divine86", "password");
		Thread.sleep(2000);

		WebElement loginButton = findElementById("Login");
		clickElement(loginButton, "login");
		Thread.sleep(2000);

		WebElement link = findElementByXpath("//*[@id=\"Opportunity_Tab\"]/a");
		link.click();
		Thread.sleep(2000);

		WebElement newBtn = findElementByXpath("//input[@value=' New ']");
		newBtn.click();
		Thread.sleep(2000);

		WebElement optyName = findElementById("opp3");
		enterText(optyName, "bookings", "optyName");
		Thread.sleep(2000);

		WebElement acctName = findElementById("opp4");
		enterText(acctName, "rajanasaccountt", "acctName");
		Thread.sleep(2000);

		WebElement closeDt = findElementById("opp9");
		enterText(closeDt, "05/02/2024", "closeDt");
		Thread.sleep(2000);

		WebElement monthName = findElementById("calMonthPicker");
		Select selectMonthDropdown = new Select(monthName);
		Thread.sleep(2000);
		selectMonthDropdown.selectByVisibleText("January");
		Thread.sleep(2000);

		WebElement yearName = findElementById("calYearPicker");
		Select selectYearDropdown = new Select(yearName);
		Thread.sleep(2000);
		selectYearDropdown.selectByVisibleText("2026");
		Thread.sleep(2000);

		List<WebElement> allDays = driver.findElements(By.xpath("//table[@class='calDays']/tbody/tr/td"));
		String date = "25";
		for (WebElement temp : allDays) {
			String webDate = temp.getText();
			if (webDate.contains(date)) {
				AutoScriptsOpty_log.info(webDate);
				temp.click();
			}
		}

		WebElement stage = findElementById("opp11");
		Select selectStageDropdown = new Select(stage);
		Thread.sleep(2000);
		selectStageDropdown.selectByIndex(2);
		Thread.sleep(2000);

		WebElement prob = findElementById("opp12");
		enterText(prob, "24", "prob");

		WebElement leadSrc = findElementById("opp6");
		Select selectLeadsrcDropdown = new Select(leadSrc);
		Thread.sleep(2000);
		selectLeadsrcDropdown.selectByIndex(2);

		WebElement primCmpgnSrc = findElementById("opp17");
		enterText(primCmpgnSrc, "GC Product Webinar - Jan 7, 2002", "primCmpgnSrc");
		Thread.sleep(2000);

		WebElement saveButton = findElementByXpath("//input[@value=' Save ']");
		saveButton.click();
		Thread.sleep(2000);

		closeBrowser();
	}
	
	@Test
	public void optyPipelineReport_TC17() throws InterruptedException {
		launchBrowser("chrome");
		goToUrl("https://tekarch-ea-dev-ed.develop.my.salesforce.com/");

		Thread.sleep(1000);
		WebElement username = findElementById("username");
		enterText(username, "valli@boxfree.com", "username");

		WebElement password = findElementById("password");
		enterText(password, "Divine86", "password");
		Thread.sleep(1000);

		WebElement loginButton = findElementById("Login");
		clickElement(loginButton, "login");
		Thread.sleep(3000);

		WebElement link = findElementByXpath("//*[@id=\"Opportunity_Tab\"]/a");
		link.click();
		Thread.sleep(2000);

		WebElement optyPipeLink = driver.findElement(By.linkText("Opportunity Pipeline"));
		optyPipeLink.click();
		Thread.sleep(2000);

		closeBrowser();
	}

	@Test
	public void stuckOptyReport_TC18() throws InterruptedException {
		launchBrowser("chrome");
		goToUrl("https://tekarch-ea-dev-ed.develop.my.salesforce.com/");

		Thread.sleep(1000);
		WebElement username = findElementById("username");
		enterText(username, "valli@boxfree.com", "username");

		WebElement password = findElementById("password");
		enterText(password, "Divine86", "password");
		Thread.sleep(1000);

		WebElement loginButton = findElementById("Login");
		clickElement(loginButton, "login");
		Thread.sleep(3000);

		WebElement link = findElementByXpath("//*[@id=\"Opportunity_Tab\"]/a");
		link.click();
		Thread.sleep(2000);

		WebElement stukPipeLink = driver.findElement(By.linkText("Stuck Opportunities"));
		stukPipeLink.click();
		Thread.sleep(2000);

		closeBrowser();

	}

	@Test
	public void qtrlySummRprt_TC19() throws InterruptedException {
		launchBrowser("chrome");
		goToUrl("https://tekarch-ea-dev-ed.develop.my.salesforce.com/");

		Thread.sleep(1000);
		WebElement username = findElementById("username");
		enterText(username, "valli@boxfree.com", "username");

		WebElement password = findElementById("password");
		enterText(password, "Divine86", "password");
		Thread.sleep(1000);

		WebElement loginButton = findElementById("Login");
		clickElement(loginButton, "login");
		Thread.sleep(3000);

		WebElement link = findElementByXpath("//*[@id=\"Opportunity_Tab\"]/a");
		link.click();
		Thread.sleep(2000);

		WebElement qtrlySummDropdown = findElementById("quarter_q");
		Select IntervalSelect = new Select(qtrlySummDropdown);
		IntervalSelect.selectByIndex(2);
		Thread.sleep(2000);

		WebElement IncludeDropdown = findElementById("open");
		Select IncludeSelect = new Select(IncludeDropdown);
		IncludeSelect.selectByIndex(2);
		Thread.sleep(2000);

		WebElement runReportBtn = findElementByXpath("//input[@value='Run Report']");
		runReportBtn.click();
		Thread.sleep(2000);
		closeBrowser();
	}

	public static void main(String[] args) throws InterruptedException {
		AutomationScripts_Opty ob = new AutomationScripts_Opty();
		//ob.selectDateDynmc();
		//ob.optyDropDown_TC15();
		ob.createNewOpty_TC16();
		//ob.optyPipelineReport_TC17();
		//ob.stuckOptyReport_TC18();
		//ob.qtrlySummRprt_TC19();
	}

}