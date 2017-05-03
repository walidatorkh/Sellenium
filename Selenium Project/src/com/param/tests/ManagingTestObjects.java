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

import java.io.InputStream;
import java.io.FileInputStream;
import java.util.Properties;

import java.io.FileOutputStream;

import java.util.concurrent.TimeUnit;

import java.io.File;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.param.pages.SevenBanking;
import com.param.pages.SevenBonusPolicy;
import com.param.pages.SevenMain;

import javax.xml.xpath.XPathConstants;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ManagingTestObjects {
	
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
	
	private WebElement locateElement1(String elementLogicalName){
		try{
			// Declare and initiate WebElement
			WebElement element = null;
						
			// Connect and load XML file
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			XPath xpath = XPathFactory.newInstance().newXPath();
			File file = new File("OR.xml");
			Document doc = db.parse(file);
			
			// Get page and element description by logical name
			String[] arrElement = elementLogicalName.split(":");
			String pageName = arrElement[0];
			String elementName = arrElement[1];
			
			String pageLocator = "//Page[@Name='" + pageName + "']/PropertyName";
			pageLocator = xpath.compile(pageLocator).evaluate(doc);
			String pageValue = "//Page[@Name='" + pageName + "']/PropertyValue";
			pageValue = xpath.compile(pageValue).evaluate(doc);
			String locator = "//Page[@Name='" + pageName + "']/Object[@Name='" + elementName + "']/PropertyName";
			locator = xpath.compile(locator).evaluate(doc);
			String value = "//Page[@Name='" + pageName + "']/Object[@Name='" + elementName + "']/PropertyValue";
			value = xpath.compile(value).evaluate(doc);
			
			// Find element
			if(locator.equals("id")){
				element = driver.findElement(By.id(value));
			}
			else if(locator.equals("name")){
				element = driver.findElement(By.name(value));
			}
			else if(locator.equals("linkText")){
				element = driver.findElement(By.linkText(value));
			}
			else if(locator.equals("cssSelector")){
				element = driver.findElement(By.cssSelector(value));
			}
			else if(locator.equals("xpath")){
				element = driver.findElement(By.xpath(value));
			}
			
			// Verify page by partial title or URL
			if(pageLocator.equals("title")){
				Assert.assertTrue(driver.getTitle().contains(pageValue));
			}
			else if(pageLocator.equals("url")){
				Assert.assertTrue(driver.getCurrentUrl().contains(pageValue));
			}
			
			return element;
		}
		catch(Exception e){
			return null;
		}
		
	}
	
	private WebElement locateElement(String elementLogicalName){
		try{
			// Declare and initiate WebElement
			WebElement element = null;
			
			// Connect and load properties file
			Properties ElementsProps = new Properties();
			InputStream input = null;
			input = new FileInputStream("elements.properties");
			ElementsProps.load(input);
			
			// Get element description by logical name
			String elementDesc = ElementsProps.getProperty(elementLogicalName);
			
			// Split the description
			String[] arrName = elementDesc.split(":");
			String pageName = arrName[0];
			String locator = arrName[1];
			String value = arrName[2];
			
			// Find element
			if(locator.equals("id")){
				element = driver.findElement(By.id(value));
			}
			else if(locator.equals("name")){
				element = driver.findElement(By.name(value));
			}
			else if(locator.equals("linkText")){
				element = driver.findElement(By.linkText(value));
			}
			else if(locator.equals("cssSelector")){
				element = driver.findElement(By.cssSelector(value));
			}
			else if(locator.equals("xpath")){
				element = driver.findElement(By.xpath(value));
			}
			
			// Verify page by partial title or URL
			String pageDesc = ElementsProps.getProperty(pageName);
			String[] arrPage = pageDesc.split(":");
			String pageLocator = arrPage[0];
			String pageValue = arrPage[1];
			
			if(pageLocator.equals("title")){
				Assert.assertTrue(driver.getTitle().contains(pageValue));
			}
			else if(pageLocator.equals("url")){
				Assert.assertTrue(driver.getCurrentUrl().contains(pageValue));
			}
			
			return element;
		}
		catch(Exception e){
			return null;
		}
		
	}
	
	@Test
	public void test3() {
		try{

			driver.get("https://www.777.com");
			SevenMain sevenMain = new SevenMain(driver);
			
			
			SevenBanking sevenBanking = sevenMain.navigateToBanking();
			SevenBonusPolicy sevenBonusPolicy = sevenBanking.navigateLeftMenu("Deplositing");
			sevenBonusPolicy.dummy();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2() {
		try{

			driver.get("https://www.777.com");
			locateElement1("CasinoMain:PlayNowLink").click();
			
			// Or
			WebElement element = locateElement1("CasinoMain:PlayNowLink");
			if(element != null){
				element.click();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void test1() {
		try{

			driver.get("https://www.777.com");
			locateElement("PlayNowLink").click();
			
			// Or
			WebElement element = locateElement("PlayNowLink");
			if(element != null){
				element.click();
			}
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void test() {
		try{
			
			Properties ElementsProps = new Properties();
			InputStream input = null;
			
			input = new FileInputStream("elements.properties");
			ElementsProps.load(input);
			
			String elementDesc = ElementsProps.getProperty("PlayNowLink");
			
			System.out.println(elementDesc);
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			XPath xpath = XPathFactory.newInstance().newXPath();
			
			File file = new File("OR.xml");
			Document doc = db.parse(file);
			
			String expression = "//Page[@Name='Page 1']/PropertyName";
			String pageLocator = xpath.compile(expression).evaluate(doc);
			
			
		}
		catch(Exception e){
		}
		
		catch(AssertionError e){
			e.printStackTrace();
		}
		
	}

}
