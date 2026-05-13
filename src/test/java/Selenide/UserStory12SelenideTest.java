package Selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class UserStory12SelenideTest {

    @BeforeAll
    static void setup() {

        Configuration.browser = "chrome";

        Configuration.browserSize = "1920x1080";
    }

    @Test
    void testUserStory12() throws InterruptedException {
        open("https://papergames.io/en/");

        // Clicar no Battleship
        $(".game-item:nth-child(1) .img-fluid")
                .shouldBe(visible)
                .click();
        Thread.sleep(2000);

        // Clicar Play vs robot
        $(".w-100:nth-child(2) > .btn .flex-grow-1")
                .shouldBe(visible)
                .click();
        Thread.sleep(2000);

        // Introduzir nome e continuar
        $(".input-xl")
                .shouldBe(visible)
                .setValue("Teste12");
        Thread.sleep(500);

        $(".p-3 > .btn").click();
        Thread.sleep(3000);

        // Clicar Abort game
        $("button.btn:not(.btn-danger)")
                .shouldBe(visible);
        executeJavaScript("document.querySelector('button.btn').click()");
        Thread.sleep(1500);

        // Confirmar no modal — clicar "Abort game" (botão vermelho)
        $(".btn-danger")
                .shouldBe(visible)
                .click();
        Thread.sleep(2000);

        // Navegar para History
        $("a[href*='match-history']")
                .shouldBe(visible)
                .click();
        Thread.sleep(2000);

        // Verificar que chegou à página de histórico
        $("h1, h2").shouldHave(com.codeborne.selenide.Condition.text("History"));
    }
}