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
import org.testng.Assert;

import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;

public class MultipleElements {
	
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
		driver.quit();
	}

	@Test
	public void test() {
		try{
				
				driver.get("http://www.google.com");
				List<WebElement> allLinks = driver.findElements(By.tagName("a"));
				
				// With no text
				List<WebElement> allLinks1 = driver.findElements(By.xpath("//a[text()='']"));
				
				int size = allLinks1.size();
				for(int i = 0; i < size; i++){
					if(allLinks1.get(i).getText().trim().equals(""))
						System.out.println("NO TEXT");
				}
				
				System.out.println(allLinks.size());
				System.out.println(allLinks1.size());
				
				/*
				
				String firstLink = allLinks.get(0).getText();
				
				int numOfLinks = allLinks.size();
				
				System.out.println(firstLink);
				System.out.println(numOfLinks);
				
				for(int i = 0; i <= numOfLinks; i++){
					System.out.println(allLinks.get(i).getText());
				}
				
				WebElement table = driver.findElement(By.id("myTable"));
				List<WebElement> allRows = table.findElements(By.tagName("tr"));
				int rowsNum = allRows.size();
								
				for(int i = 0; i < rowsNum; i++){
					List<WebElement> allCells = allRows.get(i).findElements(By.tagName("td"));
					int cellsNum = allCells.size();
					for(int j = 0; j < cellsNum; j++){
						System.out.println(allCells.get(j).getText());
					}
				}
				
				Select carSelect = new Select(driver.findElement(By.xpath("//select")));
				
				carSelect.selectByValue("opel");
				carSelect.selectByVisibleText("Opel");
				carSelect.selectByIndex(0);
				*/
						
			
		}
		catch(Exception e){
		}
		
		catch(AssertionError e){
			e.printStackTrace();
		}
		
	}

}
