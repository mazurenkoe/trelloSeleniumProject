package trello;

import core.BrowserFactory;
import org.testng.annotations.Test;
import trello.api.Api;

import java.io.IOException;

public class BoardTest extends BrowserFactory {

    @Test
    public void tryOt() throws IOException {
        Api api = new Api();
        api.getBoardLists("FOrLmzgD");
        api.createCard("5ce41a3b7636452e41904a48");
    }
}
