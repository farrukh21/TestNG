package com.utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener extends CommonMethods implements ITestListener{
	
	  public void onTestStart(ITestResult result) {
	   System.out.println("Test started");	    
    }
	  public void onTestSuccess(ITestResult result) {
		    System.out.println("Test passed");
		    CommonMethods.takeScrenshot("passed/"+result.getName());
		  }
	  public void onTestFailure(ITestResult result) {
		    System.out.println("Test failed");
		    CommonMethods.takeScrenshot("failed/"+result.getName());
		  }
	  
}
