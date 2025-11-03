package org.automation.pages;

import org.automation.framework.enums.Locators;
import org.automation.framework.seleniumBase.Base;

public class HomePage extends Base {

    public LoginPage clickUserProfile(){
        waitForSeconds(2000);
        click(locateElement(Locators.CSS,".oxd-userdropdown-name"));
        return new LoginPage();
    }

    public LoginPage clickLogout(){
        waitForSeconds(2000);
        clickUserProfile();
        click(locateElement(Locators.XPATH,"//*[text()='Logout']"));
        return new LoginPage();
    }

    public UserPage clickAdmin(){
        waitForSeconds(2000);
        click(locateElement(Locators.XPATH, "//div[@class='oxd-sidepanel-body']//span[text()='Admin']"));
        return new UserPage();
    }

    public String getTitle(){
        waitForSeconds(2000);
        return getText(locateElement(Locators.CSS,".oxd-topbar-header-breadcrumb h6 1"));
    }

}
