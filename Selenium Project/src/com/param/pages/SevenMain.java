package com.param.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SevenMain {
	
	private WebDriver driver;
	
	// Declare objects description
	private By bankingLink = By.linkText("BANKING");
		
	public SevenMain(WebDriver driver) {
		this.driver = driver;
		if(!driver.getTitle().contains("777 Casino")){
			System.out.println("Wrong Page");
		}
	}
	
	public SevenBanking navigateToBanking(){
		try{
			driver.findElement(bankingLink).click();
			return (new SevenBanking(driver));
		}
		catch(Exception e){
			return(null);
		}
	}
}

