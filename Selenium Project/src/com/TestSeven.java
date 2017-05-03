package com;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class TestSeven {


	
	public static class BasicActions {
		
	private static WebDriver driver;
		
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\jbt\\Selenium\\git\\Selenium Project\\Exe\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}

		@AfterClass
		public static void tearDownAfterClass() throws Exception {
			driver.quit();
		}

		
		@Test
		public void testSevenBonusPolicy() {
			try{
				
				driver.get("https://www.777.com");
				Thread.sleep(1000);
				String url = driver.getCurrentUrl();
				System.out.println(url);
						
				
				//driver.SevenBonus("==");

				System.out.println("==");
				
				}
				catch(Exception e){
					e.printStackTrace();
				}
		}

	}

}
