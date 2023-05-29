package com.selenium.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamic_Xpath {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\sathi\\git\\repository\\Selenium_Work\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://adactinhotelapp.com/");//

		driver.manage().window().maximize();
		
		WebElement user = driver.findElement(By.xpath("//*[@id='login_form']/descendant::input[@id=\"username\"]"));
		user.sendKeys("mkkarthi");
		
		WebElement pwd = driver.findElement(By.xpath("//*[@id='login_form']/descendant::input[@id='username']/ancestor::tr/following::tr/descendant::input[@id='password']"));
		.sendKeys("mkkarthi");
	}

}
