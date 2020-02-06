package com.class2;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;

public class TC1 extends CommonMethods {

	/*
	 * Open chrome browser Go to
	 * “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login” Login
	 * into the application Click on Add Employee Verify labels: Full Name, Employee
	 * Id, Photograph are displayed 
	 * Provide Employee First and Last Name Verify
	 * Employee has been added successfully Close the browser
	 * 
	 * 
	 * 
	 */
	@BeforeMethod
	public void beforeMethod() {
		setUp("chrome", "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");

	}

	@Test
	public void login() {
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.name("Submit")).click();
		Actions act=new Actions(driver);
		driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']/b")).click();;
		driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']")).click();
		//act.doubleClick(pim).perform();
		//act.doubleClick(add).perform();
		boolean name=driver.findElement(By.xpath("//label[text()='Full Name']")).isDisplayed();
		boolean id=driver.findElement(By.xpath("//label[text()='Employee Id']")).isDisplayed();
		
		SoftAssert softassert=new SoftAssert();
		softassert.assertTrue(name, "First name is missing");
		softassert.assertTrue(id, "Id text is missing");
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Billy");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Kimber");
		driver.findElement(By.xpath("//input[@id='photofile']")).sendKeys("C:\\Users\\Farrukh\\Downloads\\billy.jpg");
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		//driver.quit();
		
	}
}
