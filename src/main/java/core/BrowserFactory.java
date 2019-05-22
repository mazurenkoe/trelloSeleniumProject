package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import trello.pages.Pages;

public class BrowserFactory {

    public static WebDriver driver;

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
