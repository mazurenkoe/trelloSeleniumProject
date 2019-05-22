package trello.pages;

import org.openqa.selenium.By;

import static core.BrowserFactory.driver;

public class Header {

    public static By userIcon = new By.ByClassName("member-initials");
    public static By logoutIcon = new By.ByClassName("js-logout");

}
