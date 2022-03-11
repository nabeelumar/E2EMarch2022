package com.andoroathodi.EndToEndProjectMarch2022;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReportsTest;
import resources.base;

public class Listener extends base implements ITestListener{
ExtentReports extent = ExtentReportsTest.getRep();
ExtentTest test;
ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		 WebDriver driver = null;
		ITestListener.super.onTestSuccess(result);
		try {
			driver= (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String testName=result.getMethod().getMethodName();
		try {
			takeScreenshot(driver,testName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extentTest.get().log(Status.PASS, "Test PASSED");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		 
		WebDriver driver=null;
		ITestListener.super.onTestFailure(result);
		try {
			
			driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			 
		}catch(Exception e) {
			
			 
		}
		String testName = result.getMethod().getMethodName();
		try {
			String destinationFile = takeScreenshot(driver,testName);
			extentTest.get().addScreenCaptureFromPath(destinationFile,testName );
			
		}catch(IOException e) {
			
			e.printStackTrace();
		}
		
		//test.log(Status.FAIL, "Test FAILED");
		extentTest.get().fail(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		extent.flush();
	}



}
