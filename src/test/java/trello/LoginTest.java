package trello;

import core.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import trello.pages.Header;

public class LoginTest extends BrowserFactory {

    @Test(priority = 2)
    public void loginSuccess() {
        pages.loginPage.open();
        pages.loginPage.login();
        Assert.assertTrue(!driver.findElements(pages.header.userIcon).isEmpty());
    }

    @Test(priority = 1)
    public void LoginWrongPassword() throws InterruptedException {
        pages.loginPage.open();
        pages.loginPage.submitLoginForm(pages.loginPage.defaultEmail, "123456");
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(pages.loginPage.loginFld));
        Assert.assertEquals(driver.findElement(pages.loginPage.errorMessage).getText(), "Invalid password");
    }

    @Test(priority = 3)
    public void LoginWrongEmail() throws InterruptedException {
        pages.loginPage.open();
        pages.loginPage.submitLoginForm("notexistedemail", "123456");
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(pages.loginPage.loginFld));
        Assert.assertEquals(driver.findElement(pages.loginPage.errorMessage).getText(), "There isn't an account for this username");
    }
}
