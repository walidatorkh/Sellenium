package com.param.solutions;

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
import org.openqa.selenium.support.ui.Select;

import com.param.utils.ObjectsActions;

public class MultipleObjects {

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
	public void test() {
		WebElement table = driver.findElement(By.tagName("table"));
		
		ObjectsActions tableActions = new ObjectsActions();		
		
		// Non static
		boolean rc = tableActions.verifryTableCellText(table, 2, "John", 3, "Doe");
		
		// Static
		// boolean rc = ObjectsActions.verifryTableCellText(table, 2, "John", 3, "Doe");
		System.out.println(rc);
		
		int iNumOfVisible = 0;
		int iNumWithNoText = 0;
		
		driver.get("https://www.yahoo.com/");
		driver.manage().window().maximize();
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		int iNumOfLinks = allLinks.size();
		for(int i = 0; i < iNumOfLinks; i++)
		{
			if(allLinks.get(i).isDisplayed() == false)
			{
				iNumOfVisible++;
			}
			if(allLinks.get(i).getText().trim().equals("") == true)
			{
				iNumWithNoText++;
			}
		}
		System.out.println(iNumOfVisible);
		System.out.println(iNumWithNoText);
		
		Select carSelect = new Select(driver.findElement(By.xpath("sewlect")));
		carSelect.selectByValue("opel");
		carSelect.selectByVisibleText("Opel");
		carSelect.selectByIndex(0);
	}

}
