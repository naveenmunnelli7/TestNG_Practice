package com.naveen.parallelTest;

import org.testng.annotations.Test;

public class TestClass2 {

	@Test
	public void TestMethod5() {
		System.out.println("TestClass2  >>  TestMethod5 >>" +Thread.currentThread().getId());
	}
	
	@Test
	public void TestMethod6() {
		System.out.println("TestClass2  >>  TestMethod6 >>" +Thread.currentThread().getId());
	}
	
	@Test
	public void TestMethod7() {
		System.out.println("TestClass2  >>  TestMethod7 >>" +Thread.currentThread().getId());
	}
	
	
}
