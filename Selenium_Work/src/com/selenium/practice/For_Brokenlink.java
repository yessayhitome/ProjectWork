package com.selenium.practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class For_Brokenlink {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\sathi\\git\\ProjectWork\\Selenium_Work\\Driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.helvetic.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		List<WebElement> alllinks = driver.findElements(By.tagName("a"));
		
		for (WebElement a : alllinks) {
			
			String url = a.getAttribute("href");
			
			System.out.println(url);
			
			URL link = new URL(url);
			
			HttpURLConnection huc = (HttpURLConnection) link.openConnection();
			
			Thread.sleep(2000);
			
			huc.connect();
			
			int responseCode = huc.getResponseCode();
			
			if (responseCode>=200) {
				
				System.out.println("link is valid");
				
			}
			
			else {
				System.out.println("Link is not valid");
			}
		}
		
		
	}

}
