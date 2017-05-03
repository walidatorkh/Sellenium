package com.param.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Locators {
	
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
		driver.quit();
		
	}

	@Test
	public void test() {
		WebElement logo = driver.findElement(By.id("pc-logo"));
		logo = driver.findElement(By.className("logo"));
		logo.click();
		
		WebElement linkInstall = driver.findElement(By.linkText("How to Install"));
		linkInstall = driver.findElement(By.partialLinkText("Install"));
		linkInstall.click();
		
		WebElement elementByXpath = driver.findElement(By.xpath("//div/a/span"));
		elementByXpath = driver.findElement(By.xpath("//div/a[1]/span"));
		elementByXpath = driver.findElement(By.xpath("//div/a[@class='inline-block']/span"));
		elementByXpath = driver.findElement(By.xpath("//div[@id='logo-menu-container']/a[@class='inline-block']/span"));
		String text = elementByXpath.getText();
		
		WebElement elementByCss = driver.findElement(By.cssSelector(".inline-block"));
		elementByCss = driver.findElement(By.cssSelector("#logo-menu-container"));
		elementByCss = driver.findElement(By.cssSelector("div > a[class=inline-block]"));
		elementByCss = driver.findElement(By.cssSelector("div a[class=inline-block]"));
		elementByCss.click();
		
		WebElement elementByTagName = driver.findElement(By.tagName("a"));
		List<WebElement> elementsByTagName = driver.findElements(By.tagName("a"));
		
		WebElement elementByClassName = driver.findElement(By.className("inline-block"));
		List<WebElement> elementsByClassName = driver.findElements(By.className("inline-block"));
		
		WebElement element = driver.findElement(By.cssSelector("#lst-ib"));
		element.sendKeys("abc");
		
		WebElement element1;
		element1 = driver.findElement(By.cssSelector("#lst-ib"));
		element1.sendKeys("abc");
		
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		if(elements.size() > 0)
		{
			elements.get(0).click();
		}
		
	}

}
