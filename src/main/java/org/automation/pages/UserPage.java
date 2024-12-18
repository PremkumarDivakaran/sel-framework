package org.automation.pages;

import org.automation.framework.enums.Locators;
import org.automation.framework.seleniumBase.Base;

public class UserPage extends Base {

    String searchUserName = ".oxd-table-filter .oxd-input";
    String searchBtn = "//button[@type='submit']";
    String searchResult = "(//div[@class='oxd-table']//div[@class='oxd-table-card']//div[@role='cell']/div)[2]";

    public UserPage enterKeywordInSearchBox(String keyword){
        waitForSeconds(2000);
        clearAndType(locateElement(Locators.CSS, searchUserName), keyword);
        return new UserPage();
    }

    public UserPage clickSearch(){
        waitForSeconds(2000);
        click(locateElement(Locators.XPATH, searchBtn));
        return new UserPage();
    }

    public String getSearchResult(){
        waitForSeconds(3000);
        return getText(locateElement(Locators.XPATH, searchResult));
    }

}
