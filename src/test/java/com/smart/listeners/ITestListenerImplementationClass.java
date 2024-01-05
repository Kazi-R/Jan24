package com.smart.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerImplementationClass implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		 System.out.println("On Test Start> " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("On Test Success> " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("On Test Failure> " + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("On Test Skipped> " + result.getName());
	}
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("On Test Start> " + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("On Test Finish> " + context.getName());
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("On Test failed for Timeout error> " + result.getName());
	}	
}
