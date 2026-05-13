package Selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

/**
 * Selenide Test para UserStory10 - Participar num campeonato/torneio.
 */
public class UserStory10SelenideTest {

    @BeforeAll
    static void setup() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @Test

    void testUserStory10() throws InterruptedException {
        open("https://papergames.io/en/");

        $(".game-item:nth-child(1) .img-fluid")
                .shouldBe(visible)
                .click();
        Thread.sleep(2000);

        $(".w-100:nth-child(1) .front").shouldBe(visible).hover();
        Thread.sleep(500);
        $(".w-100:nth-child(1) .front").hover();
        Thread.sleep(500);

        $(".btn-secondary:nth-child(2)").shouldBe(visible).hover();
        Thread.sleep(500);

        $(".position-relative > .front")
                .shouldBe(visible)
                .click();
        Thread.sleep(2000);
    }
}