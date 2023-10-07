package util;


import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.TakesScreenshot;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import jewellerstesting.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListener implements ITestListener {
    private ExtentReports extent = new ExtentReports();
    private ExtentTest test;
    private WebDriver driver;
   
    

    @Override
    public void onStart(ITestContext context) {
        String loginExtendedReport = "C:\\Users\\JOSE\\Documents\\krishnapriyainterviewprep\\extent-report.html";
     
     
        
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(loginExtendedReport);
        extent.attachReporter(htmlReporter);
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test passed");
        addScreenshot(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail("Test failed");
        addScreenshot(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
    private void addScreenshot(ITestResult result) {
  driver=  	WebDriverManager.getDriver();
  String methodName = result.getName().toString().trim();
  		File source	= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        String destination = System.getProperty("user.dir") + "/target/Screenshots/" + methodName + "_" + timestamp + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
            test.info("Details", MediaEntityBuilder.createScreenCaptureFromPath(destination).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            test.info("Details", MediaEntityBuilder.createScreenCaptureFromPath(finalDestination.getAbsolutePath()).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

