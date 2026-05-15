package com.example.blackbattleship;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class para a UserStory13 - Aceder aos Termos e Condições.
 * <p>
 * Esta classe contém os testes JUnit que validam o fluxo de acesso
 * à página de Termos e Condições do site papergames.io.
 * </p>
 *
 * @author TestSuite_122488
 */
public class UserStory13Test {

    /** Instância do WebDriver partilhada pelos testes. */
    private WebDriver driver;

    /** Page Object utilizado nos testes. */
    private UserStory13 page;

    /**
     * Configuração executada antes de cada teste.
     * Inicializa o WebDriver e o Page Object.
     */
    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        page = new UserStory13(driver);
        page.abrirPagina();
        page.definirTamanhoJanela(945, 1012);
    }

    /**
     * Testa o acesso à página de Termos e Condições.
     * <p>
     * Verifica que o utilizador consegue navegar até à página de
     * Termos e Condições a partir da página principal.
     * </p>
     */
    @Test
    @DisplayName("US13 - Aceder aos Termos e Condições")
    public void testAcederTermsAndConditions() throws InterruptedException {
        // Hover no segundo jogo
        page.hoverSegundoJogo();
        Thread.sleep(500);

        // Clicar no primeiro jogo (Batalha Naval)
        page.clicarPrimeiroJogo();
        Thread.sleep(2000);

        // Scroll para o topo
        page.scrollParaTopo();
        Thread.sleep(500);

        // Clicar em Terms & conditions
        assertTrue(page.termsLinkVisivel(),
                "O link Terms & conditions deve estar visível");
        page.clicarTermsAndConditions();
        Thread.sleep(2000);

        // Verificar que o URL mudou para a página de termos
        String url = page.obterUrlAtual();
        assertTrue(url.contains("terms"),
                "O URL deve conter 'terms' após clicar no link");
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