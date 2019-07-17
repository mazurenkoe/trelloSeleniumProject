package trello;

import core.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;

public class LabelCreateTest extends BrowserFactory {

    @BeforeMethod
    public void authorization() {
        pages.loginPage.open();
        pages.loginPage.login();
        wait.until(ExpectedConditions.urlContains("/boards"));
        driver.get("https://trello.com/b/EV6lBD3p/mytestboard");
    }

    @Test
    public void createLable() {
        String lableName = new String("LenaNewLable" + new Date().getTime());
        pages.boards.createLable(lableName);
        String boardContent = driver.findElement(By.cssSelector(".board-canvas")).getText();
        Assert.assertTrue(boardContent.contains(lableName));
    }
}
