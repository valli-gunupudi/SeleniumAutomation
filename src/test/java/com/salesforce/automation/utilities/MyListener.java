package com.salesforce.automation.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener{
	
	protected Logger ListenerLog = LogManager.getLogger();
	

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ListenerLog.info("..from listner "+result.getMethod().getMethodName()+" started");	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ListenerLog.info("..from listner "+result.getMethod().getMethodName()+" ended with success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ListenerLog.error("..from listner "+result.getMethod().getMethodName()+" ended with failure");
		
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
		ListenerLog.info(".........Listener suite execution started...........");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ListenerLog.info(".........Listener suite execution ended...........");
	}

}
