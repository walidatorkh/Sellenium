package com.param.tests;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.param.pages.MyClass;

public class JavaBasics {
	
	private WebDriver driver;
	private int i, j;
	public String str;
	public Integer k;
	
	
	MyClass m = new MyClass();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		WebElement element; 
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String firstName;
		int i, j;
		boolean isFound;
		WebElement element;
		
		firstName = "David";
		i = 9;
		isFound = false;
		element = driver.findElement(By.id("123"));
		
		WebElement element1 = null;
		WebElement element2 = driver.findElement(By.id("123"));
		int counter = 10;
		String str = "abc";
		
		final String lastName = "Shalev";
				
		Integer a;
		int b, c;
		double age;
		long width;
		
		String middleName = "abc";
		
		String[] s = new String[3];
		List<String> s1 = new ArrayList<String>(3);
		List<WebElement> w = driver.findElements(By.tagName("a"));
		
		
		s[0] = "a";
		System.out.print(s[0]);
				
		s1.add(0, "abc");
		s1.set(0,  "abc");
		System.out.print(s1.get(0));
		
		for(i = 0; i < s.length; i++){
			System.out.print(s[i]);
		}
		
		for(i = 0; i < s1.size(); i++){
			System.out.print(s1.get(i));
		}
		
		if(i == counter)
		{
			// Do something
		}
		else if(i < counter || i > 9 && counter != 20)
		{
			// Do something else
		}
		else
		{
			// Do for the rest
		}
		
		for(i = 1; i<=20; i++)
		{
			// Do something. How many times?
		}
		
		while(i < 30)
		{
			// Do something. How many times?
		}
		
		do
		{
			// Do something. How many times?
		}
		while(i < 10);
		
		m.myFunc3();
		
		MyClass.myFunc2(element2);
		
		boolean rc = MyClass.myFunc2(element2);
	}

}
