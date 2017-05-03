package com.param.pages;

import org.openqa.selenium.WebElement;

public class MyClass {
	
	// Constructor
	public MyClass() {
		
	}
	
	// Function 1
	public static void myFunc(String str){
		System.out.println(str);
	}
	
	// Function 2
	public static boolean myFunc2(WebElement element){
		try
		{
			element.click();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	// Function 3
	public String myFunc3(){
		return("abc");
	}
}

