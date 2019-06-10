package trello.pages;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Random;

import static core.BrowserFactory.driver;
import static core.BrowserFactory.wait;

public class Boards {
    public static By createBoardItem = new By.ByCssSelector(".mod-add");
    public static By publicBoardBanner = new By.ByCssSelector(".logged-in-public-board-banner");

    public String createBoard(String publicBoard) {

        String boardName = generateString("qwertyuiop", 30);

        driver.findElement(createBoardItem).click();
        driver.findElement(By.cssSelector(".subtle-input")).sendKeys("newboard" + boardName);

        if (publicBoard.equals("public")) {
        driver.findElement(By.cssSelector(".subtle-chooser-trigger-dropdown-icon")).click();
        driver.findElement(By.cssSelector(".js-tab-parent>ul li:nth-last-child(1)")).click();
        driver.findElement(By.cssSelector("input.primary[type = 'submit']")).click();
        }

        driver.findElement(By.cssSelector("button.primary[type='submit']")).click();
        wait.until(ExpectedConditions.urlContains(boardName));
        return boardName;
    }

        @NotNull
        @Contract("_, _ -> new")
        private static String generateString(String characters, int length)
        {
            final Random random = new Random();
            char[] text = new char[length];
            for (int i = 0; i < length; i++)
            {
                text[i] = characters.charAt(random.nextInt(characters.length()));
            }
            return new String(text);
        }
}
