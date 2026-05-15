package com.example.blackbattleship.selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class UserStory5SelenideTest {

    @BeforeAll
    static void setup() {

        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
    }

    @Test
    void testUserStory5() throws InterruptedException {

        // abrir página Battleship
        open("https://papergames.io/en/battleship");

        Thread.sleep(4000);

        // clicar na roda das definições do Play vs Robot
        $(".w-100:nth-child(2) > .btn .mat-mdc-button-touch-target")
                .click();

        Thread.sleep(5000);
    }
}