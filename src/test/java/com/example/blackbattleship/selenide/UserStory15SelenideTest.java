package com.example.blackbattleship.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.example.blackbattleship.UserStory15;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class (Selenide) para a UserStory15 — Ver formulário de login.
 * <p>
 * Versão Selenide do teste de acesso ao formulário de login
 * do site papergames.io.
 * Reutiliza a Page Object Class {@link UserStory15} da Parte 1.
 * </p>
 *
 * @author TestSuite_122488
 */
@Epic("Batalha Naval Online")
@Feature("US15 — Ver formulário de login")
@DisplayName("US15 — Testes de acesso ao formulário de login (Selenide)")
public class UserStory15SelenideTest {

    /** Page Object reutilizado da Parte 1. */
    private UserStory15 page;

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
        page = new UserStory15(getWebDriver());
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
     * Testa o acesso ao formulário de login.
     */
    @Test
    @Story("Ver formulário de login")
    @Description("Verifica que o utilizador consegue aceder ao formulário " +
            "de login e que os campos de email e password estão disponíveis.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("US15 - Ver formulário de login (Selenide)")
    void testVerFormularioLogin() {
        page.clicarPrimeiroJogo();
        sleep(2000);

        assertTrue(page.loginButtonVisivel(),
                "O botão Login deve estar visível");

        page.clicarLogin();
        sleep(2000);

        assertTrue(page.emailFieldVisivel(),
                "O campo de email deve estar visível no formulário de login");
        assertTrue(page.passwordFieldVisivel(),
                "O campo de password deve estar visível no formulário de login");
    }
}