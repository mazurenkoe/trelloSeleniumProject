package trello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static core.BrowserFactory.driver;
import static core.BrowserFactory.wait;

public class Header {

    public static By userIcon = new By.ByClassName("member-initials");
    public static By logoutIcon = new By.ByClassName("js-logout");

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(Header.userIcon));
        driver.findElement(Header.userIcon).click();
        wait.until(ExpectedConditions.elementToBeClickable(Header.logoutIcon));
        driver.findElement(Header.logoutIcon).click();
        wait.until(ExpectedConditions.urlToBe("https://trello.com/logged-out"));
    }
}
