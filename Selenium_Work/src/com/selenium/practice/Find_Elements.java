package com.selenium.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Find_Elements {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\sathi\\git\\repository\\Selenium_Work\\Driver\\chromedriver.exe");
		DesiredCapabilities dc = new DesiredCapabilities();
		ChromeOptions co = new ChromeOptions();
		co.merge(dc);
		co.addArguments("--start-maximized");
//		co.addArguments("headless");
//		co.addArguments("incognito");
		co.addArguments("disable-infobars");
		dc.acceptInsecureCerts();
		WebDriver driver = new ChromeDriver(co);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://adactinhotelapp.com/");

//		driver.manage().window().maximize();
		
		WebElement user = driver.findElement(By.id("username"));
		user.sendKeys("mkkarthi");
		
		WebElement pwd = driver.findElement(By.id("password"));
		//pwd.sendKeys("Walte@28");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='Walte@28'", pwd);
		
		
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		
		WebElement location = driver.findElement(By.id("location"));
		List<WebElement> all = location.findElements(By.tagName("option"));
		for(int i =1; i<all.size(); i++) {
			System.out.println(all.get(i).getText());
		}
		
		
	}
	

}
