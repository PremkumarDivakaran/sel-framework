package org.example.pages;



import org.example.framework.enums.Locators;
import org.example.framework.report.ExtentLogger;
import org.example.framework.seleniumBase.Base;

public class HomePage extends Base {

    public LoginPage clickLogout(){
        click(locateElement(Locators.XPATH,"//a[text()='Log out']"));
        ExtentLogger.pass("Log out Successfully", getScreenShot());
        return new LoginPage();
    }

    public String getTitle(){
        return getText(locateElement(Locators.CLASS_NAME,"post-title"));
    }

}
