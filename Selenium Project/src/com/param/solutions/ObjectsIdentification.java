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

public class ObjectsIdentification {
	
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
		Thread.sleep(10000);
		driver.manage().window().maximize();
		
		// IMG - title, alt, no
		WebElement logo = driver.findElement(By.xpath("//img[@title='777 Online Casino']"));
		logo = driver.findElement(By.cssSelector("img[title='777 Online Casino']"));
		
		//logo = driver.findElement(By.cssSelector("a:contains('Live Casino')"));
		logo = driver.findElement(By.cssSelector("a[href='/live-casino/']"));
		
		driver.get("http://www.888casino.com");
		Thread.sleep(10000);
		WebElement login = driver.findElement(By.xpath("//a[text()='Login']"));
		login = driver.findElement(By.cssSelector("a.TabbedMenuTitleLink"));
		login = driver.findElement(By.className("TabbedMenuTitleLink"));
		login = driver.findElement(By.xpath("//div[@id='loginTab']/span[@class='TabbedMenuItem']/a"));
		login = driver.findElement(By.cssSelector("div#loginTab span.TabbedMenuItem a"));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	//@Test
	//public void test1() {
		
	//	try{
			// Your code goes here
	//	}
	//	catch(Exception e){
	//		e.printStackTrace();
	//	}
	//}

}
