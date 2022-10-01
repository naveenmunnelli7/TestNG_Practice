package com.naveen.screenshots;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;
	public static String screenshotsSubFolderName;
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	
	// Dependency Injection
	@AfterMethod
	public void screenshotCapture(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			captureScreenshot(result.getTestContext().getName()+"_" +result.getMethod().getMethodName()+".jpg");
		}
		
	}
	
	public void captureScreenshot(String filename) {
		if(screenshotsSubFolderName == null ) {
			LocalDateTime myDateObj = LocalDateTime.now();
		    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");

		     screenshotsSubFolderName = myDateObj.format(myFormatObj);
		}
		
	    
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
    	File destFile = new File("./Screenshots/"+screenshotsSubFolderName+"/"+ filename);
		try {
			FileUtils.copyFile(sourceFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Screenshot saved successfully");
		
	}
}
