package com.alphaShoppee.genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationClass implements ITestListener {
	
	
	public ExtentReports report;
	public ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		
		test = report.createTest(result.getMethod().getMethodName());
		Reporter.log("The method execution is starting here", true);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS, result.getMethod().getMethodName());
		Reporter.log(result.getMethod().getMethodName()+" method execution is success", true);
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" method is failed");
		
		try {
			String screenshotPath = new WebdriverUtility(BaseClass.sDriver).takeScreenshotOfDriver();
			test.log(Status.FAIL, result.getMethod().getMethodName());
			Reporter.log(result.getMethod().getMethodName()+" method got failed", true);
			test.addScreenCaptureFromPath(screenshotPath);
		} catch (IOException e) {
			e.printStackTrace();
		}

	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		test.log(Status.SKIP, result.getMethod().getMethodName());
		Reporter.log(result.getMethod().getMethodName()+" method got skipped", true);
	
	}

	@Override
	public void onStart(ITestContext context) {
		
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./ExtentReport/report.html");
		htmlReport.config().setDocumentTitle("HTML Document");
		htmlReport.config().setReportName("HTML report");
		htmlReport.config().setTheme(Theme.STANDARD);
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-Platform", "Windows");
		report.setSystemInfo("Base-browser", "chrome");
		report.setSystemInfo("Base-url", "http://rmgtestingserver/domain/Online_Shopping_Application/admin/");
		
	}

	
	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		
	}

	
}
