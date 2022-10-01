package com.naveen.dataProvider;

import org.testng.annotations.DataProvider;

public class BasicTestDataSuppiler {

	@DataProvider
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
