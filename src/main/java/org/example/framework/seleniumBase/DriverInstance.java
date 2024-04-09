package org.example.framework.seleniumBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.framework.config.ConfigurationManager;
import org.example.framework.enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverInstance {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(){
        if(!ConfigurationManager.getConfiguration().remote()){
            if(ConfigurationManager.getConfiguration().browser().equals(BrowserType.CHROME)){
                WebDriverManager.chromedriver().setup();
                ChromeOptions chrome_options = new ChromeOptions();
                chrome_options.addArguments("--headless");
                driver.set(new ChromeDriver(chrome_options));
            }else if(ConfigurationManager.getConfiguration().browser().equals("firefox")){
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
            }
        }else{
            if(ConfigurationManager.getConfiguration().browser().equals("chrome")){
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setBrowserName(Browser.CHROME.browserName());
                desiredCapabilities.setVersion("");
                ChromeOptions chrome_options = new ChromeOptions();
                chrome_options.addArguments("--no-sandbox");
                chrome_options.addArguments("--disable-dev-shm-usage");
                chrome_options.addArguments("--disable-notifications");
                chrome_options.addArguments("--headless");
                desiredCapabilities.merge(chrome_options);
                try {
                    driver.set(
                            new RemoteWebDriver(new URL("http://" + ConfigurationManager.getConfiguration().remoteUrl()
                                     + "/wd/hub"), chrome_options));
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            } else if(ConfigurationManager.getConfiguration().browser().equals("firefox")){
                FirefoxOptions firefox_options = new FirefoxOptions();
                firefox_options.addArguments("--no-sandbox");
                firefox_options.addArguments("--disable-dev-shm-usage");
                firefox_options.addArguments("--disable-notifications");
                firefox_options.addArguments("--headless");
                try {
                    driver.set(
                            new RemoteWebDriver(new URL("http://" + ConfigurationManager.getConfiguration().remoteUrl()
                                    + "/wd/hub"), firefox_options));
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    public static WebDriver getDriver(){
        return driver.get();
    }

}
