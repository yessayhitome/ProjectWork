package com.daily.goal;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Stale_ExceptionEx {
	
public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver", 
			"C:\\Users\\sathi\\eclipse-workspace\\Selenium_Work\\Driver\\chromedriver.exe");
	
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://www.facebook.com/");
	
	driver.manage().window().maximize();
	
	WebElement username = driver.findElement(By.xpath("//div[@id='content']/descendant::input[@id='email']"));
	username.sendKeys("sadthsu23@gmail.com");
	
	driver.navigate().refresh();
		
	try {
		username.sendKeys("sadthsu@gmail.com");
	} 
	
	catch (StaleElementReferenceException e) {
		
	    username = driver.findElement(By.xpath("//div[@id='content']/descendant::input[@id='email']"));
		username.sendKeys("gmail@gmail.com");
		System.out.println("StaleElementReferenceException ");
	}
	
	/*driver.get("https://www.leafground.com/button.xhtml");
	
	driver.manage().window().maximize();
	
	WebElement cli = driver.findElement(By.xpath("//div[@class='card']/descendant::span[text()='Click']"));
	cli.click();
	
	driver.navigate().back();
			
	try {
		
		cli.click();
		
	} 
	
	catch (StaleElementReferenceException e) {
		
		 cli = driver.findElement(By.xpath("//div[@class='card']/descendant::span[text()='Click']"));
		cli.click();
	}*/
	
	
	
}

}
