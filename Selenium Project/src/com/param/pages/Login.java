package com.param.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	
	private WebDriver driver;
	
	// Declare objects description
	private By userName = By.id("Login1_UserName");
	private By password = By.id("Login1_Password");
	private By loginButton = By.id("Login1_LoginButton");
	
	public Login(WebDriver driver) {
		this.driver = driver;
		if(!driver.getTitle().contains("Offender")){
			System.out.println("Wrong Page");
		}
	}
	
	public OffendersList loginApp(String user, String pwd){
		driver.findElement(userName).sendKeys(user);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginButton).click();
		
		return new OffendersList(driver);
	}
	

}
