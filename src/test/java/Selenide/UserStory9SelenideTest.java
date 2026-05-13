package Selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

/**
 * Selenide Test para UserStory9 - Consultar tabela de classificação (leaderboard).
 */
public class UserStory9SelenideTest {

    @BeforeAll
    static void setup() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void testUserStory9() throws InterruptedException {
        open("https://papergames.io/en/");

        // Hover no link Home
        $(".nav-link-active").hover();
        Thread.sleep(500);

        // Clicar no primeiro jogo (Battleship)
        $(".game-item:nth-child(1) .img-fluid")
                .shouldBe(visible)
                .click();
        Thread.sleep(2000);

        // Hover no botão "Play with a friend"
        $(".w-100:nth-child(1) .front")
                .shouldBe(visible)
                .hover();
        Thread.sleep(500);

        // Hover no texto interior
        $(".w-100:nth-child(1) .flex-grow-1").hover();
        Thread.sleep(500);

        // Verificar que o botão de leaderboard está visível e fazer hover
        $(".btn-secondary:nth-child(2)")
                .shouldBe(visible)
                .hover();
        Thread.sleep(1000);
    }
}