package trello;

import core.BrowserFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateBoard extends BrowserFactory {

    @BeforeMethod
    public void authorization() {
        pages.loginPage.open();
        pages.loginPage.login();
        wait.until(ExpectedConditions.urlContains("/boards"));
    }

    @Test
    public void createPublicBoard() {
        String boardName = pages.boards.createBoard("public");
        SoftAssert softAsert=new SoftAssert();
        softAsert.assertTrue(driver.findElement(pages.boards.publicBoardBanner).isDisplayed());
        softAsert.assertTrue(driver.findElement(pages.boards.boardTitle).getText().contains(boardName));
        softAsert.assertAll();
    }

    @Test
    public void createPrivateBoard() {
        String boardName = pages.boards.createBoard("private");
        SoftAssert softAsert=new SoftAssert();
        softAsert.assertTrue(!driver.findElement(pages.boards.publicBoardBanner).isDisplayed());
        softAsert.assertTrue(driver.findElement(pages.boards.boardTitle).getText().contains(boardName));
        softAsert.assertAll();
    }
}


