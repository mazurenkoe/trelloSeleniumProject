package trello;

import core.BrowserFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BrowserFactory {

    @Test
    public void logout() {
        pages.loginPage.open();
        pages.loginPage.login();
        pages.logoutPage.logout();
        Assert.assertEquals(driver.getCurrentUrl(),  pages.logoutPage.urlLogOut);
    }
}
