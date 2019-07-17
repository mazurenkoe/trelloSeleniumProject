package trello;

import core.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;

public class LableDeleteTest extends BrowserFactory {

    String lableName = new String("lenanewlable" + new Date().getTime());

    @BeforeMethod
    public void authorization() {
        pages.loginPage.open();
        pages.loginPage.login();
        wait.until(ExpectedConditions.urlContains("/boards"));
        driver.get("https://trello.com/b/EV6lBD3p/mytestboard");
        pages.boards.createLable(lableName);
    }

    @Test
    public void deleteLable() {
        pages.boards.deleteLable(lableName);
        String boardContent = driver.findElement(By.cssSelector(".board-canvas")).getText();
        Assert.assertFalse(boardContent.contains(lableName));
    }
}
