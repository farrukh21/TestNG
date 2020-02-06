package com.class1;

import org.testng.annotations.*;

public class DifferentAnnotations {

	@BeforeSuite
	public void beforeSuit() {
		System.out.println("Before Suite");
	}
	
	@AfterSuite
	public void afterSuit() {
		System.out.println("After Suite");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}
	
	@Test
	public void test() {
		System.out.println("I am actual Test");
	}
}
