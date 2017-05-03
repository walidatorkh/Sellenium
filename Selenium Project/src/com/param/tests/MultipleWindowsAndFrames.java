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

import java.util.Iterator;
import java.util.Set;


public class MultipleWindowsAndFrames {
	
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
	}

	@Test
	public void test() {
		// Get all windows handles
		Set<String> windowsIds = driver.getWindowHandles();
		// Get number of windows
		int numOfWindows = windowsIds.size();
		Iterator<String> iter = windowsIds.iterator();
		// Get main window handle
		String goToWindowId = iter.next();
		// Move to new window
		goToWindowId = iter.next();
		driver.switchTo().window(goToWindowId);
		
		driver.switchTo().frame(1);
		
		driver.switchTo().frame("frameName");
		
		WebElement frameElement = driver.findElement(By.cssSelector("frameLocator"));
		driver.switchTo().frame(frameElement);
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().parentFrame();
	}

}
