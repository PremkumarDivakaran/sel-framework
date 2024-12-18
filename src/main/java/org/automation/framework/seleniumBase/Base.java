package org.automation.framework.seleniumBase;


import org.automation.framework.config.ConfigurationManager;
import org.automation.framework.enums.Locators;
import org.automation.framework.report.ExtentLogger;
import org.automation.pages.LoginPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.automation.framework.driver.DriverInstance.getDriver;
import static org.automation.framework.driver.DriverInstance.setDriver;

public class Base {

    public WebElement locateElement(Locators locatorType, String value) {
        try {
            switch (locatorType) {
                case CLASS_NAME:
                    return getDriver().findElement(By.className(value));
                case CSS:
                    return getDriver().findElement(By.cssSelector(value));
                case ID:
                    return getDriver().findElement(By.id(value));
                case LINK_TEXT:
                    return getDriver().findElement(By.linkText(value));
                case NAME:
                    return getDriver().findElement(By.name(value));
                case XPATH:
                    return getDriver().findElement(By.xpath(value));
                default:
                    System.err.println("Locator is not Valid");
                    break;
            }
        } catch (NoSuchElementException e) {
            ExtentLogger.fail("The Element with locator:" + locatorType + " Not Found with value: " + value + "\n"
                    + e.getMessage());
        } catch (Exception e) {
            ExtentLogger.fail("The Element with locator:" + locatorType + " Not Found with value: " + value + "\n"
                    + e.getMessage());
        }
        return null;
    }

    public WebDriverWait waitForElement(){
        return new WebDriverWait(getDriver(), Duration.ofSeconds(60));
    }

    public void clearAndType(WebElement ele, String data) {
        try {
            waitForElement().until(ExpectedConditions.visibilityOf(ele));
            ele.clear();
            ele.sendKeys(data);
            ExtentLogger.pass("Data entered successfully", getScreenShot());
        } catch (NoSuchElementException e) {
            ExtentLogger.fail("The Element "
                    + ele + " is not found " + e.getMessage());
        }
    }

    public void click(WebElement ele) {
        try {
            waitForElement().until(ExpectedConditions.elementToBeClickable(ele));
            ele.click();
            ExtentLogger.pass("The Element " + ele + " is clicked successfully", getScreenShot());
        } catch (NoSuchElementException e) {
            ExtentLogger.fail("The Element " + ele + " is not found " + e.getMessage(), getScreenShot());
        }
    }

    public String getText(WebElement ele) {
        String val = null;
        try {
            waitForElement().until(ExpectedConditions.visibilityOf(ele));
            val = ele.getText();
        } catch (NoSuchElementException e) {
            ExtentLogger.fail("The Element " + ele + " is not found " + e.getMessage());
        }
        return val;
    }

    public static void startApp(String url) {
        try {
            setDriver();
            getDriver().manage().window().maximize();
            getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
            getDriver().get(url);
            ExtentLogger.pass("Url : " + url + " has loaded successfully", getScreenShot());
        } catch (Exception e) {
            ExtentLogger.fail("The Browser Could not be Launched. Hence Failed \n" + e.getMessage());
        }
    }

    public static LoginPage launchApp(){
        startApp(ConfigurationManager.getConfiguration().url());
        return new LoginPage();
    }

    public static String getScreenShot() {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BASE64);
    }

    public void waitForSeconds(long seconds){
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

