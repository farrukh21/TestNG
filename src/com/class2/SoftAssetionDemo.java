package com.class2;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;
import com.utils.Constant;

public class SoftAssetionDemo extends CommonMethods {
	@BeforeMethod
	public void open() {
		setUp("chrome", Constant.HRMS_URL);
		
	}
	@Test
	public void logoAndLogin() {
		boolean logoDisplayed=driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();
		logoDisplayed=false;
		//Hard assert will fail and execution will stop at that point
		//Assert.assertTrue(logoDisplayed, "Logo is not displayed");
	    
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertTrue(logoDisplayed, "LOGO is not required");
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
	    driver.findElement(By.name("txtPassword")).sendKeys("Hum@nhrm123");
	    driver.findElement(By.name("Submit")).click();
	    
	    boolean welcomeDisplayed=driver.findElement(By.id("welcome")).isDisplayed();
	    Assert.assertTrue(welcomeDisplayed);
	
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
