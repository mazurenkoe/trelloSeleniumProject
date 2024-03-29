package trello.pages;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Random;

import static core.BrowserFactory.driver;
import static core.BrowserFactory.wait;
import static trello.pages.Cards.*;
import static trello.pages.Header.homeIcon;

public class Boards {
    public static By createBoardItem = new By.ByCssSelector(".mod-add");
    public static By publicBoardBanner = new By.ByCssSelector(".logged-in-public-board-banner");
    public static By boardTitle = new By.ByCssSelector(".js-board-editing-target");
    public static By createListItem = new By.ByCssSelector(".js-add-another-card");
    public static By createListFld = new By.ByCssSelector(".list-card-composer-textarea");
    public static By createListBtn = new By.ByCssSelector(".confirm[type = 'submit']");

    public String createBoard(String boardType) {

        String boardName = "newboard" + generateString("qwertyuiop", 30);

        driver.findElement(createBoardItem).click();
        driver.findElement(By.cssSelector(".subtle-input")).sendKeys(boardName);

        if (boardType.equals("public")) {
            driver.findElement(By.cssSelector(".subtle-chooser-trigger-dropdown-icon")).click();
            driver.findElement(By.cssSelector(".js-tab-parent>ul li:nth-last-child(1)")).click();
            driver.findElement(By.cssSelector("input.primary[type = 'submit']")).click();
        }

        driver.findElement(By.cssSelector("button.primary[type='submit']")).click();
        wait.until(ExpectedConditions.urlContains(boardName));
        return boardName;
    }

    public void deleteBoard(String boardName) {
        driver.findElement(homeIcon).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[title = '" + boardName + "']")));
        driver.findElement(By.cssSelector("div[title = '" + boardName + "']")).click();
        driver.findElement(By.cssSelector(".icon-back")).click();

        driver.findElement(By.cssSelector(".js-open-more")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".js-close-board")));
        driver.findElement(By.cssSelector(".js-close-board")).click();
        driver.findElement(By.cssSelector(".js-confirm")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".delete-container")));
        driver.findElement(By.cssSelector(".delete-container")).click();
        driver.findElement(By.cssSelector(".js-confirm")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".js-reopen")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".big-message")));

    }

    public void createLable(String lableName){
        driver.findElement(createListItem).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(createListFld));

        driver.findElement(createListFld).sendKeys(lableName);
        driver.findElement(createListBtn).click();
    }

    public void openCard(String lableName){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href*='"+lableName+"']")));
        driver.findElement(By.cssSelector("a[href*='"+lableName+"']")).click();
    }
    public void deleteLable(String lableName) {
        openCard(lableName);
        driver.findElement(archiveBtn).click();
        driver.findElement(deleteBtn).click();
        driver.findElement(confirmBtn).click();
    }

    public void renameLable(String lableName, String lableNewName) {
        openCard(lableName);
        driver.findElement(lableTitleFld).click();
        driver.findElement(lableTitleFld).clear();
        driver.findElement(lableTitleFld).sendKeys(lableNewName);
        driver.findElement(lableTitleFld).sendKeys(Keys.ENTER);
    }

    @NotNull
    @Contract("_, _ -> new")
    private static String generateString(String characters, int length) {
        final Random random = new Random();
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(random.nextInt(characters.length()));
        }
        return new String(text);
    }
}
