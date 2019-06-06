package trello;

import core.BrowserFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateDeleteBoard extends BrowserFactory {

    @BeforeMethod
    public void authorization() {
        pages.loginPage.open();
        pages.loginPage.login();
    }

    @Test
    public void createBoard() {

    }
}


