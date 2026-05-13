package Selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

/**
 * Selenide Test para UserStory11 - Aceder às definições gerais.
 */
public class UserStory11SelenideTest {

    @BeforeAll
    static void setup() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void testUserStory11() throws InterruptedException {
        open("https://papergames.io/en/");

        $(".nav-link-active").shouldBe(visible).hover();
        Thread.sleep(500);

        $("app-header-nav:nth-child(2) .mat-mdc-button-touch-target")
                .shouldBe(visible)
                .hover();
        Thread.sleep(800);

        // Clicar no mesmo seletor, sem depender do .cdk-focused
        $("app-header-nav:nth-child(2) .mat-mdc-button-touch-target")
                .shouldBe(visible)
                .click();
        Thread.sleep(2000);
    }
}