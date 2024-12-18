package org.automation.framework.driver.manager;

import org.automation.framework.config.ConfigurationManager;
import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Read from Property File
    protected static String remoteUrl = ConfigurationManager.getConfiguration().remoteUrl();

    /*
    //Read from maven env variable
    protected static String remoteUrl = System.getProperty("remoteUrl", "localhost");
    */

    public abstract void setBrowserDriver();

    public static WebDriver getDriver(){
        return driver.get();
    }

}
