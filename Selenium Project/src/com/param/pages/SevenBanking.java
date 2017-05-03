package com.param.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SevenBanking {

	private WebDriver driver;
					
	public SevenBanking(WebDriver driver) {
		this.driver = driver;
		if(!driver.getTitle().contains("777 Casino")){
			System.out.println("Wrong Page");
		}
	}
		
	public SevenBonusPolicy navigateLeftMenu(String item){
		try{
			driver.findElement(By.linkText(item)).click();
			return (new SevenBonusPolicy(driver));
		}
		catch(Exception e){
			return(null);
		}
	}
}



