package com.naveen.dependancyTests;

import org.testng.annotations.Test;

public class TestDependancy {
	static String trackingNumber = null;
	@Test(priority = 2)
	public void CreateShipment() {
		System.out.println(5/0);
		System.out.println("CreateShipment");
		trackingNumber = "ABC12MN";
	}

	@Test(priority = 1, dependsOnMethods = {"CreateShipment"}, alwaysRun = true )
	public void TrackShipment() throws Exception {
		if(trackingNumber !=null)
			System.out.println("TrackShipment");
		else
			throw new Exception("invalid tracking number");
	}

	@Test(priority = 3,dependsOnMethods = {"CreateShipment","TrackShipment"})
	public void CancelShipment() throws Exception {
		if(trackingNumber !=null)
			System.out.println("CancelShipment");
		else
			throw new Exception("invalid tracking number");

	}

}
