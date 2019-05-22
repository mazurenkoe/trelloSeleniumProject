package trello;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.BrowserFactory.driver;

public class LoginPage {

    private By emailFld = By.cssSelector("#user");
    private By passwordFld = By.cssSelector("#password");
    private By loginFld = By.cssSelector("#login");


    public void open() {
        driver.get("https://trello.com/login");
    }

    public void login(String email, String password) {
        driver.findElement(emailFld).clear();
        driver.findElement(emailFld).sendKeys(email);
        driver.findElement(passwordFld).clear();
        driver.findElement(passwordFld).sendKeys(password);
        driver.findElement(loginFld).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlToBe("https://trello.com/elena36945786/boards"));
    }
}
