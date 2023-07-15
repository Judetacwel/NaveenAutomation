package com.naveenautomation.DemoProject.Listerners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.naveenautomation.DemoProject.base.BaseClass;
import com.naveenautomation.DemoProject.utils.Utils;

public class CustomListener extends BaseClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		logger.info("Test execution started for " + result.getMethod().getMethodName() +" *********************************");
	}

	public void onTestSuccess(ITestResult result) {
		logger.info("Test " + result.getMethod().getMethodName() + " Passed");
	}

	public void onTestFailure(ITestResult result) {
		logger.info("Test "+ result.getMethod().getMethodName()+" Failed"+" !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		Utils.takeScreenShort(result.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult result) {
		logger.info("Test "+result.getMethod().getMethodName()+"Skipped"+" ###################################");
	}

}
