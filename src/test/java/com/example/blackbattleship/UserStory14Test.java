package com.example.blackbattleship;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class para a UserStory14 - Aceder à página Developers.
 * <p>
 * Esta classe contém os testes JUnit que validam o fluxo de acesso
 * à página de Developers do site papergames.io, que abre numa
 * nova janela do browser.
 * </p>
 *
 * @author TestSuite_122488
 */
public class UserStory14Test {

    /** Instância do WebDriver partilhada pelos testes. */
    private WebDriver driver;

    /** Page Object utilizado nos testes. */
    private UserStory14 page;

    /**
     * Configuração executada antes de cada teste.
     * Inicializa o WebDriver e o Page Object.
     */
    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        page = new UserStory14(driver);
        page.abrirPagina();
        page.definirTamanhoJanela(945, 1012);
    }

    /**
     * Testa o acesso à página de Developers.
     * <p>
     * Verifica que o utilizador consegue navegar até à página
     * Developers a partir do rodapé da página principal.
     * </p>
     */
    @Test
    @DisplayName("US14 - Aceder à página Developers")
    public void testAcederDevelopers() throws InterruptedException {
        // Clicar no primeiro jogo (Batalha Naval)
        page.clicarPrimeiroJogo();
        Thread.sleep(2000);

        // Hover nos elementos de navegação
        page.hoverPlayWithFriendIcon();
        Thread.sleep(300);
        page.hoverPlayWithFriendText();
        Thread.sleep(300);
        page.hoverPlayWithFriendFront();
        Thread.sleep(300);
        page.hoverPlaystore();
        Thread.sleep(300);
        page.hoverAppstore();
        Thread.sleep(300);

        // Scroll para o topo
        page.scrollParaTopo();
        Thread.sleep(500);

        // Clicar em Developers (abre nova janela)
        assertTrue(page.developersLinkVisivel(),
                "O link Developers deve estar visível");
        page.clicarDevelopers();
        Thread.sleep(2000);

        // Mudar para a nova janela
        page.mudarParaNovaJanela();
        Thread.sleep(1500);

        // Verificar que a nova página foi aberta
        String url = page.obterUrlAtual();
        assertTrue(url.contains("developers"),
                "O URL deve conter 'developers' na nova janela");
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