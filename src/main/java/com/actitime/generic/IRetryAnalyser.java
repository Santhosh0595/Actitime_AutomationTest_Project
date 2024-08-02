package com.actitime.generic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;


public class IRetryAnalyser implements IRetryAnalyzer {

	@Override
	public boolean retry(ITestResult result)
	{
		int count=0;
		int retrycount=2;
		while(count<retrycount) {
			count++;
			return true;
		}
		return false;
	}


}
