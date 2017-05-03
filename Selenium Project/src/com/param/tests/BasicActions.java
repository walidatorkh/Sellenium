package com.param.tests;

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
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

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
		
		driver.close();
	}

	@Test
	public void test() throws InterruptedException {
		
		// driver.get("http://www.google.co.il/");
		
		try{
			Assert.assertEquals("888", "999");
		}
		catch(AssertionError e){
			System.out.println("fff");
			
		}
		
		//WebElement search = driver.findElement(By.id("lst-ib"));
		//driver.manage().window().maximize();
		//WebElement search = driver.findElement(By.cssSelector("#uh-search-box"));
		//Thread.sleep(60000);
		//search.sendKeys("mail");
		
		//WebElement searchButton = driver.findElement(By.id("uh-search-button"));
		//searchButton.click();
		

		
		
		
		//driver.navigate().to("http://www.yahoo.com/");
		
		//driver.navigate().back();
		//driver.navigate().forward();
		
		//String sTitle = driver.getTitle();
		//String sUrl = driver.getCurrentUrl();
		
		//String sHandle = driver.getWindowHandle();
		//driver.switchTo().window(sHandle);
		//driver.switchTo().frame(0);
		
		//WebElement element = driver.findElement(By.cssSelector("#lst-ib"));
		//WebElement element1;
		//element1 = driver.findElement(By.cssSelector("#lst-ib"));
		
		//element.clear();
		//element.click();
		//element.sendKeys("abc");
		
		//String sId = element.getAttribute("ID");
		//String sValue = element.getAttribute("value");
		//String sText = element.getText();
		//String iWidth = element.getCssValue("width");
		//boolean bDisplayed = element.isDisplayed();
		//boolean bEnabled = element.isEnabled();
		
		
	}

}
