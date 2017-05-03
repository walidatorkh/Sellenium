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

import java.util.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Synchronization {
	
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
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		try{
			
			Thread.sleep(5000);
			Thread.sleep(5000, 100);
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='mfp-close']")));
			
			WebElement welcomePopup = driver.findElement(By.xpath("//button[@class='mfp-close']"));
			wait.until(ExpectedConditions.visibilityOf(welcomePopup));
			
			welcomePopup.click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@class='mfp-close']")));
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='mfp-close']")));
			wait.until(ExpectedConditions.elementToBeClickable(welcomePopup));
			
			wait.until(ExpectedConditions.textToBePresentInElement(welcomePopup, "abc"));
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//button[@class='mfp-close']"), "abc"));
			wait.until(ExpectedConditions.textToBePresentInElementValue(welcomePopup, "abc"));
			wait.until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//button[@class='mfp-close']"), "abc"));
			
			wait.until(ExpectedConditions.elementSelectionStateToBe(By.xpath("//button[@class='mfp-close']"), true));
			wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//button[@class='mfp-close']")));
			
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("statedropdown")));
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("statedropdown"), "abc"));
			
			wait.until(ExpectedConditions.titleContains("Poker"));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
			wait.until(ExpectedConditions.alertIsPresent());
			
			Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
					.withTimeout(10, TimeUnit.SECONDS)
					.pollingEvery(5,  TimeUnit.SECONDS)
					.ignoring(NoSuchElementException.class);
			wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("statedropdown")));
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='mfp-close']")));
			
			welcomePopup = driver.findElement(By.xpath("//button[@class='mfp-close']"));
			wait.until(ExpectedConditions.visibilityOf(welcomePopup));
			
					
			
		}
		catch(Exception e){
		}
		
	}

}
