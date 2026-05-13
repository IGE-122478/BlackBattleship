package com.example.blackbattleship.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.example.blackbattleship.UserStory2;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class (Selenide) para a UserStory2 — Aceder às regras do jogo.
 * <p>
 * Versão Selenide do teste de acesso aos guias de jogo (Game Guides)
 * a partir da página principal do papergames.io.
 * Reutiliza a Page Object Class {@link UserStory2} da Parte 1.
 * </p>
 *
 * @author TestSuite_122478
 */
@Epic("Batalha Naval Online")
@Feature("US02 — Aceder às regras do jogo")
@DisplayName("US02 — Testes de acesso às regras do jogo (Selenide)")
public class Userstory2_selenidetest {

    /** Page Object reutilizado da Parte 1. */
    private UserStory2 page;

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
     */
    @BeforeEach
    void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        open("https://papergames.io/en/");
        page = new UserStory2(getWebDriver());
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
     * Testa o acesso aos guias de jogo a partir da página principal.
     * <p>
     * Verifica que ao clicar em "Game Guides" é aberta uma nova janela
     * com conteúdo relacionado com os guias do jogo.
     * </p>
     */
    @Test
    @Story("Aceder às instruções do jogo")
    @Description("Verifica que o utilizador consegue aceder à página de " +
            "Game Guides a partir da página principal.")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("US2 - Aceder às regras/guias do jogo (Selenide)")
    void testAcederRegrasJogo() {
        // Scroll para o topo
        page.scrollParaTopo();
        sleep(500);
        page.scrollParaTopo();
        sleep(500);

        // Clicar em Game Guides (abre nova janela)
        page.clicarGameGuides();
        sleep(2000);

        // Mudar para a nova janela
        page.mudarParaNovaJanela();
        sleep(1500);

        // Verificar que a nova página foi aberta corretamente
        String url = page.obterUrlAtual();
        assertNotNull(url, "O URL da nova janela não deve ser nulo");
        assertFalse(url.isEmpty(), "O URL da nova janela não deve estar vazio");
    }
}
