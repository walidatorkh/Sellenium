package com.param.solutions;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicActions {
	
private WebDriver driver;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	@Test
	public void test() {
		try{
			
			driver.get("https://www.777.com");
			Thread.sleep(5000);
			String url = driver.getCurrentUrl();
			System.out.println(url);
					
			
			//driver.get("http://www.888casino.com");
					
			//WebElement elementByCss = driver.findElement(By.cssSelector(".inline-block"));
			//WebElement elementByCss1 = driver.findElement(By.cssSelector("#logo-menu-container"));
			
			WebElement banking = driver.findElement(By.xpath("//a[text()='Banking']"));
			banking.click();
			Thread.sleep(5000);
			WebElement policy = driver.findElement(By.id("LeftMenuBouns"));
			policy.click();
			Thread.sleep(5000);
			
			WebElement bullet = driver.findElement(By.xpath("//div[@class='mainImage small-12 column']//li[2]"));
			bullet = driver.findElement(By.cssSelector("div[class='mainImage small-12 column'] li:nth-child(2)"));
			bullet = driver.findElement(By.cssSelector("div.mainImage.small-12.column li:nth-child(2)"));
			bullet = driver.findElement(By.cssSelector("div.mainImage li:nth-child(2)"));
			System.out.println(bullet.getText());
			
			
			
			//String pageTitle = driver.getTitle();
			//System.out.println(pageTitle);
			
			}
			catch(Exception e){
				e.printStackTrace();
			}
	}

}
