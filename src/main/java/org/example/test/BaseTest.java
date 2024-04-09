package org.example.test;

import org.testng.annotations.AfterMethod;

import static org.example.framework.seleniumBase.DriverInstance.getDriver;

public class BaseTest {

    @AfterMethod
    public void quitBrowser(){
        getDriver().quit();
    }


}
