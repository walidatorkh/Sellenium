package com.param.solutions;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EclipseAndJUnitIntroduction {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("5");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("2");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("4");
	}

	@Test
	public void test() {
		System.out.println("3");
	}

}
