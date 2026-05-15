package com.example.blackbattleship.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.example.blackbattleship.UserStory14;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class (Selenide) para a UserStory14 — Aceder à página Developers.
 * <p>
 * Versão Selenide do teste de acesso à página de Developers
 * do site papergames.io.
 * Reutiliza a Page Object Class {@link UserStory14} da Parte 1.
 * </p>
 *
 * @author TestSuite_122488
 */
@Epic("Batalha Naval Online")
@Feature("US14 — Aceder à página Developers")
@DisplayName("US14 — Testes de acesso à página Developers (Selenide)")
public class UserStory14SelenideTest {

    /** Page Object reutilizado da Parte 1. */
    private UserStory14 page;

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
        Configuration.browserSize = "945x1012";
        Configuration.timeout = 10000;
        open("https://papergames.io/en/");
        page = new UserStory14(getWebDriver());
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
     * Testa o acesso à página de Developers.
     */
    @Test
    @Story("Aceder à página Developers")
    @Description("Verifica que o utilizador consegue aceder à página de " +
            "Developers a partir do rodapé da página principal.")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("US14 - Aceder à página Developers (Selenide)")
    void testAcederDevelopers() {
        page.clicarPrimeiroJogo();
        sleep(2000);

        page.hoverPlayWithFriendIcon();
        sleep(300);
        page.hoverPlayWithFriendText();
        sleep(300);
        page.hoverPlayWithFriendFront();
        sleep(300);
        page.hoverPlaystore();
        sleep(300);
        page.hoverAppstore();
        sleep(300);

        page.scrollParaTopo();
        sleep(500);

        assertTrue(page.developersLinkVisivel(),
                "O link Developers deve estar visível");
        page.clicarDevelopers();
        sleep(2000);

        page.mudarParaNovaJanela();
        sleep(1500);

        String url = page.obterUrlAtual();
        assertTrue(url.contains("developers"),
                "O URL deve conter 'developers' na nova janela");
    }
}