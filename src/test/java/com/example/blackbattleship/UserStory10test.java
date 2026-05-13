package com.example.blackbattleship;

import com.example.blackbattleship.UserStory10;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class para a UserStory10 - Participar num campeonato/torneio.
 * <p>
 * Valida que o utilizador consegue aceder e iniciar a participação
 * num torneio/campeonato de Batalha Naval no site papergames.io.
 * </p>
 *
 * @author TestSuite_122457
 */
public class UserStory10test {

    /** Instância do WebDriver partilhada pelos testes. */
    private WebDriver driver;

    /** Page Object utilizado nos testes. */
    private UserStory10 page;

    /**
     * Configuração executada antes de cada teste.
     */
    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        page = new UserStory10(driver);
        page.abrirPagina();
    }

    /**
     * Testa o fluxo de acesso a um torneio/campeonato.
     * <p>
     * Verifica que o utilizador consegue navegar até à secção de torneios
     * e iniciar o processo de participação.
     * </p>
     */
    @Test
    @DisplayName("US10 - Participar num campeonato/torneio")
    public void testParticiparTorneio() throws InterruptedException {
        // Aceder ao primeiro jogo
        page.clicarPrimeiroJogo();
        Thread.sleep(2000);

        // Hover/mouseOut no botão "Play with a friend" (duas vezes, conforme .side)
        page.hoverPlayWithFriend();
        Thread.sleep(500);
        page.mouseOutPlayWithFriend();
        Thread.sleep(500);
        page.hoverPlayWithFriend();
        Thread.sleep(500);
        page.mouseOutPlayWithFriend();
        Thread.sleep(500);

        // Hover no botão secundário (torneio)
        page.hoverBotaoSecundario();
        Thread.sleep(500);

        // Verificar que o botão de torneio está visível
        assertTrue(page.torneioVisivel(),
                "O botão de acesso ao torneio deve estar visível");

        // Clicar para aceder ao torneio
        page.clicarTorneio();
        Thread.sleep(2000);

        // Verificar que o URL mudou para a página de torneio
        String url = page.obterUrlAtual();
        assertFalse(url.equals("https://papergames.io/en/"),
                "O URL deve ter mudado após aceder ao torneio");
    }

    /**
     * Limpeza executada após cada teste.
     */
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}