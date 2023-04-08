package com.rbhprac.generics;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImplementation extends BaseClass implements ITestListener{
	
	@Override
	public void onTestStart(ITestResult result) {
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	}
	@Override
	public void onTestFailure(ITestResult result) {
		String testcasename = result.getName();
		
		TakesScreenshot ts= (TakesScreenshot) driver.get();
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./ScreenShot/"+testcasename+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e1) {

			e1.printStackTrace();
		}
		
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

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}

