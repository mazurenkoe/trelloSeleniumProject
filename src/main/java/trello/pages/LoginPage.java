package trello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.BrowserFactory.driver;

public class LoginPage {

    private static By emailFld = By.cssSelector("#user");
    private static By passwordFld = By.cssSelector("#password");
    public static By loginFld = By.cssSelector("#login");
    public static By errorMessage = By.cssSelector("#error.quick-switch");
    public static String defaultEmail = "elena.mazurenko91@gmail.com";
    private static String defaultPass = "Lena10081991";

    public void open() {
        driver.get("https://trello.com/login");
    }

    public void login(String email, String password) {
        submitLoginForm(email, password);
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlToBe("https://trello.com/elena36945786/boards"));
    }

    public void login() {
        login(defaultEmail, defaultPass);
    }

    public void submitLoginForm(String email, String password) {
        driver.findElement(emailFld).clear();
        driver.findElement(emailFld).sendKeys(email);
        driver.findElement(passwordFld).clear();
        driver.findElement(passwordFld).sendKeys(password);
        driver.findElement(loginFld).click();
    }
}
