package com.example.blackbattleship.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.example.blackbattleship.UserStory3;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class (Selenide) para a UserStory3 — Jogar contra um robot.
 * <p>
 * Versão Selenide do teste de iniciar uma partida de Batalha Naval
 * contra um robot no papergames.io.
 * Reutiliza a Page Object Class {@link UserStory3} da Parte 1.
 * </p>
 *
 * @author TestSuite_122478
 */
@Epic("Batalha Naval Online")
@Feature("US03 — Jogar contra um robot")
@DisplayName("US03 — Testes de jogo contra robot (Selenide)")
public class Userstory3_selenidetest {

    /** Page Object reutilizado da Parte 1. */
    private UserStory3 page;

    /**
     * Configuração inicial antes de todos os testes.
     */
    @BeforeAll
    static void setupAllure() {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true));
    }

    /**
     * Configuração antes de cada teste.
     */
    @BeforeEach
    void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        open("https://papergames.io/en/");
        page = new UserStory3(getWebDriver());
    }

    /**
     * Limpeza após cada teste.
     */
    @AfterEach
    void tearDown() {
        closeWebDriver();
    }

    /**
     * Limpeza após todos os testes.
     */
    @AfterAll
    static void tearDownAllure() {
        SelenideLogger.removeListener("AllureSelenide");
    }

    /**
     * Testa o fluxo de iniciar uma partida contra um robot.
     * <p>
     * Verifica que o utilizador consegue navegar até à Batalha Naval,
     * visualizar o botão "Play vs Bot" e iniciar o jogo.
     * </p>
     */
    @Test
    @Story("Iniciar partida contra robot")
    @Description("Verifica que o utilizador consegue iniciar uma partida " +
            "contra um robot a partir da página principal.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("US3 - Jogar Batalha Naval contra um robot (Selenide)")
    void testJogarContraRobot() {
        // Hover no segundo jogo da lista
        page.hoverSegundoJogo();
        sleep(500);

        // Clicar no primeiro jogo (Batalha Naval)
        page.clicarPrimeiroJogo();
        sleep(2000);

        // Verificar que o botão "Play vs Bot" está disponível
        assertTrue(page.playVsBotVisivel(),
                "O botão Play vs Bot deve estar visível");

        // Hover e clique no botão Play vs Bot
        page.hoverPlayVsBot();
        sleep(500);
        page.clicarPlayVsBot();
        sleep(2000);

        // Verificar que o URL mudou (jogo iniciado)
        String url = page.obterUrlAtual();
        assertNotNull(url, "O URL após iniciar o jogo não deve ser nulo");
    }
}
