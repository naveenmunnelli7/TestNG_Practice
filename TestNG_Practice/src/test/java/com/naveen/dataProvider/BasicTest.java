package com.naveen.dataProvider;

import org.testng.annotations.Test;

public class BasicTest {

	@Test(dataProvider = "dp1", dataProviderClass = BasicTestDataSuppiler.class)
	public void TestLogin(String n) {
		System.out.println(n);
	}
}
