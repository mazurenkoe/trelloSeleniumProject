package trello;

import core.BrowserFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends BrowserFactory {

    @BeforeMethod
    public void authorization() {
        pages.loginPage.open();
        pages.loginPage.login();
    }

    @Test
    public void logout() {
        pages.header.logout();
        Assert.assertEquals(driver.getCurrentUrl(), pages.logoutPage.urlLogOut);
    }
}
