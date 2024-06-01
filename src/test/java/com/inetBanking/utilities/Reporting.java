package com.inetBanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.inetBanking.testCases.BaseClass;

public class Reporting extends TestListenerAdapter
{
	private ExtentReports extent;
	private ExtentTest logger;

	
	public void onStart(ITestContext testContext)
	{

		try {
			String timeStamp = new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new Date());
			String repName = "Test-Report-"+timeStamp+".html";
			
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output1/"+repName);
			sparkReporter.loadXMLConfig(System.getProperty("user.dir")+"/Configuration/extent-config.xml");
			
			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
			extent.setSystemInfo("Host name","localhost");
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("user", "Sandip");
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	public void onTestSuccess(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		
	}
	
	
	public void onTestFailure(ITestResult tr)
	{
		logger = extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
		
		try {
			BaseClass.captureScreen(BaseClass.driver,tr.getName());

			String screenshotPath = System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+".png";
			File f = new File(screenshotPath);
			if(f.exists())
			{
                logger.fail("Screenshot is below:"+ logger.addScreenCaptureFromPath(screenshotPath));
			}
		}catch (IOException e) {
            logger.log(Status.FAIL, "Failed to capture screenshot: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		logger = extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
		
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
	
	}
