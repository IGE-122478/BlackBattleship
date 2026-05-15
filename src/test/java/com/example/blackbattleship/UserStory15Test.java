package com.example.blackbattleship;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class para a UserStory15 - Ver formulário de login.
 * <p>
 * Esta classe contém os testes JUnit que validam o fluxo de acesso
 * ao formulário de login com os campos de email e password
 * no site papergames.io.
 * </p>
 *
 * @author TestSuite_122488
 */
public class UserStory15Test {

    /** Instância do WebDriver partilhada pelos testes. */
    private WebDriver driver;

    /** Page Object utilizado nos testes. */
    private UserStory15 page;

    /**
     * Configuração executada antes de cada teste.
     * Inicializa o WebDriver e o Page Object.
     */
    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        page = new UserStory15(driver);
        page.abrirPagina();
        page.definirTamanhoJanela(945, 1012);
    }

    /**
     * Testa o acesso ao formulário de login.
     * <p>
     * Verifica que o utilizador consegue aceder ao formulário de login
     * e que os campos de email e password estão disponíveis.
     * </p>
     */
    @Test
    @DisplayName("US15 - Ver formulário de login")
    public void testVerFormularioLogin() throws InterruptedException {
        // Clicar no primeiro jogo (Batalha Naval)
        page.clicarPrimeiroJogo();
        Thread.sleep(2000);

        // Verificar que o botão Login está visível
        assertTrue(page.loginButtonVisivel(),
                "O botão Login deve estar visível");

        // Clicar no botão Login
        page.clicarLogin();
        Thread.sleep(2000);

        // Verificar que os campos de email e password estão presentes
        assertTrue(page.emailFieldVisivel(),
                "O campo de email deve estar visível no formulário de login");
        assertTrue(page.passwordFieldVisivel(),
                "O campo de password deve estar visível no formulário de login");
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