package com.example.blackbattleship.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.example.blackbattleship.UserStory4;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class (Selenide) para a UserStory4 — Gerar link para jogar com um amigo.
 * <p>
 * Versão Selenide do teste de criação de um link de convite para jogar
 * Batalha Naval com outro utilizador no papergames.io.
 * Reutiliza a Page Object Class {@link UserStory4} da Parte 1.
 * </p>
 *
 * @author TestSuite_122478
 */
@Epic("Batalha Naval Online")
@Feature("US04 — Gerar link para jogar com amigo")
@DisplayName("US04 — Testes de criação de link de convite (Selenide)")
public class Userstory4_selenidetest {

    /** Page Object reutilizado da Parte 1. */
    private UserStory4 page;

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
        page = new UserStory4(getWebDriver());
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
     * Testa o fluxo de geração de link para jogar com um amigo.
     * <p>
     * Verifica que o utilizador consegue aceder à Batalha Naval,
     * visualizar o botão "Play with a Friend" e iniciar o processo
     * de criação de um link de convite, incluindo o preenchimento
     * do nickname caso o diálogo apareça.
     * </p>
     */
    @Test
    @Story("Gerar link de convite")
    @Description("Verifica que o utilizador consegue gerar um link de convite " +
            "para jogar com um amigo a partir da página do jogo.")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("US4 - Gerar link para jogar com um amigo (Selenide)")
    void testGerarLinkParaAmigo() {
        // Clicar no primeiro jogo (Batalha Naval)
        page.clicarPrimeiroJogo();
        sleep(2000);

        // Verificar que o botão "Play with a Friend" está disponível
        assertTrue(page.playWithFriendVisivel(),
                "O botão Play with a Friend deve estar visível");

        // Hover nos dois botões de ação
        page.hoverPlayVsBot();
        sleep(500);
        page.hoverPlayWithFriend();
        sleep(500);

        // Clicar em "Play with a Friend"
        page.clicarPlayWithFriend();
        sleep(2000);

        // Preencher nickname se o diálogo aparecer
        if (page.nicknameDialogVisivel()) {
            page.preencherNickname("Goncalo");
            sleep(500);
            page.clicarContinue();
            sleep(2000);
        }

        // Verificar que o URL mudou (link de convite gerado)
        String url = page.obterUrlAtual();
        assertNotNull(url, "O URL após criar o link não deve ser nulo");
        assertFalse(url.equals("https://papergames.io/en/"),
                "O URL deve ter mudado após clicar em Play with a Friend");
    }
}
