package com.smart.extentReports;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerImplmentationClass1 extends BaseClass implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		captureScreenshot(result.getMethod().getMethodName());
	}	
}
