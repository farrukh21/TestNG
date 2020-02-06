package com.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import com.utils.CommonMethods;
import com.utils.Constant;

import bsh.org.objectweb.asm.Constants;

public class HW extends CommonMethods {

		@BeforeMethod
		public void open() {
			setUp("chrome", Constant.HRMS_URL);
		}

		@AfterMethod
		public void close() {
			driver.close();
		}

		@Test(priority=2, dependsOnMethods= {"validationOfMessage"}, enabled=false)
		public void validationOfLogo() {
			driver.findElement(By.id("txtUsername")).sendKeys("Admin");
			driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
			driver.findElement(By.id("btnLogin")).click();
			boolean isTrue = driver.findElement(By.xpath("//img[contains(@src,'syntax.png')]")).isDisplayed();
			if (isTrue) {
				System.out.println("Logo is dislayed");
			} else {
				System.out.println("Logo is NOT displayed");
			}
		}

		@Test(priority=1)
		public void validationOfMessage() {
			driver.findElement(By.id("txtUsername")).sendKeys("Admin");
			driver.findElement(By.id("btnLogin")).click();
			WebElement error = driver.findElement(By.id("spanMessage"));
			String expectedError="Password cannot be empty";
			if (error.isDisplayed()) {
				System.out.println("error is dislayed");
				if(error.getText().equals(expectedError)) {
					System.out.println("Erorr msg is correct. Test Pass");
				}else {
					System.out.println("Erorr msg is not correct. Test Fail");
				}
			} else {
				System.out.println("error is NOT displayed. Test Fail");
			}
		}
	}


