package org.example.framework.listeners;

import org.example.framework.report.ExtentLogger;
import org.example.framework.report.ExtentReporter;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ISuiteListener, ITestListener{

    @Override
    public void onStart(ISuite iSuite){
        ExtentReporter.initReport();
    }

    @Override
    public void onFinish(ISuite iSuite){
        ExtentReporter.flushReport();
    }

    @Override
    public void onTestStart(ITestResult result){
        ExtentReporter.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result){
        ExtentLogger.pass(result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result){ ExtentLogger.fail(result.getThrowable().getMessage()); }


}
