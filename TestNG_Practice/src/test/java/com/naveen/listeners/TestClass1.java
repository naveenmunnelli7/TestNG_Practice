package com.naveen.listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(ITestListenerClass.class)
public class TestClass1 {

	@Test
	public void TestMethod1() { 
		System.out.println("I'm inside testmethod1");
	}
	
	@Test
	public void TestMethod2() {
		System.out.println("I'm inside testmethod2");
		Assert.assertTrue(false);
	}
	
	@Test(timeOut = 1000)
	public void TestMethod3() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("I'm inside testmethod3");
	}
	
//	@Test(dependsOnMethods ="testmethod3")
//	public void TestMethod4() {
//		System.out.println("I'm inside testmethod4");
//	}
	
}
