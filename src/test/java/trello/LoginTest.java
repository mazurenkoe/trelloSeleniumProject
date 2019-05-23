package trello;

import core.BrowserFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BrowserFactory {

    @Test
    public void loginSuccess() {
        pages.loginPage.open();
        pages.loginPage.login();
        Assert.assertTrue(!driver.findElements(pages.header.userIcon).isEmpty());
    }

    @Test(dependsOnMethods = "loginSuccess")
    public void loginWrongPassword() {
        pages.loginPage.open();
        pages.loginPage.submitLoginForm(pages.loginPage.defaultEmail, "123456");
        wait.until(ExpectedConditions.elementToBeClickable(pages.loginPage.loginFld));
        Assert.assertEquals(driver.findElement(pages.loginPage.errorMessage).getText(), "Invalid password");
    }

    @Test(dependsOnMethods = "loginSuccess")
    public void loginWrongEmail() {
        pages.loginPage.open();
        pages.loginPage.submitLoginForm("notexistedemail", "123456");
        wait.until(ExpectedConditions.elementToBeClickable(pages.loginPage.loginFld));
        Assert.assertEquals(driver.findElement(pages.loginPage.errorMessage).getText(), "There isn't an account for this username");
    }
}
