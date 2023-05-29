package com.site.local;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Carlsbery_WebTable {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\sathi\\eclipse-workspace\\Selenium_Work\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.carlsberggroup.com/");

		driver.manage().window().maximize();

		Actions as = new Actions(driver);

		Thread.sleep(3000);

		WebElement allow = driver.findElement(By.xpath("//button[@id='cbg_ccp_cookie_allow_all_btn']"));
		allow.click();

		WebElement year1 = driver.findElement(By.xpath("//input[@name='cb_age_year_1']"));
		year1.sendKeys("1");

		WebElement year2 = driver.findElement(By.xpath("//input[@name='cb_age_year_2']"));
		year2.sendKeys("9");

		WebElement year3 = driver.findElement(By.xpath("//input[@name='cb_age_year_3']"));
		year3.sendKeys("9");

		WebElement year4 = driver.findElement(By.xpath("//input[@name='cb_age_year_4']"));
		year4.sendKeys("5");

		WebElement ent = driver.findElement(By.xpath("//button[@id='cbgAge-submit']"));
		ent.click();

		WebElement investor = driver.findElement(By.xpath("//ul[@id='nav']/descendant::a[@id='id_investor-relations']"));
		as.moveToElement(investor).build().perform();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


		WebElement calculator = driver.findElement(By.xpath("//div[@class='subnav']/following::a[text()='Investment Calculator']"));
		calculator.click();

		WebElement fra = driver.findElement(By.xpath("//div[@class='module module--raw-html']/child::iframe[@id='euroland_frame_id']"));
		driver.switchTo().frame(fra);

		WebElement dividened = driver.findElement(By.xpath("//div[@class='EurolandTools-TotalReturnAndDividends-TabSelection-Tabs']/child::a[text()='Dividend Calculator']"));
		dividened.click();

		WebElement startdate = driver.findElement(By.xpath("//div[@class='EurolandTools-CommonObjects-Calendar-Selection']/descendant::span[text()='14/04/2018']"));
		startdate.click();

		//driver.switchTo().defaultContent();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,);");

		WebElement data = driver.findElement(By.xpath("(//table[@class='EurolandTools-CommonObjects-Calendar-Month-Table'])[6]/tr[5]/td[1]/label/button[text()='April 14 2018, monday']"));
		data.click();



		/*WebElement insidedate = driver.findElement(By.xpath("//div[@id='EurolandTools-CommonObjects-Calendar-1-CalendarPanelID']/descendant::

		WebElement row2 = row1.get(4);

		List<WebElement> column1 = row2.findElements(By.tagName("td"));

		WebElement column2 = column1.get(2);

		List <WebElement> labe1= column2.findElements(By.tagName("label"));

		WebElement labe2 = labe1.get(0);

		WebElement date = labe2.findElement(By.tagName("span"));

		date.click();*/







	}

}
