package org.automation.test;

import org.automation.framework.config.ConfigurationManager;
import org.automation.framework.listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.automation.pages.LoginPage.loginInToApp;


@Listeners({TestListener.class})
public class LoginTest extends BaseTest {

    @Test
    public void checkLogin() {
        String title = loginInToApp(ConfigurationManager.getConfiguration().username(),
                ConfigurationManager.getConfiguration().password())
                .getTitle();
        Assert.assertEquals(title, "Dashboard");
    }

    @Test
    public void validateSearchFunctionalityInUserPage() {
        String userToSearch = "Admin";
        String searchResult = loginInToApp(ConfigurationManager.getConfiguration().username(),
                ConfigurationManager.getConfiguration().password())
                .clickAdmin()
                .enterKeywordInSearchBox(userToSearch)
                .clickSearch()
                .getSearchResult();

        Assert.assertEquals(searchResult, userToSearch);
    }

    @Test
    public void checkLogin2() {
        String title = loginInToApp(ConfigurationManager.getConfiguration().username(),
                ConfigurationManager.getConfiguration().password())
                .getTitle();

        Assert.assertEquals(title, "Dashboard");
    }


}
