package trello;

import core.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateDeleteBoard extends BrowserFactory {

    @BeforeMethod
    public void authorization() {
        pages.loginPage.open();
        pages.loginPage.login();
        wait.until(ExpectedConditions.urlContains("/boards"));
    }

    @Test
    public void createPublicBoard() {
        String boardName = pages.boards.createBoard("public");
        Assert.assertTrue(driver.findElement(pages.boards.publicBoardBanner).isDisplayed());
    }

    @Test
    public void createPrivateBoard() {
        String boardName = pages.boards.createBoard("private");
    }
}


