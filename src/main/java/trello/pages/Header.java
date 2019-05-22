package trello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.BrowserFactory.driver;

public class Header {

    public static By userIcon = new By.ByClassName("member-initials");
    public static By logoutIcon = new By.ByClassName("js-logout");

    public void logout() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(Header.userIcon));
        driver.findElement(Header.userIcon).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(Header.logoutIcon));
        driver.findElement(Header.logoutIcon).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlToBe("https://trello.com/logged-out"));
    }
}
