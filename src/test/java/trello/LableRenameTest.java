package trello;

import core.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Date;

public class LableRenameTest extends BrowserFactory {

    String lableName = new String("lenanewlable" + new Date().getTime());
    String lableRenamedName = new String("renamedlenanewlable" + new Date().getTime());
    
    @BeforeMethod
    public void authorization() {
        pages.loginPage.open();
        pages.loginPage.login();
        wait.until(ExpectedConditions.urlContains("/boards"));
        driver.get("https://trello.com/b/EV6lBD3p/mytestboard");
        pages.boards.createLable(lableName);
    }

    @Test
    public void renameLable() {
        pages.boards.renameLable(lableName, lableRenamedName);
        driver.findElement(By.cssSelector(".dialog-close-button")).click();

        String boardContent = driver.findElement(By.cssSelector(".board-canvas")).getText();
        SoftAssert softAsert=new SoftAssert();
        Assert.assertFalse(boardContent.contains(lableName));
        Assert.assertTrue(boardContent.contains(lableRenamedName));
        softAsert.assertAll();
    }
}