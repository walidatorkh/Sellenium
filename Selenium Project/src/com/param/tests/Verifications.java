package com.param.tests;

//import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

public class Verifications {
	
	private WebDriver driver;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver","C:\\Resources\\Exe\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			
			// driver.get("https://www.888casino.com/");
			driver.get("https://www.888poker.com/");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Close (Esc)']")));
			WebElement xButton = driver.findElement(By.xpath("//button[@title='Close (Esc)']"));
			wait.until(ExpectedConditions.visibilityOf(xButton));
			xButton.click();
			
			WebElement lnkDownload = driver.findElement(By.xpath("//a[contains(., 'Download')]"));
			String href = lnkDownload.getAttribute("href");
			String lnkTagName = lnkDownload.getTagName();
			String lnkText = lnkDownload.getText();
			String lnkColor = lnkDownload.getCssValue("color");
			
			//WebElement searchField = driver.findElement(By.xpath("//input[@id='lst-ib']"));
			//String value = searchField.getAttribute("value");
			
			System.out.println(href);
			System.out.println(lnkTagName);
			System.out.println(lnkText);
			//System.out.println(value);
			
			String sTitle = driver.getTitle();
						
			if(sTitle.equals("888")){
				System.out.println("GOOD");
			}
			else{
				System.out.println("BAD");
			}
			
			if(sTitle.contains("888")){
				System.out.println("GOOD");
			}
			else{
				System.out.println("BAD");
			}
			
			
			WebElement lnkDownload1 = driver.findElement(By.linkText("Download"));
			
			Assert.assertTrue(lnkDownload1.isEnabled());
			Assert.assertEquals("Verifying Page Title", "888", sTitle);
			Assert.assertEquals("888", sTitle);
			Assert.assertNotEquals("888", sTitle);
			Assert.assertTrue(sTitle.contains("888"));
			
			
					
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		catch(AssertionError e){
			System.out.println(e.getMessage());
		}
		
	}

}
