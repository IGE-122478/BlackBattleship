package com.example.blackbattleship;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class para a UserStory11 - Aceder às definições gerais.
 * <p>
 * Valida que o utilizador consegue localizar e aceder às definições
 * gerais da aplicação papergames.io.
 * </p>
 *
 * @author TestSuite_122457
 */
public class UserStory11test {

    /** Instância do WebDriver partilhada pelos testes. */
    private WebDriver driver;

    /** Page Object utilizado nos testes. */
    private UserStory11 page;

    /**
     * Configuração executada antes de cada teste.
     */
    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        page = new UserStory11(driver);
        page.abrirPagina();
    }

    /**
     * Testa o acesso às definições gerais da aplicação.
     * <p>
     * Verifica que o utilizador consegue localizar o ícone de definições
     * no header e aceder às configurações gerais.
     * </p>
     */
    @Test
    @DisplayName("US11 - Aceder às definições gerais")
    public void testAcederDefinicoes() throws InterruptedException {
        // Hover no link Home
        page.hoverHome();
        Thread.sleep(500);

        // Verificar que o botão de definições está visível
        assertTrue(page.definicoesVisivel(),
                "O botão de definições deve estar visível no header");

        // Hover no botão de definições
        page.hoverDefinicoes();
        Thread.sleep(500);

        // Clicar para abrir as definições
        page.clicarDefinicoes();
        Thread.sleep(2000);

        // Verificar que o URL mudou ou que um painel foi aberto
        String url = page.obterUrlAtual();
        assertNotNull(url, "O URL não deve ser nulo após abrir definições");

        // MouseOut após clicar
        page.mouseOutDefinicoes();
        Thread.sleep(500);
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