package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class yahoo {


public class NewYahooSearch {
		
		private WebDriver driver;
		
		By searchTextField = By.id("uh-search-box");
		By searchButon = By.id("uh-search-button");
		
		public NewYahooSearch(WebDriver driver) {
			this.driver = driver;
		}
		
		
	public NewYahooResults doSearch(String textToSearch){
			
			try {
				
				WebElement textField = driver.findElement(searchTextField);
				WebElement searchButton = driver.findElement(searchButon);
				
				
				textField.clear();
				textField.sendKeys(textToSearch);
				
				searchButton.click();
							
				return new NewYahooResults(driver);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				return null;
			}
		}
		

	}
}
