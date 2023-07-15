package com.naveenautomation.DemoProject.Listerners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.naveenautomation.DemoProject.base.BaseClass;

public class RetryFailedTests extends BaseClass implements IRetryAnalyzer {
	int maxCount=2;
	int count =0;
	@Override
	public boolean retry(ITestResult result) {
		logger.info("Retrying Failed Test   !!!!!!!!!!!!!!!!!!!"+result.getMethod().getMethodName()+" for "+count+" times");
		if(count<maxCount) {
			count++;
			return true;
		}
		return false;
	}

}
