package trello;

import core.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteBoard extends BrowserFactory {
    @BeforeMethod
    public void authorization() {
        pages.loginPage.open();
        pages.loginPage.login();
        wait.until(ExpectedConditions.urlContains("/boards"));
    }

    @Test
    public void deletePublicBoard() {
        String boardName = pages.boards.createBoard("public");
        pages.boards.deleteBoard(boardName);
        wait.until(ExpectedConditions.elementToBeClickable(pages.header.homeIcon));
        driver.findElement(pages.header.homeIcon).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".content-all-boards")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".board-tile-details div [title]")));
        Assert.assertTrue(!driver.findElement(By.cssSelector(".board-tile-details div[title = '" + boardName + "']")).isDisplayed());
    }

    @Test
    public void deletePrivateBoard() {
        String boardName = pages.boards.createBoard("private");
        pages.boards.deleteBoard(boardName);

        driver.findElement(pages.header.homeIcon).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".content-all-boards")));
        Assert.assertTrue(!driver.findElement(By.cssSelector("div[title = '" + boardName + "']")).isDisplayed());
    }
}
