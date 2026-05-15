package com.example.blackbattleship;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class para a UserStory16 - Aceder ao servidor de Discord.
 * <p>
 * Esta classe contém os testes JUnit que validam o fluxo de acesso
 * ao servidor de Discord do PaperGames a partir do site papergames.io.
 * </p>
 *
 * @author TestSuite_122488
 */
public class UserStory16Test {

    /** Instância do WebDriver partilhada pelos testes. */
    private WebDriver driver;

    /** Page Object utilizado nos testes. */
    private UserStory16 page;

    /**
     * Configuração executada antes de cada teste.
     * Inicializa o WebDriver e o Page Object.
     */
    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        page = new UserStory16(driver);
        page.abrirPagina();
    }

    /**
     * Testa o acesso ao servidor de Discord do PaperGames.
     * <p>
     * Verifica que o utilizador consegue aceder ao servidor de Discord
     * através do link no rodapé da página, que abre numa nova janela.
     * </p>
     */
    @Test
    @DisplayName("US16 - Aceder ao servidor de Discord")
    public void testAcederDiscord() throws InterruptedException {
        // Clicar no primeiro jogo (Batalha Naval)
        page.clicarPrimeiroJogo();
        Thread.sleep(2000);

        // Scroll para o topo
        page.scrollParaTopo();
        Thread.sleep(500);
        page.scrollParaTopo();
        Thread.sleep(500);

        // Guardar handle da janela original
        String handleOriginal = page.obterHandleJanelaAtual();

        // Clicar no link Discord (abre nova janela)
        assertTrue(page.discordLinkVisivel(),
                "O link Discord deve estar visível");
        page.clicarDiscord();
        Thread.sleep(2000);

        // Mudar para a nova janela
        page.mudarParaNovaJanela();
        Thread.sleep(1500);

        // Verificar que a nova página foi aberta (Discord)
        String url = page.obterUrlAtual();
        assertTrue(url.contains("discord"),
                "O URL deve conter 'discord' na nova janela");

        // Voltar para a janela original
        page.voltarParaJanelaOriginal(handleOriginal);
        Thread.sleep(500);

        // Voltar para a janela do Discord
        page.mudarParaNovaJanela();
        Thread.sleep(500);
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