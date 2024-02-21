package com.tekarch.Day3;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q2 {
	public static int count = 0;

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.letskodeit.com/practice");
		Thread.sleep(2000);
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		System.out.println("No. of links are:"+links.size());
		
		List<String> urlList = new ArrayList<String>();
		
		for(WebElement temp:links) {
			String url = temp.getAttribute("href");
			urlList.add(url);
			checkBrokenLink(url);
		}
		
		System.out.println("No. of links from finding href are:"+urlList.size());
		System.out.println("No. of broken links are:"+count);
		driver.quit();
	}
	
	public static void checkBrokenLink(String urlLink) {
		try {
			URL url = new URL(urlLink);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setConnectTimeout(2000);
			httpURLConnection.connect();
			
			if(httpURLConnection.getResponseCode()>=400) {
				System.out.println(urlLink+"--->"+httpURLConnection.getResponseMessage()+" Is a broken link");
				count++;
			}
			else {
				System.out.println(urlLink+"--->"+httpURLConnection.getResponseMessage());
			}
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

}
