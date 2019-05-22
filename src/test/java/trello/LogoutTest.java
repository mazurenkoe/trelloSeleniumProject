package trello;

import core.BrowserFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BrowserFactory {

    LoginPage loginPage = new LoginPage();
    LogoutPage logoutPage = new LogoutPage();

    @Test
    public void logout() {
        loginPage.open();
        loginPage.login("elena.mazurenko91@gmail.com", "Lena10081991");
        logoutPage.logout();
        Assert.assertEquals(driver.getCurrentUrl(), logoutPage.urlLogOut);
    }




//
//    LoginPage loginPage = new LoginPage();
//    LogoutPage logoutPage = new LogoutPage();
//    Header header = new Header();
//
//    @Test
//    public void logout() throws IOException {
//        loginPage.login("elena.mazurenko91@gmail.com", "Lena10081991");
////        logoutPage.logout();
////        Assert.assertEquals("currentUrl", "https://trello.com/logged-out");
//    }
}
