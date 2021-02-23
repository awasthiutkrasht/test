package com.actitime.genericLib;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class MyListener implements ITestListener {

	@Override
	public void onFinish(ITestContext context) {
      
		Reporter.log(context.getName()+"Ends",true);
	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log(context.getName()+"Starts",true);		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log(result.getName()+"method Failed",true);	
		WebDriverCommonLib wlib = new WebDriverCommonLib();
		try {
			wlib.takePageScreenshot(result.getName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		Reporter.log(result.getName()+"method started",true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log(result.getName()+"method Passed",true);
		
	}

}
