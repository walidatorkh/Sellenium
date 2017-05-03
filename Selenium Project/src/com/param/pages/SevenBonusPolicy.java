package com.param.pages;

import org.openqa.selenium.WebDriver;

public class SevenBonusPolicy {

	private WebDriver driver;
	
	public SevenBonusPolicy(WebDriver driver) {
		this.setDriver(driver);
		if(!driver.getTitle().contains("Policy")){
			System.out.println("Wrong Page");
		}
	}
	
	public void dummy(){
		
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}
