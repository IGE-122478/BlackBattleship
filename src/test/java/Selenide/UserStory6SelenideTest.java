package Selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

/**
 * User Story 6
 * Como utilizador, quero aceder à loja para comprar artigos virtuais.
 */
public class UserStory6SelenideTest {

    @BeforeAll
    static void setup() {

        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
    }

    @Test
    void testUserStory6() throws InterruptedException {

        // abrir homepage
        open("https://papergames.io/en/");

        Thread.sleep(3000);

        // abrir Battleship
        $(".game-item:nth-child(1) .text-light")
                .shouldBe(visible)
                .click();

        Thread.sleep(3000);

        // clicar em Shop
        $("a[href='/en/shop']")
                .shouldBe(visible)
                .click();

        Thread.sleep(5000);
    }
}