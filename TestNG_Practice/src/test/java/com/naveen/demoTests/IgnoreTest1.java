package com.naveen.demoTests;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

//@Ignore
public class IgnoreTest1 {
	//@Ignore
	@Test        //(enabled = false)
	public void test1() {
		System.out.println("test1");  
	}

	
	@Test
	public void test2() {
		System.out.println("test2");
	}

	
	@Test
	public void test3() {
		System.out.println("test3");
	}
}
