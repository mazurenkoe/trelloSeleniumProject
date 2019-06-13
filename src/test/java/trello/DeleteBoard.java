package trello;

import core.BrowserFactory;
import org.openqa.selenium.By;
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
    public void deletePublicBoard() throws InterruptedException {
        String boardName = pages.boards.createBoard("public");
        pages.boards.deleteBoard(boardName);
        wait.until(ExpectedConditions.elementToBeClickable(pages.header.homeIcon));
        driver.get("https://trello.com/");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".content-all-boards")));
        String alltitles = driver.findElement(By.cssSelector(".content-all-boards")).getText();
        Assert.assertFalse(alltitles.contains(boardName));
    }

    @Test
    public void deletePrivateBoard() {
        String boardName = pages.boards.createBoard("private");
        pages.boards.deleteBoard(boardName);
        wait.until(ExpectedConditions.elementToBeClickable(pages.header.homeIcon));
        driver.get("https://trello.com/");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".content-all-boards")));
        String alltitles = driver.findElement(By.cssSelector(".content-all-boards")).getText();
        Assert.assertFalse(alltitles.contains(boardName));
    }
}
