package com.selenium.practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Broken_Link {
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\sathi\\eclipse-workspace\\Selenium_Work\\Driver\\chromedriver.exe");
		
		String homePage = "http://www.zlti.com";
		
		String url ="";
		
		HttpURLConnection huc = null;
		
		int respcode = 200;
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(homePage);
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		Iterator<WebElement> it = links.iterator();
		
		while (it.hasNext()) {
			
			url = it.next().getAttribute("href");
			
			System.out.println(url);
			
			if (url==null||url.isEmpty()) {
				
				System.out.println("Url is either not configured for anchor tag or it is empty");
				continue;
				
			}
			
			if (!url.startsWith(homePage)) {
				
				System.out.println("Url belongs to another domain, skipping it.");
				continue;
				
			}
			
			try {
				
				huc = (HttpURLConnection)(new URL(url).openConnection());
				
				huc.setRequestMethod("Head");
				
				huc.connect();
				
				respcode = huc.getResponseCode();
				
				if (respcode>=400) {
					
					System.out.println(url+"is a broken link");
				}
				
				else {
					
					System.out.println(url+"is a valid link");
				}
			} 
			
			catch (MalformedURLException e) {
				
				e.printStackTrace();
			}
			
			catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
		
		driver.quit();
		
	}

}
