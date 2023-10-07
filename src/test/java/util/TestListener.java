package util;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestListener implements ITestListener {
	  private FileWriter customReportWriter;
	 public TestListener() {
	        try {
	            customReportWriter = new FileWriter("custom-report.html");
	            customReportWriter.write("<html><head><title>Custom Test Report</title></head><body>");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

    @Override
    public void onTestStart(ITestResult result) {
        Reporter.log("Test Started: " + result.getName(), true);
       
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Reporter.log("Test Passed: " + result.getName(), true);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Reporter.log("Test Failed: " + result.getName(), true);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Reporter.log("Test Skipped: " + result.getName(), true);
    }

    // Other methods you can implement based on your needs

    // Example:
    // @Override
    // public void onFinish(ITestContext context) {
    //     Reporter.log("Test Suite Finished: " + context.getName(), true);
    // }
}
