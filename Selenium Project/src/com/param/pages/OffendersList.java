package com.param.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffendersList {
	
	private WebDriver driver;
	
	// Declare objects description
	private By searchField = By.id("searchInput");
	private By searchButton = By.id("searchBtn");
	
	public OffendersList(WebDriver driver) {
		this.driver = driver;
		if(!driver.getTitle().contains("Offender")){
			System.out.println("Wrong Page");
		}
	}
	
	public void search(String text){
		
		driver.findElement(searchField).sendKeys(text);
		driver.findElement(searchButton).click();
	}
	
	public boolean verifyResults(){
		return true;
	}
	

}
