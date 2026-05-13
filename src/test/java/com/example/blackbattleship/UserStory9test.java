package com.example.blackbattleship;

import com.example.blackbattleship.UserStory9;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class para a UserStory9 - Consultar tabela de classificação (leaderboard).
 * <p>
 * Valida que o utilizador consegue navegar até à secção de leaderboard
 * da Batalha Naval no site papergames.io.
 * </p>
 *
 * @author TestSuite_122457
 */
public class UserStory9test {

    /** Instância do WebDriver partilhada pelos testes. */
    private WebDriver driver;

    /** Page Object utilizado nos testes. */
    private UserStory9 page;

    /**
     * Configuração executada antes de cada teste.
     * Inicializa o WebDriver e o Page Object e abre a página.
     */
    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        page = new UserStory9(driver);
        page.abrirPagina();
    }

    /**
     * Testa a navegação até ao leaderboard da Batalha Naval.
     * <p>
     * Verifica que o utilizador consegue interagir com a navegação,
     * aceder ao jogo e visualizar o botão de leaderboard/classificação.
     * </p>
     */
    @Test
    @DisplayName("US9 - Consultar tabela de classificação (leaderboard)")
    public void testConsultarLeaderboard() throws InterruptedException {
        // Hover e mouseOut no link Home
        page.hoverHome();
        Thread.sleep(500);
        page.mouseOutHome();
        Thread.sleep(500);

        // Clicar no primeiro jogo (Battleship)
        page.clicarPrimeiroJogo();
        Thread.sleep(2000);

        // Hover/mouseOut no botão "Play with a friend"
        page.hoverPlayWithFriend();
        Thread.sleep(500);
        page.mouseOutPlayWithFriend();
        Thread.sleep(500);

        // Hover/mouseOut no texto interior do botão
        page.hoverPlayWithFriendText();
        Thread.sleep(500);
        page.mouseOutPlayWithFriendText();
        Thread.sleep(500);

        // Verificar que o botão de leaderboard está visível
        assertTrue(page.leaderboardVisivel(),
                "O botão de leaderboard deve estar visível na página do jogo");

        // Hover no botão de leaderboard
        page.hoverBotaoSecundario();
        Thread.sleep(1000);

        // Confirmar que continuamos na página do jogo
        String url = page.obterUrlAtual();
        assertTrue(url.contains("papergames.io"),
                "Deve continuar no site papergames.io");
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