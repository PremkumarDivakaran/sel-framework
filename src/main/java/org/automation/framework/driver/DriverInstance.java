package org.automation.framework.driver;

import org.automation.framework.config.ConfigurationManager;
import org.automation.framework.driver.factory.DriverFactory;
import org.automation.framework.driver.factory.RemoteDriverFactory;
import org.automation.framework.driver.manager.DriverManager;
import org.automation.framework.enums.BrowserType;
import org.openqa.selenium.WebDriver;

public class DriverInstance {

    // Read Remote and Browser from Property File
    private static boolean remote = ConfigurationManager.getConfiguration().remote();
    private static BrowserType browser = ConfigurationManager.getConfiguration().browser();

    /*
    // Read Remote and Browser from Maven Environment Varibale
    private static boolean remote = Boolean.parseBoolean(System.getProperty("remote", "false"));
    private static String remoteUrl = System.getProperty("remoteUrl", "localhost");
    private static String browserName = System.getProperty("browserName", "chrome");
    private static BrowserType browser = BrowserType.valueOf(browserName.toUpperCase());
    */

    public static void setDriver(){
        if(remote)
            RemoteDriverFactory.setDriver(browser).setBrowserDriver();
        else
            DriverFactory.setDriver(browser).setBrowserDriver();
    }

    public static WebDriver getDriver(){
        return DriverManager.getDriver();
    }

}
