package Selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

/**
 * User Story 7
 */
public class UserStory7SelenideTest {

    @BeforeAll
    static void setup() {

        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
    }

    @Test
    void testUserStory7() throws InterruptedException {

        // abrir homepage
        open("https://papergames.io/en/");

        Thread.sleep(3000);

        // abrir Battleship
        $(".game-item:nth-child(1) .img-fluid")
                .shouldBe(visible)
                .click();

        Thread.sleep(3000);

        // clicar em Pricing
        $$("a")
                .findBy(com.codeborne.selenide.Condition.text("Pricing"))
                .shouldBe(visible)
                .click();

        Thread.sleep(5000);
    }
}