package com.utils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//cntrl+o  to see all methods within the class
public class CommonMethods {

	public static WebDriver driver;

	/**
	 * Use this method in need of opening browser and target url
	 * 
	 * @param browser The desired browser
	 * @param url     The desired url
	 */
	public static void setUp(String browser, String url) {

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\\\Users\\\\Farrukh\\\\eclipse-workspace\\\\TestNGBasics\\\\drivers\\\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(url);

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\\\Users\\\\Farrukh\\\\eclipse-workspace\\\\Sample\\\\drivers\\\\gecko.exe");
			driver = new FirefoxDriver();
			driver.get(url);
		} else {
			System.err.println("Brower not supported");

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);

	}
	
	

//	public static WebDriver setUp(String browser){
//		
//		if(browser.equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver", "drivers/chromeDriver");
//			driver=new ChromeDriver();
//		
//		}else if(browser.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
//			driver=new FirefoxDriver();
//		}
//		
//		return driver;
//	}
	/**
	 * This method will accept alert
	 * @throwns NoAlertAcception
	 * 
	 */
	

	public static void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert is not present");
		}
	}
	
	/**
	 * This method will dismiss the alert
	 * @throws NoAlertAcception
	 */

	public static void DismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();

		} catch (NoAlertPresentException e) {
			System.out.println("Alert is not present");
		}
	}

	/**
	 * this method will get a text from the alert
	 * 
	 * @return text of the alert
	 * @throws will throw NoAlertPresentException if alert is not present
	 */

	public static String getAlertText() {
		String alertText;
		try {
			Alert alert = driver.switchTo().alert();
			return alertText = alert.getText();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert is not present");
			return null;
		}
	}
	/**
	 * This method switch to the frame
	 * 
	 * @param nameOrId
	 */
	public static void switchToFrame(String nameOrId) {
		try {
			driver.switchTo().frame(nameOrId);
		}catch(NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}
	/**
	 * This method switch to the frame
	 * 
	 * @param element
	 */
	public static void switchToFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);
		}catch(NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}
	/**
	 * This method switch to the frame
	 * 
	 * @param element
	 */
	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		}catch(NoSuchFrameException e) {
		System.out.println("Frame is not present");
	}
}

	/**
	 * This method will click on the element using JSExecutor
	 * @param element
	 */
	public static void jsClick(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
	}
	/**
	 * This method will scroll until specified element
	 * @param element
	 */
	
	public static void scrollIntoElement(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * This method will scroll page down
	 * @param pixel
	 */
	public static void scrollDown (int pixel) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+pixel+")");
	}
   /**
    * This method will scroll page up
    * @param pixel
    */
	public static void scrollUp (int pixel) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-"+pixel+")");
	}
	/**
	 * This method will take a screenshot
	 * @param fileName
	 */
   public static void takeScrenshot(String fileName) {
	   TakesScreenshot ts=(TakesScreenshot)driver;
	   File file=ts.getScreenshotAs(OutputType.FILE);
	   try {
	   FileUtils.copyFile(file, new File("/screenshot/"+fileName+".png"));
	   }catch (IOException e) {
		   System.out.println("Cannot take a screenshot");
	   }
	   }
}
   