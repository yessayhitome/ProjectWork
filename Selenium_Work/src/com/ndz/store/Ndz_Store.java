package com.ndz.store;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ndz_Store {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\sathi\\eclipse-workspace\\Selenium_Work\\Driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://ecomdemo.ndz.co.in:4007/");
		
		driver.manage().window().maximize();
		
		
		
	}
	
	
	
	
	

}
