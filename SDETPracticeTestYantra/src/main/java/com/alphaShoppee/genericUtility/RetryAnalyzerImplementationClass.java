package com.alphaShoppee.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplementationClass implements IRetryAnalyzer{

	int lowerCount = 0;
	int uppercount = 3;
	
	@Override
	public boolean retry(ITestResult result) {
		
		if(lowerCount<uppercount) {
			lowerCount++;
			System.out.println(lowerCount);
			return true;
		}
		
		return false;
	}

	
	
}
