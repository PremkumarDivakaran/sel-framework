package org.automation.framework.listeners;

import org.automation.framework.report.ExtentLogger;
import org.automation.framework.report.ExtentReporter;
import org.testng.*;
import org.testng.internal.annotations.TestAnnotation;

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
        result.getMethod().setRetryAnalyzerClass(RetryAnalyzer.class);
    }

    @Override
    public void onTestSuccess(ITestResult result){
        ExtentLogger.pass(result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result){ ExtentLogger.fail(result.getThrowable().getMessage()); }


}
