package org.example.framework.report;

import com.aventstack.extentreports.MediaEntityBuilder;

public final class ExtentLogger {

    private ExtentLogger(){}

    public static void pass(String msg){
        ExtentReportManager.getTest().pass(msg);
    }

    public static void fail(String msg){
        ExtentReportManager.getTest().fail(msg);
    }

    public static void pass(String msg, String screenShot){
        ExtentReportManager.getTest().pass(msg,
                MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot).build());
    }

    public static void fail(String msg, String screenShot){
        ExtentReportManager.getTest().fail(msg,
                MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot).build());
    }

}
