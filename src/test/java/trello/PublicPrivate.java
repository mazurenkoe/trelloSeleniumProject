package trello;

import core.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PublicPrivate extends BrowserFactory {

    private static WebDriver driverAnonymUser = new ChromeDriver();
    private static WebDriverWait waitAnonymUser = new WebDriverWait(driverAnonymUser, 10);


    @BeforeMethod
    public void authorization() {

        pages.loginPage.open();
        pages.loginPage.login();
        wait.until(ExpectedConditions.urlContains("/boards"));
    }

    @AfterMethod
    public void closeBrowser() {
        driverAnonymUser.close();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void createPublicBoard() {
        pages.boards.createBoard("public");
        String currentUrl = driver.getCurrentUrl();
        driver.close();

        driverAnonymUser.get(currentUrl);
        waitAnonymUser.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".board-header-btn-icon.icon-public")));

        Assert.assertTrue(driverAnonymUser.findElement(By.cssSelector(".icon-public")).isDisplayed());
    }

    @Test
    public void createPrivateBoard() {
        pages.boards.createBoard("private");
        String currentUrl = driver.getCurrentUrl();
        driver.close();

        driverAnonymUser.get(currentUrl);
        waitAnonymUser.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".big-message.quiet")));

        SoftAssert softAsert = new SoftAssert();
        softAsert.assertTrue(driverAnonymUser.findElements(By.cssSelector(".board-main-content")).isEmpty());
        softAsert.assertTrue(driverAnonymUser.findElement(By.cssSelector(".big-message.quiet")).isDisplayed());
        softAsert.assertAll();
    }
}
