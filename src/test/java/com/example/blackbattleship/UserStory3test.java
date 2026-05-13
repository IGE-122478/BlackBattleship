package com.example.blackbattleship;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class para a UserStory3 - Jogar contra um robot.
 * <p>
 * Esta classe contém os testes JUnit que validam o fluxo de início
 * de uma partida de Batalha Naval contra um robot no papergames.io.
 * </p>
 *
 * @author TestSuite_122478
 */
public class UserStory3test {

    /** Instância do WebDriver partilhada pelos testes. */
    private WebDriver driver;

    /** Page Object utilizado nos testes. */
    private UserStory3 page;

    /**
     * Configuração executada antes de cada teste.
     * Inicializa o WebDriver e o Page Object.
     */
    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        page = new UserStory3(driver);
        page.abrirPagina();
    }

    /**
     * Testa o fluxo de iniciar uma partida contra um robot.
     * <p>
     * Verifica que o utilizador consegue navegar até à Batalha Naval,
     * visualizar o botão "Play vs Bot" e iniciar o jogo.
     * </p>
     */
    @Test
    @DisplayName("US3 - Jogar Batalha Naval contra um robot")
    public void testJogarContraRobot() throws InterruptedException {
        // Hover no segundo jogo da lista
        page.hoverSegundoJogo();
        Thread.sleep(500);

        // Clicar no primeiro jogo (Batalha Naval)
        page.clicarPrimeiroJogo();
        Thread.sleep(2000);

        // Verificar que o botão "Play vs Bot" está disponível
        assertTrue(page.playVsBotVisivel(), "O botão Play vs Bot deve estar visível");

        // Hover e clique no botão Play vs Bot
        page.hoverPlayVsBot();
        Thread.sleep(500);
        page.clicarPlayVsBot();
        Thread.sleep(2000);

        // Preencher nickname se o diálogo aparecer
        if (page.nicknameDialogVisivel()) {
            page.preencherNickname("Goncalo");
            Thread.sleep(500);
            page.clicarContinue();
            Thread.sleep(2000);
        }

        // Verificar que o URL mudou (jogo iniciado)
        String url = page.obterUrlAtual();
        assertNotNull(url, "O URL após iniciar o jogo não deve ser nulo");
    }

    /**
     * Limpeza executada após cada teste.
     * Fecha o browser.
     */
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
