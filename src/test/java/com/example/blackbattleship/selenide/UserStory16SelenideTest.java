package com.example.blackbattleship.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.example.blackbattleship.UserStory16;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class (Selenide) para a UserStory16 — Aceder ao servidor de Discord.
 * <p>
 * Versão Selenide do teste de acesso ao servidor de Discord
 * do PaperGames a partir do site papergames.io.
 * Reutiliza a Page Object Class {@link UserStory16} da Parte 1.
 * </p>
 *
 * @author TestSuite_122488
 */
@Epic("Batalha Naval Online")
@Feature("US16 — Aceder ao servidor de Discord")
@DisplayName("US16 — Testes de acesso ao servidor de Discord (Selenide)")
public class UserStory16SelenideTest {

    /** Page Object reutilizado da Parte 1. */
    private UserStory16 page;

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
        page = new UserStory16(getWebDriver());
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
     * Testa o acesso ao servidor de Discord do PaperGames.
     */
    @Test
    @Story("Aceder ao servidor de Discord")
    @Description("Verifica que o utilizador consegue aceder ao servidor de " +
            "Discord do PaperGames através do link no rodapé.")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("US16 - Aceder ao servidor de Discord (Selenide)")
    void testAcederDiscord() {
        page.clicarPrimeiroJogo();
        sleep(2000);

        page.scrollParaTopo();
        sleep(500);
        page.scrollParaTopo();
        sleep(500);

        String handleOriginal = page.obterHandleJanelaAtual();

        assertTrue(page.discordLinkVisivel(),
                "O link Discord deve estar visível");
        page.clicarDiscord();
        sleep(2000);

        page.mudarParaNovaJanela();
        sleep(1500);

        String url = page.obterUrlAtual();
        assertTrue(url.contains("discord"),
                "O URL deve conter 'discord' na nova janela");

        page.voltarParaJanelaOriginal(handleOriginal);
        sleep(500);

        page.mudarParaNovaJanela();
        sleep(500);
    }
}