package com.class1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test2 {
	/*
	 * Task 1: Executing different test based TestNG annotations

Create class that will have:
Before and After Class annotation
Before and After Method annotation
2 methods with Test annotation

	 */

	@BeforeClass
	public void before() {
		System.out.println("Before class annotation");
	}
	@AfterClass
	public void after() {
		System.out.println("after class annotation");
    }
	@BeforeMethod
	public void beforemethod() {
		System.out.println("Before method  annotation");	
   }
	@AfterMethod
	public void aftermethod() {
		System.out.println("After  method annotation");
}
	@Test
	public void test1() {
		System.out.println("This is test 1");
	}
	@Test
	public void test2() {
		System.out.println("This is test 2");
	}
}