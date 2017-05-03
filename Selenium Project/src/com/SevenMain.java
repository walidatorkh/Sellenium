package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.nice.pages.SevenBonusPolicy;

private WebDriver driver;

public class SevenMain(
WebDriver driver
{
		this.driver = driver;
		if(!driver.getTitle().contains("777 Casino")){
			System.out.println("Wrong Page");

	public navigateToBanking(String item){
		try{
			driver.findElement(By.linkText(item)).click();
			return (new SevenBonusPolicy(driver));
		}
		catch(Exception e){
			return(null);
		}
	}

}
