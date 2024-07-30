package com.actitme.generic;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementation extends BaseClass implements ITestListener{
	ExtentReports report;
	ExtentTest test ;
	@Override
	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"--------Test Script Execution Started------- ");
		
		 test = report.createTest(methodname);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		//System.out.println(methodname+"--------Test Script Execution Pass------- ");
		test.log(Status.PASS, methodname+"----------pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getThrowable());
		
		String methodname = result.getMethod().getMethodName();
		
		String Timestamp = LocalDateTime.now().toString().replace(':', '-');
		driver = ((BaseClass) result.getInstance()).driver;
		TakesScreenshot s=(TakesScreenshot)driver;
	
		File src = s.getScreenshotAs(OutputType.FILE);
		File des=new File("./Screenshot/"+methodname+""+Timestamp+".png");
		try {
		FileUtils.copyFile(src, des);
		}
		catch(IOException e) {
			
		}
		test.log(Status.FAIL, methodname+"----------Fail");
		test.log(Status.INFO, result.getThrowable());
	
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getThrowable());
		
		String methodname = result.getMethod().getMethodName();
		//System.out.println(methodname+"-------- SKipped------- ");
		test.log(Status.SKIP, methodname+"----------Skipped");
		test.log(Status.INFO, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		String Timestamp = LocalDateTime.now().toString().replace(':', '-');
		ExtentSparkReporter htmlreport=new ExtentSparkReporter(".\\ExtentReport\\Report="+Timestamp+".html");
		htmlreport.config().setDocumentTitle("ActitimeReport");
		htmlreport.config().setReportName("AutomationExecution Report");
		//htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setTheme(Theme.STANDARD);
		
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("BasePlatfrom", "Windows");
		report.setSystemInfo("BaseBrowser", "Chrome");
		report.setSystemInfo("BaseUrl", "https://online.actitime.com/ssankar/login.do");
		report.setSystemInfo("BaseEnvironment", "TestEnviroment");
		report.setSystemInfo("Report", "santhosh");

		
	
		
		 System.out.println("------Testsuite Started-------");
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		
		System.out.println("-------Testsuite Finished------");
	}

	
	
}
