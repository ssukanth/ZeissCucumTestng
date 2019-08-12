package com.cz.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.cz.test.enumsandglobals.Globals;

public class ReportListener extends Globals implements ITestListener  {
	
	@Override
	public void onTestStart(ITestResult result) {
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("The test context started at :"+context.getName().toUpperCase());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("The context will be finished of :"+context.getName().toUpperCase());
		
	}

}
