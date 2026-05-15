package com.example.blackbattleship.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.example.blackbattleship.UserStory13;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class (Selenide) para a UserStory13 — Aceder aos Termos e Condições.
 * <p>
 * Versão Selenide do teste de acesso à página de Termos e Condições
 * do site papergames.io.
 * Reutiliza a Page Object Class {@link UserStory13} da Parte 1.
 * </p>
 *
 * @author TestSuite_122488
 */
@Epic("Batalha Naval Online")
@Feature("US13 — Aceder aos Termos e Condições")
@DisplayName("US13 — Testes de acesso aos Termos e Condições (Selenide)")
public class UserStory13SelenideTest {

    /** Page Object reutilizado da Parte 1. */
    private UserStory13 page;

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
        page = new UserStory13(getWebDriver());
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
     * Testa o acesso à página de Termos e Condições.
     */
    @Test
    @Story("Aceder aos Termos e Condições")
    @Description("Verifica que o utilizador consegue aceder à página de " +
            "Termos e Condições a partir da página principal.")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("US13 - Aceder aos Termos e Condições (Selenide)")
    void testAcederTermsAndConditions() {
        page.hoverSegundoJogo();
        sleep(500);

        page.clicarPrimeiroJogo();
        sleep(2000);

        page.scrollParaTopo();
        sleep(500);

        assertTrue(page.termsLinkVisivel(),
                "O link Terms & conditions deve estar visível");
        page.clicarTermsAndConditions();
        sleep(2000);

        String url = page.obterUrlAtual();
        assertTrue(url.contains("terms"),
                "O URL deve conter 'terms' após clicar no link");
    }
}