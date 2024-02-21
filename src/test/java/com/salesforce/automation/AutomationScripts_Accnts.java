package com.salesforce.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AutomationScripts_Accnts extends BaseTest {
	
	protected Logger AutoScriptsAccnts_log = LogManager.getLogger();
	
	@Test
	public void TC10a_CreateAccount() throws InterruptedException {
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

		WebElement viewAvail = driver.findElement(By.id("duel_select_0"));
		Select selectAccntsDropdown = new Select(viewAvail);
		Thread.sleep(2000);
		selectAccntsDropdown.selectByVisibleText("Accounts");
		Thread.sleep(2000);
		WebElement addBtn = driver.findElement(By.className("rightArrowIcon"));
		addBtn.click();
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
			AutoScriptsAccnts_log.info(textChk + " matched");
		else
			AutoScriptsAccnts_log.info(textChk + " didn't match");
		

		closeBrowser();
	}
	
	@Test
	public void TC10b_CreateAccount() throws InterruptedException {
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
		
		WebElement accntsLink = driver.findElement(By.linkText("Accounts"));
		accntsLink.click();
		Thread.sleep(2000);
		
		WebElement newBtn = driver.findElement(By.xpath("//input[@value=' New ']"));
		newBtn.click();
		Thread.sleep(2000);
		
		WebElement accntName = driver.findElement(By.id("acc2"));
		enterText(accntName, "pathruka", "cmpnyName");
		Thread.sleep(2000);
		
		WebElement accntType = driver.findElement(By.id("acc6"));
		accntType.click();
		Select selectAccntTypeDropdown = new Select(accntType);
		Thread.sleep(2000);
		selectAccntTypeDropdown.selectByVisibleText("Technology Partner");
		Thread.sleep(2000);
		
		WebElement custPriorty = driver.findElement(By.id("00NGA00000UDj9j"));
		custPriorty.click();
		Select selectCustPriortyDropdown = new Select(custPriorty);
		Thread.sleep(2000);
		selectCustPriortyDropdown.selectByVisibleText("High");
		Thread.sleep(2000);

		WebElement saveButton = driver.findElement(By.xpath("//input[@value=' Save ']"));
		saveButton.click();
		Thread.sleep(2000);		

		closeBrowser();
	}
	
	@Test
	public void TC11_Createnewview() throws InterruptedException {
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
		
		WebElement accntsLink = driver.findElement(By.linkText("Accounts"));
		accntsLink.click();
		Thread.sleep(2000);
		
		WebElement newViewLink = driver.findElement(By.linkText("Create New View"));
		newViewLink.click();
		Thread.sleep(2000);
		
		WebElement viewUnqName = driver.findElement(By.id("devname"));
		viewUnqName.sendKeys("unq_close_up");
		Thread.sleep(2000);
		
		WebElement viewName= driver.findElement(By.id("fname"));
		viewName.sendKeys("close up");
		Thread.sleep(2000);
		
		WebElement saveButton = driver.findElement(By.xpath("//input[@value=' Save ']"));
		saveButton.click();
		Thread.sleep(2000);		

		closeBrowser();
	}
	
	
	@Test
	public void TC12_Editview () throws InterruptedException {
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
		
		WebElement accntsLink = driver.findElement(By.linkText("Accounts"));
		accntsLink.click();
		Thread.sleep(2000);
		
		WebElement viewDropdown = driver.findElement(By.id("fcf"));
		Select viewDropdownSelect = new Select(viewDropdown);
		viewDropdownSelect.selectByVisibleText("close up hill mountains");
		Thread.sleep(2000);
		
		WebElement viewEditLink = driver.findElement(By.linkText("Edit"));
		viewEditLink.click();
		Thread.sleep(2000);
		
		WebElement editViewName= driver.findElement(By.id("fname"));
		editViewName.sendKeys("close up hill mountains");
		Thread.sleep(2000);
		
		WebElement acctNameDropdown = driver.findElement(By.id("fcol1"));
		Select acctNameDropdownSelect = new Select(acctNameDropdown);
		acctNameDropdownSelect.selectByVisibleText("Account Name");
		Thread.sleep(2000);
		
		WebElement operatorDropdown = driver.findElement(By.id("fop1"));
		Select operatorDropdownSelect = new Select(operatorDropdown);
		operatorDropdownSelect.selectByVisibleText("contains");
		Thread.sleep(2000);
		
		WebElement value = driver.findElement(By.id("fval1"));
		value.sendKeys("a");
		Thread.sleep(2000);
		
		WebElement saveButton = driver.findElement(By.xpath("//input[@value=' Save ']"));
		saveButton.click();
		Thread.sleep(2000);	
		
		closeBrowser();
	}
	
	@Test
	public void TC13_MergeAccounts() throws InterruptedException {
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
		
		WebElement accntsLink = driver.findElement(By.linkText("Accounts"));
		accntsLink.click();
		Thread.sleep(2000);
		
		WebElement mergeAccntsLink = driver.findElement(By.linkText("Merge Accounts"));
		mergeAccntsLink.click();
		Thread.sleep(2000);
		
		WebElement value = driver.findElement(By.id("srch"));
		value.sendKeys("pathru");
		Thread.sleep(2000);
		
		WebElement fndAccnts = driver.findElement(By.xpath("//input[@value='Find Accounts' and @type='submit']"));
		fndAccnts.click();
		Thread.sleep(2000);
		
		WebElement firstAccnt = driver.findElement(By.xpath("//table/tbody/tr[2]/th"));
		firstAccnt.click();
		Thread.sleep(2000);
		
		WebElement scndAccnt = driver.findElement(By.xpath("//table/tbody/tr[3]/th"));
		scndAccnt.click();
		Thread.sleep(2000);
		
		//table/tbody/tr[2]/th
		
		WebElement next = driver.findElement(By.xpath("//input[@value=' Next ' and @type='submit']"));
		next.click();
		Thread.sleep(2000);
		
		WebElement merge = driver.findElement(By.xpath("//input[@value=' Merge ' ]"));
		merge.click();
		Thread.sleep(2000);
		
		Alert al= driver.switchTo().alert();
		String text=al.getText();
		AutoScriptsAccnts_log.info(text);
		al.accept();
		
		closeBrowser();
	}
	
	@Test(enabled = false)
	public void TC14_accntReport() throws InterruptedException {
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
		
		WebElement accntsLink = driver.findElement(By.linkText("Accounts"));
		accntsLink.click();
		Thread.sleep(2000);
		
		WebElement reportLink = driver.findElement(By.linkText("Accounts with last activity > 30 days"));
		reportLink.click();
		Thread.sleep(2000);
				
		WebElement toFieldCal = driver.findElement(By.id("ext-gen154"));
		toFieldCal.click();
		Thread.sleep(2000);	
		WebElement todayBtn = driver.findElement(By.id("ext-gen277"));
		todayBtn.click();
		Thread.sleep(2000);
		
		WebElement fromFieldCal = driver.findElement(By.id("ext-gen152"));
		fromFieldCal.click();
		Thread.sleep(2000);
		WebElement dropDown = driver.findElement(By.xpath("//*[@id=\"ext-gen274\"]"));
		Select dropDownSelect = new Select(dropDown);
		dropDownSelect.selectByVisibleText("Jan");
		Thread.sleep(2000);
		WebElement butOk = driver.findElement(By.id("ext-gen314"));
		butOk.click();
		Thread.sleep(2000);
		WebElement day = driver.findElement(By.xpath("//*[@id=\"ext-gen268\"]/tbody/tr[2]/td/table/tbody/tr[1]/td[5]/a/em/span"));
		day.click();		
		
		//WebElement dateField = driver.findElement(By.id("ext-gen20"));
		//dateField.sendKeys("Created Date");
		WebElement dateField = driver.findElement(By.xpath("//*[@id=\"ext-gen269\"]"));
		dateField.click();
		Select dateFieldDropdownSelect = new Select(dateField);
		AutoScriptsAccnts_log.info("date field identified");
		Thread.sleep(2000);	
		dateFieldDropdownSelect.selectByVisibleText("Created Date");
		Thread.sleep(2000);
		
		
		WebElement saveButton = driver.findElement(By.xpath("//input[@value=' Save ']"));
		saveButton.click();
		Thread.sleep(2000);	
		
		//Alert al= driver.switchTo().alert();
		WebElement reportName = driver.findElement(By.id("saveReportDlg_reportNameField"));
		reportName.sendKeys("accnt_trans");
		Thread.sleep(2000);	
		WebElement reportUnqName = driver.findElement(By.id("saveReportDlg_DeveloperName"));
		reportUnqName.sendKeys("unq_accnt_trans");
		Thread.sleep(2000);	
		
		saveButton.click();
		Thread.sleep(2000);	
		
		closeBrowser();
	}
	
	public static void main(String[] args) throws InterruptedException {
		AutomationScripts_Accnts ob = new AutomationScripts_Accnts();
		 //ob.TC10a_CreateAccount();
		 //ob.TC10b_CreateAccount();
		 //ob.TC11_Createnewview();
		 //ob.TC12_Editview();
		 //ob.TC13_MergeAccounts();
		 ob.TC14_accntReport();
	}

}

