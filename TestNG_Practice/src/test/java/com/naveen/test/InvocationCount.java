package com.naveen.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvocationCount {

	@Test(invocationCount = 4,threadPoolSize = 2)          //invocationTimeOut = 10000
	public void TestGuy() throws Exception  {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver =  new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://randomuser.me/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@data-label='name']")).click();
		
		driver.findElement(By.xpath("//li[@data-label='birthday']")).click();
		driver.quit();
}
}
