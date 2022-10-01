package com.naveen.dataProvider;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.ObjectArrays;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dataProvider2 {

	@Test(dataProvider = "dp1")
	public void TestLogin(Object[] m) {
		//System.out.println(m);
		System.out.println(m[0] +" >> "+m[1]);
		//		for (int i = 0; i < m.length; i++) {
		//			System.out.println(m[i]);
		//		}
		//		System.out.println("-------");
	}

	//	@org.testng.annotations.DataProvider
	//	public String[] dp1() {
	//		String[] data = new String[] {	
	//		         "abcd",
	//		         "xyz",
	//		         "pqr"
	//	};
	//		return data;
	//	}


	//	@org.testng.annotations.DataProvider
	//	public Integer[] dp1() {
	//		Integer[] data = new Integer[] {	
	//		        1,
	//		        3,
	//		        5
	//	};
	//		return data;
	//	}


	//	//Combination of String and Integer values we can use Object[]
	//	@org.testng.annotations.DataProvider
	//	public Object[] dp1() {
	//		Object[] data = new Object[] {	
	//		         1,
	//		         "Naveen",
	//		         5
	//	};
	//		return data;
	//	}

	//	@org.testng.annotations.DataProvider
	//	public String[][] dp1() {
	//		String[][] data = new String[][] {	
	//			{"abcd","123"},
	//				{"xyz","456"},
	//				{"pqr","789"}
	//	};
	//		return data;
	//	}

	//	@org.testng.annotations.DataProvider
	//	public String[][] dp1() {
	//		String[][] data = new String[][] {	
	//			{"abcd","123","mnk"},
	//				{"xyz","456","546","hfd"},
	//				{"pqr","789"}
	//	};
	//		return data;
	//	}

	//	@DataProvider
	//	public Iterator<String> dp1() {
	//		List<String> data = new ArrayList<>();
	//		data.add("Naveen");
	//		data.add("Munnelli");
	//		return data.iterator();
	//	}

	//	@DataProvider
	//	public Iterator<String> dp1() {
	//		Set<String> data = new HashSet<>();      //TreeSet() also you can write
	//		data.add("Naveen");
	//		data.add("Munnelli");
	//		return data.iterator();
	//	}

//	@DataProvider
//	public Iterator<String[]> dp1() {
//		Set<String[]> data = new HashSet<>();
//		data.add(new String[] {"Naveen","Kumar"});
//		data.add(new String[] {"Keerthi","Suresh"});
//		return data.iterator();
//	}
	
	@DataProvider
	public Iterator<Object[]> dp1() {
		Set<Object[]> data = new HashSet<>();
		data.add(new Object[] {"Naveen",45});
		data.add(new Object[] {"Keerthi",345});
		return data.iterator();
	}
}
