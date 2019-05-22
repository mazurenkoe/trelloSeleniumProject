package trello;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PrivateKey;

import static core.BrowserFactory.driver;


public class LogoutPage {

    protected static String urlLogOut = "https://trello.com/logged-out";

    public void logout() {
            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(Header.userIcon));
            driver.findElement(Header.userIcon).click();
            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(Header.logoutIcon));
            driver.findElement(Header.logoutIcon).click();
            new WebDriverWait(driver, 10).until(ExpectedConditions.urlToBe("https://trello.com/logged-out"));
    }
}
