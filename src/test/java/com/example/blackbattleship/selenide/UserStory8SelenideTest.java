package com.example.blackbattleship.selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

/**
 * User Story 8
 */
public class UserStory8SelenideTest {

    @BeforeAll
    static void setup() {

        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
    }

    @Test
    void testUserStory8() throws InterruptedException {

        // abrir homepage
        open("https://papergames.io/en/");

        Thread.sleep(3000);

        // aceitar cookies se aparecer
        try {

            $(".fc-button.fc-cta-consent")
                    .shouldBe(visible)
                    .click();

            Thread.sleep(2000);

        } catch (Exception ignored) {

        }

        // abrir Battleship
        $(".game-item:nth-child(1) .img-fluid")
                .shouldBe(visible)
                .click();

        Thread.sleep(3000);

        // clicar em Goodies
        $$("a")
                .findBy(com.codeborne.selenide.Condition.text("Goodies"))
                .shouldBe(visible)
                .click();

        Thread.sleep(5000);
    }
}