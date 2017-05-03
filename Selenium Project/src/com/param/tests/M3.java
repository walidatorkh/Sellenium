package com.param.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.param.pages.Login;
import com.param.pages.OffendersList;

public class M3 {
	
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
			
			driver.get("https://10.10.8.196:7010/Login.aspx");
		
			// Login page
			Login login = new Login(driver);
			OffendersList offenders = login.loginApp("emsprc", "Q1w2e3r4");
		
			// Offenders page
			offenders.search("12");
			offenders.verifyResults();
		
			Thread.sleep(5000);
			}
		 catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

}
