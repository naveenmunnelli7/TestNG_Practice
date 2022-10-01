package com.naveen.test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM {
	WebDriver driver;
	
	@Parameters("browserName")
	@BeforeTest
	public void InitiliseBrowser(@Optional("chrome") String browserName) {
		System.out.println(browserName);
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			System.err.println("Browser name is invalid");
			break;
		}
		
		
		driver.manage().window().maximize();
	}
	
	@Parameters("sleepTime")
	@AfterTest
	public void TearDown(Long sleepTime) throws NumberFormatException, InterruptedException {
		System.out.println(sleepTime);
		Thread.sleep(sleepTime);
		driver.quit();
	}
	
	
	@Parameters("url")
	@Test
	public void LanchApp(String url) {
		driver.get(url);
	}
	
	@Parameters({"username" , "password"})
	@Test
	public void EnterLoginDetails(String username, String password) throws InterruptedException  {
		driver.findElement(By.id("txtUsername")).sendKeys("username");
		driver.findElement(By.id("txtPassword")).sendKeys("password");
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(2000);
	}
	
	@Test
	public void NavigateToMyInfo() {
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
	}
	
	@Test
	public void VerifyMyInfo() {
		 
		boolean actualValue = driver.findElement(By.id("employee-details")).isDisplayed();
		assertTrue(actualValue);
	}
	
	@Test
	public void VerifyLogin() {
		WebElement element = driver.findElement(By.id("welcome"));
		assertTrue(element.isDisplayed());
		assertTrue(element.getText().startsWith("Welcome"));
		
		
	}

}
