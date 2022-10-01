package com.naveen.test;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {

	@Test
	public void TestGoogle() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		driver.findElement(By.name("q")).sendKeys("Naveen", Keys.ENTER);
		String expectedTitle = "Naveen - Google Search";
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectedTitle);
	    
		driver.close();
		
		
	}
	
	@Test
	public void TestFacebook() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("email")).sendKeys("Naveen", Keys.ENTER);
		Thread.sleep(3000);

		SoftAssert softAssert = new SoftAssert();
		
		//Title Assertion
		String expectedTitle ="Log in to Facebook";
		String actualTitile = driver.getTitle();
		softAssert.assertEquals(actualTitile, expectedTitle, "Title is mismatched");
		
		//URL Assertion 
		String expectedUrl ="https://www.facebook.com/";
		String actualUrl = driver.getCurrentUrl();
		softAssert.assertNotEquals(actualUrl, expectedUrl, "URL is mismatched");
		
		//Text Assertion
		String expectedText ="Naveen";
		String actualText = driver.findElement(By.name("email")).getAttribute("value");
		softAssert.assertEquals(actualText, expectedText, "Username text is mismatched");

		//Border Assertion
		String expectedBorder ="1px solid rgb(221, 223, 226)";
		String actualBorder = driver.findElement(By.name("email")).getCssValue("border");
		softAssert.assertEquals(actualBorder, expectedBorder, "Username border is mismatched");

		//ErrorMessage Assertion
		String expectedErrorMessage ="You can't log in at the moment";
		String actualErrorMessage = driver.findElement(By.xpath("//div[@id='error_box']/div")).getText();
		softAssert.assertEquals(actualErrorMessage, expectedErrorMessage, "Username ErrorMessage is mismatched");

		
		Thread.sleep(3000);
		driver.close();
		softAssert.assertAll();

	}
}
