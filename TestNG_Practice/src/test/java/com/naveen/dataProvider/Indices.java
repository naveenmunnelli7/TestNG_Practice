package com.naveen.dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Indices {
	
	@Test(dataProvider = "dp1")
	public void TestLogin(String n) {
		System.out.println(n);
	}

	@DataProvider(indices= {0,2})
	public String[] dp1() {
		String[] data = new String[] {
				"Naveen",
				"Kiran",
				"Vishnu",
				"Mahi"
		};
		return data;
	}
}
