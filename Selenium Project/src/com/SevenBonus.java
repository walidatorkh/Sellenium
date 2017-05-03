package com;

import org.openqa.selenium.WebDriver;

public class SevenBonus {

	private WebDriver driver;
	
	public SevenBonus(WebDriver driver) {
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
