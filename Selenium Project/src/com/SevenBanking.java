package com;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class SevenBanking {
	private WebDriver driver;
	
	By searchTextField = By("uh-search-box");
	By searchButon = By.id("uh-search-button");
	
	public void NavigateToBanking(WebDriver driver) {
		this.driver = driver;
	}

	

	public void SevenBonusPolicy(WebDriver driver) {
		
		driver.findElement(By.id("kk"));
//			this.setDriver(driver);
//			if(!driver.getTitle().contains("Policy")){
		}

	//return SevenBanking;
   
}
