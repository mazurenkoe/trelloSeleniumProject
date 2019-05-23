package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import trello.pages.Pages;

public class BrowserFactory {

    public static WebDriver driver;
    public static WebDriverWait wait = new WebDriverWait(driver, 15);

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
    }
    public Pages pages = new Pages();

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
