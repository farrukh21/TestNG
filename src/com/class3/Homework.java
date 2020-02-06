package com.class3;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
/*
 * Open chrome browser
Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
Login into the application
Add 5 different Employees and create login credentials by providing: 
First Name
Last Name
Username
Password
Provide Employee First and Last Name
Verify Employee has been added successfully and take screenshot (you must have 5 different screenshots)
Close the browser
Specify group for this test case, add it into specific suite and execute from xml file.
 */
public class Homework extends CommonMethods {
	

	@BeforeMethod(alwaysRun=true)
	public void beforeMethod() {
		setUp("chrome", "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");

		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();	
		driver.findElement(By.xpath("//b[text()='PIM']")).click();
		driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']")).click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
	}
	
	@Test(dataProvider="getData", groups="regression")
	
	public void test(String name, String surname, String username, String password, String repassword) throws InterruptedException{
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(surname);
		driver.findElement(By.xpath("//input[@id='chkLogin']")).click();
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='user_name']")));
		
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='re_password']")).sendKeys(repassword);
		WebElement st=driver.findElement(By.xpath("//select[@id='status']"));
		Select select=new Select(st);
		select.selectByIndex(1);
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//Thread.sleep(2000);
		
//		TakesScreenshot ts=(TakesScreenshot)driver;
//		File aa=ts.getScreenshotAs(OutputType.FILE);
//		try {
//		FileUtils.copyFile(aa, new File("Screenshots/Homework1/"+name));
//		}catch(IOException e) {
//			System.out.println(e.getMessage());
//		}
		
		}
	
	
	@DataProvider
	public Object[][] getData(){
		Object data[][]= {
				{"Billy", "Kimber","Billykim1", "Billykim123!@#","Billykim123!@#"},
				{"Thomas","Shelby", "Thomasshel2", "Thomasshel123!@#","Thomasshel123!@#"},
				{"Finn", "Shelby", "FinnShel3", "FinnShel123!@#","FinnShel123!@#"},
				{"Luca","Changretta", "Lucachang4", "Lucachang123!@#","Lucachang123!@#"},
				{"Arthur", "Shelby", "Arthurshel5", "Arthurshel123!@#","Arthurshel123!@#"}
		
		};
				return data;
		
		}

	
	@AfterMethod(alwaysRun=true)
	public void afterTest() {
		driver.quit();
	}
}
