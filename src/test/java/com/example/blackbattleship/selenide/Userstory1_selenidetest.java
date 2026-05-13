package com.example.blackbattleship.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.example.blackbattleship.UserStory1;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class (Selenide) para a UserStory1 — Criar Nickname.
 * <p>
 * Versão Selenide do teste de criação de nickname como visitante
 * na página de Batalha Naval do site papergames.io.
 * Reutiliza a Page Object Class {@link UserStory1} da Parte 1.
 * </p>
 *
 * @author TestSuite_122478
 */
@Epic("Batalha Naval Online")
@Feature("US01 — Criar Nickname")
@DisplayName("US01 — Testes de criação de nickname (Selenide)")
public class Userstory1_selenidetest {

    /** Page Object reutilizado da Parte 1. */
    private UserStory1 page;

    /**
     * Configuração inicial antes de todos os testes.
     * Regista o listener do Allure para capturar passos do Selenide.
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
     * Define o browser, tamanho da janela e instancia a page object.
     */
    @BeforeEach
    void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        open("https://papergames.io/en/battleship");
        page = new UserStory1(getWebDriver());
        page.definirTamanhoJanela();
    }

    /**
     * Limpeza após cada teste.
     * Fecha o browser.
     */
    @AfterEach
    void tearDown() {
        closeWebDriver();
    }

    /**
     * Limpeza após todos os testes.
     * Remove o listener do Allure.
     */
    @AfterAll
    static void tearDownAllure() {
        SelenideLogger.removeListener("AllureSelenide");
    }

    /**
     * Testa o fluxo completo de criação de nickname.
     * <p>
     * Verifica que um utilizador consegue clicar em "Play",
     * preencher o nickname e confirmar com "Continue".
     * </p>
     */
    @Test
    @Story("Criar nickname como visitante")
    @Description("Verifica que um visitante consegue criar um nickname " +
            "preenchendo o campo e clicando em Continue.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("US1 - Criar Nickname como utilizador convidado (Selenide)")
    void testCriarNickname() {
        // Hover nos itens de navegação
        page.hoverHome();
        sleep(500);
        page.hoverShop();
        sleep(500);

        // Clicar em Play
        page.clicarPlay();
        sleep(1500);

        // Verificar que o campo de nickname aparece
        assertTrue(page.continueButtonVisivel(),
                "O botão Continue deve estar visível após clicar em Play");

        // Preencher nickname e continuar
        page.preencherNickname("Goncalo");
        sleep(500);
        page.clicarContinue();
        sleep(2000);
    }
}
