package com.testng.practice;

import static org.testng.Assert.assertEquals;

import org.testng.asserts.SoftAssert;

public class TestngAssertionTestClass {

	public static void main(String[] args) {
		
		assertEquals("hi", "hig", "both are not same");
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals("gh", "guh", "Both are not same");
		
		sa.assertAll();
	}
}
