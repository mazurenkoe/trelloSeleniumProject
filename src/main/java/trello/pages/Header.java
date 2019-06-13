package trello.pages;

import core.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.BrowserFactory.driver;
import static core.BrowserFactory.wait;

public class Header {

    public static By userIcon = new By.ByCssSelector("button.js-open-header-member-menu");
    public static By logoutIcon = new By.ByCssSelector("[data-test-id='header-member-menu-logout']");
    public static By homeIcon = new By.ByCssSelector("span[name='house']");

        public void logout() {
        wait.until(ExpectedConditions.presenceOfElementLocated(userIcon));
        driver.findElement(userIcon).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(logoutIcon));
        driver.findElement(Header.logoutIcon).click();
        wait.until(ExpectedConditions.urlToBe("https://trello.com/logged-out"));
    }
}
