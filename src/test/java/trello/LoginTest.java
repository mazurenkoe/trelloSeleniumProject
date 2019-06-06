package trello;

import core.BrowserFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BrowserFactory {

    @BeforeMethod
    public void openLoginPage() {
        pages.loginPage.open();
    }

    @Test
    public void loginSuccess() {
        pages.loginPage.login();
        wait.until(ExpectedConditions.urlContains("/boards"));
        Assert.assertTrue(!driver.findElements(pages.header.userIcon).isEmpty());
    }

    @Test(dependsOnMethods = "loginSuccess")
    public void loginWrongPassword() {
        pages.loginPage.login(pages.loginPage.defaultEmail, "123456");
        wait.until(ExpectedConditions.elementToBeClickable(pages.loginPage.loginFld));
        Assert.assertEquals(driver.findElement(pages.loginPage.errorMessage).getText(), "Invalid password");
    }

    @Test(dependsOnMethods = "loginSuccess")
    public void loginWrongEmail() {
        pages.loginPage.login("notexistedemail", "123456");
        wait.until(ExpectedConditions.elementToBeClickable(pages.loginPage.loginFld));
        Assert.assertEquals(driver.findElement(pages.loginPage.errorMessage)
                .getText(), "There isn't an account for this username");
    }
}
