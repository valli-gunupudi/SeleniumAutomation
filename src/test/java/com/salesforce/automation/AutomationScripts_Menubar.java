package com.salesforce.automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
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

public class AutomationScripts_Menubar extends BaseTest {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	protected Logger AutoScriptsMenubar_log = LogManager.getLogger();
	
	@Test
	public void menuDropDown_TC05() throws InterruptedException {
		// Launch and Login
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
		// Launch and Login verification
		WebElement usermenu = driver.findElement(By.id("userNavLabel"));
		String expUN = "chandu rajana";
		String actUN = usermenu.getText();
		textMatch(expUN, actUN);
		// Check for user menu for <username> drop down
		List<String> expList = new ArrayList<>();
		expList.add("My Profile");
		expList.add("My Settings");
		expList.add("Developer Console");
		expList.add("Switch to Lightning Experience");
		expList.add("Logout");

		List<String> actList = new ArrayList<>();
		WebElement usermenu1 = driver.findElement(By.id("userNavLabel"));
		usermenu1.click();
		Thread.sleep(2000);
		List<WebElement> usermenulist = driver.findElements(By.xpath("//*[@id='userNav-menuItems']/a"));
		for (WebElement temp : usermenulist) {
			actList.add((temp.getText()));
			AutoScriptsMenubar_log.info(temp.getText());
		}
		Thread.sleep(5000);
		// verification
		boolean listChk = expList.containsAll(actList);
		if (listChk == true) {
			AutoScriptsMenubar_log.info("list check passed");
		} else {
			AutoScriptsMenubar_log.info("list check failed");
		}
		Thread.sleep(2000);
		closeBrowser();
	}

	@Test
	public void menuDropDown_TC06() throws InterruptedException, AWTException {
		// Select user menu for <username> drop down[TC01]
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
		// Click "My profile" option from user menu
		driver.findElement(By.id("userNavLabel")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("My Profile")).click();
		Thread.sleep(5000);
		// Click on edit profile button to edit contact information
		WebElement Div_elem = driver.findElement(By.tagName("h3"));
		WebElement link = Div_elem.findElement(By.tagName("img"));
		link.click();
		// Click on About tab
		driver.switchTo().frame("contactInfoContentId");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='aboutTab']/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='lastName']")).clear();
		WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
		lastName.sendKeys("Gunupudi");
		Thread.sleep(2000);
		WebElement cancelButton = driver.findElement(By.xpath("//input[@value='Cancel']"));
		cancelButton.click();
		Thread.sleep(2000);
		// Click on post link
		driver.switchTo().parentFrame();
		WebElement post = driver.findElement(By.xpath("//*[@id=\'publisherAttachTextPost\']/span[1]"));
		post.click();
		Thread.sleep(2000);
		WebElement iframe = driver.findElement(By.xpath("//div[@id='cke_43_contents']/iframe"));
		driver.switchTo().frame(iframe);
		Thread.sleep(2000);
		WebElement textbox = driver.findElement(By.xpath("//html/body"));
		textbox.sendKeys("salesforce automation");
		Thread.sleep(2000);
		driver.switchTo().parentFrame();
		WebElement shrbtn = driver.findElement(By.xpath("//*[@id=\"publishersharebutton\"]"));
		shrbtn.click();
		Thread.sleep(2000);
		// Click on file link
		WebElement file = driver.findElement(By.xpath("//*[@id=\"publisherAttachContentPost\"]/span[1]"));
		file.click();
		Thread.sleep(2000);
		WebElement uploadFilebtn = driver.findElement(By.id("chatterUploadFileAction"));
		waitForVisibility(uploadFilebtn, 30, "file upload link");
		clickElement(uploadFilebtn, "file upload link");
		Thread.sleep(2000);
		WebElement chooseFilebtn = driver.findElement(By.id("chatterFile"));
		waitForVisibility(chooseFilebtn, 30, "choose file button");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", chooseFilebtn);
		StringSelection stringSelection = new StringSelection("C:\\Users\\gnage\\OneDrive\\Documents\\Day2-qstn.png");
		Thread.sleep(2000);
		Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
		clpbrd.setContents(stringSelection, null);
		AutoScriptsMenubar_log.info("copied to clipboard");
		Thread.sleep(5000);
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		WebElement shrfilebtn = driver.findElement(By.xpath("//*[@id=\"publishersharebutton\"]"));
		shrfilebtn.click();
		Thread.sleep(5000);
		// Click on Add photo link
		WebElement addPhtLink = driver.findElement(By.xpath("//div[@id=\"photoSection\"]/span[1]"));
		addPhtLink.click();
		Thread.sleep(5000);
		// WebElement iframe2 = driver.findElement(By.xpath("/html/body/span/form"));
		WebElement iframe2 = driver.findElement(By.xpath("//*[@id=\"uploadPhotoContentId\"]"));
		driver.switchTo().frame(iframe2);
		AutoScriptsMenubar_log.info("switched to iframe2");
		Thread.sleep(5000);
		WebElement chooseFilebtn1 = driver.findElement(By.xpath("/html/body/span/form/input[2]"));
		waitForVisibility(chooseFilebtn1, 30, "choose file button");
		js.executeScript("arguments[0].click()", chooseFilebtn1);
		Thread.sleep(5000);
		StringSelection stringSelection1 = new StringSelection("C:\\Users\\gnage\\OneDrive\\Documents\\IMG_4121.jpg");
		Clipboard clpbrd1 = Toolkit.getDefaultToolkit().getSystemClipboard();
		clpbrd1.setContents(stringSelection1, null);
		AutoScriptsMenubar_log.info("copied photo to clipboard");
		Thread.sleep(5000);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		WebElement save = driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:save']"));
		save.click();
		Thread.sleep(2000);
		closeBrowser();
	}

	@Test(enabled = false)
	public void menuDropDown_TC07() throws InterruptedException {
		// Select user menu for <username> drop down[TC01]
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
		// Click "My Settings" option from user menu
		driver.findElement(By.id("userNavLabel")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("My Settings")).click();
		Thread.sleep(2000);
		// Click on personal link and select Login History link.
		WebElement persLink = driver.findElement(By.xpath("//*[@id=\"PersonalInfo\"]//a"));
		persLink.click();
		Thread.sleep(2000);

		WebElement logInHist = driver.findElement(By.xpath("//*[@id=\"LoginHistory_font\"]"));
		logInHist.click();
		// Click on Display & Layout link 
		WebElement displayLink = driver.findElement(By.xpath("//*[@id=\"DisplayAndLayout\"]/a"));
		displayLink.click();
		WebElement custTabsLink = driver.findElement(By.xpath("//a[@id=\"CustomizeTabs_font\"]"));
		custTabsLink.click();
		WebElement custApp = driver.findElement(By.id("p4"));
		Select custAppDropdown = new Select(custApp);
		Thread.sleep(2000);
		custAppDropdown.selectByVisibleText("Salesforce Chatter");
		WebElement viewAvail = driver.findElement(By.id("duel_select_0"));
		Select selectAccntsDropdown = new Select(viewAvail);
		Thread.sleep(2000);
		selectAccntsDropdown.selectByVisibleText("Reports");
		Thread.sleep(2000);
		WebElement addBtn = driver.findElement(By.className("rightArrowIcon"));
		addBtn.click();
		Thread.sleep(2000);
		WebElement saveButton = driver.findElement(By.xpath("//input[@value=' Save ']"));
		saveButton.click();
		Thread.sleep(2000);
		// Click on Email link and click on my email settings link under that
		WebElement emailLink = driver.findElement(By.xpath("//div[@id=\"EmailSetup\"]/a"));
		emailLink.click();
		WebElement emailSettLink = driver.findElement(By.id("EmailSettings_font"));
		emailSettLink.click();
		WebElement emailName = driver.findElement(By.xpath("//input[@id=\"sender_name\"]"));
		emailName.clear();
		emailName.sendKeys("Chandu Raj");
		WebElement emailAdd = driver.findElement(By.id("EmailSettings_font"));
		// emailAdd.clear();
		emailAdd.sendKeys("rajanachandu@gmail.com");
		WebElement bccRadioBtn = driver.findElement(By.xpath("//input[@id='auto_bcc1' and @value='1']"));
		if (!bccRadioBtn.isSelected()) {
			bccRadioBtn.click();
			AutoScriptsMenubar_log.info("yes radio button is selected");
		} else {
			AutoScriptsMenubar_log.info("yes radio button is already selected");
		}
		Thread.sleep(2000);
		WebElement cancelButton = driver.findElement(By.xpath("//input[@value='Cancel']"));
		cancelButton.click();
		Thread.sleep(2000);

		// Click on Calendar & Remainders
		WebElement calRemind = driver.findElement(By.xpath("//div[@id=\"CalendarAndReminders\"]/a"));
		calRemind.click();
		Thread.sleep(2000);
		WebElement actRemind = driver.findElement(By.xpath("//span[@id=\"Reminders_font\"]"));
		actRemind.click();
		Thread.sleep(2000);
		WebElement testRemindbtn = driver.findElement(By.xpath("//input[@id=\"testbtn\"]"));
		testRemindbtn.click();
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
				AutoScriptsMenubar_log.info("Title:" + acttitle);
				driver.close();
			}

		}
		Thread.sleep(2000);
		driver.switchTo().window(MainWindow);

		closeBrowser();
	}

	@Test
	public void menuDropDown_TC08() throws InterruptedException {
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

		WebElement usermenu = driver.findElement(By.id("userNavLabel"));
		usermenu.click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Developer Console")).click();
		Thread.sleep(5000);

		String MainWindow = driver.getWindowHandle();

		// To handle all new opened window.
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {
			String ChildWindow = i1.next();

			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
				// Switching to Child window
				driver.switchTo().window(ChildWindow);
				driver.close();
			}

		}

		driver.switchTo().window(MainWindow);
		closeBrowser();
	}

	@Test
	public void menuDropDown_TC09() throws InterruptedException {
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

		driver.findElement(By.xpath("//*[@id=\"userNavLabel\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(2000);
		closeBrowser();
	}

	public static void main(String[] args) throws InterruptedException, AWTException {
		AutomationScripts_Menubar ob = new AutomationScripts_Menubar();
		//ob.menuDropDown_TC05();
		ob.menuDropDown_TC06();
		//ob.menuDropDown_TC07();
		//ob.menuDropDown_TC08();
		//ob.menuDropDown_TC09();

	}

}
