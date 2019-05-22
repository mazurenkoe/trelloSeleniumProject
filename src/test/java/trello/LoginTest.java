package trello;

import core.BrowserFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BrowserFactory {

    LoginPage loginPage = new LoginPage();
    Header header = new Header();

    @Test
    public void login() {
        loginPage.open();
        loginPage.login("elena.mazurenko91@gmail.com", "Lena10081991");
        Assert.assertTrue(!driver.findElements(header.userIcon).isEmpty());
    }
}
