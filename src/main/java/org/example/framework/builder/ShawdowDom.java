package org.example.framework.builder;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ShawdowDom {

    WebDriver driver;

    public WebDriver getDriver(){
        driver = new ChromeDriver();
        //WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        return driver;
    }

    @Test
    public void downloadFile() throws InterruptedException {

    }

    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }

    @Test
    public void getTextUsingJS() {
        WebDriver driver = getDriver();
        driver.get("http://watir.com/examples/shadow_dom.html");
        WebElement shadowRootEle = driver.findElement(By.id("shadow_host"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement shadowRoot = (WebElement) jsExecutor.executeScript("return arguments[0].shadowRoot", shadowRootEle);
        String text  = shadowRoot.findElement(By.cssSelector("#shadow_content span")).getText();
        System.out.println(text);
    }

    @Test
    public void getText(){
        WebDriver driver = getDriver();
        driver.get("http://watir.com/examples/shadow_dom.html");
        WebElement nestedTextElement = driver
                .findElement(By.id("shadow_host"))
                .getShadowRoot()
                .findElement(By.cssSelector("#nested_shadow_host"))
                .getShadowRoot()
                .findElement(By.cssSelector("#nested_shadow_content div"));
        System.out.println(nestedTextElement.getText());


        WebElement shadowHost = driver.findElement(By.id("shadow_host"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        String text = shadowRoot.findElement(By.cssSelector("#shadow_content span")).getText();
        System.out.println(text);

        WebElement nestedShadowHost =
                shadowRoot.findElement(By.cssSelector("#nested_shadow_host"));
        SearchContext nestedShadowRoot = nestedShadowHost.getShadowRoot();
        String nestedText = nestedShadowRoot.findElement(By.cssSelector("#nested_shadow_content div")).getText();
        System.out.println(nestedText);

    }

    @Test
    public void testIbmShadowDom(){
        WebDriver driver =  getDriver();
        driver.get("https://www.ibm.com/in-en");
        System.out.println(driver.getTitle());

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        WebElement aboutIbmLink = driver
                .findElement(By.cssSelector("[href*='about?lnk=intro']"));
        jse.executeScript("arguments[0].scrollIntoView(true);", aboutIbmLink);

                /*.findElement(By.cssSelector(".bx--col caem-intro-section"))
                .getShadowRoot()
                .findElement(By.cssSelector("[data-autoid='dds--link-list']"))
                .getShadowRoot()
                .findElement(By.cssSelector("dds-video-cta-container"))
                .getShadowRoot()
                .findElement(By.cssSelector("[rold='listitem']"))
                .getShadowRoot()
                .findElement(By.cssSelector("a"));*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds timeout
        WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(aboutIbmLink));
        ele.click();
        System.out.println(driver.getTitle());


    }

    @Test
    public void scrollFunctions(){

        WebDriver driver = getDriver();
        driver.get("https://www.amazon.in/");
        WebElement amazonLive =
                driver.findElement(By.id("desktop-4"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView(true);",amazonLive);
        js.executeScript("document.getElementById('desktop-4').scrollIntoView(true);");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    @Test
    public void actionClassDemo(){
        WebDriver driver = getDriver();
        Actions actions = new Actions(driver);

    }


    @Test
    public void emiratesBooking() {
        WebDriver driver = getDriver();
        driver.get("https://www.emirates.com/in/english/book/?gad_source=1&gclid=Cj0KCQiAnrOtBhDIARIsAFsSe51JnVgnLyI0HOMBdyvjwjG4hf4Xk-v7Q9jGQ-hEc6luQoEyQoYW2DkaAhhZEALw_wcB&gclsrc=aw.ds");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button#onetrust-accept-btn-handler")));
        WebElement cookie_accept = driver.findElement(By.cssSelector("button#onetrust-accept-btn-handler"));
        Actions actions = new Actions(driver);
        actions.click(cookie_accept)
                        .sendKeys("Chennai")
                                .sendKeys(Keys.RETURN)
                                        .build().perform();

    }


}
