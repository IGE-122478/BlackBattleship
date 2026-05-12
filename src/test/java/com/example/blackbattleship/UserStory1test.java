package com.example.blackbattleship;


import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class para a UserStory1 - Criar Nickname.
 * <p>
 * Esta classe contém os testes JUnit que validam o fluxo de criação
 * de nickname de um utilizador convidado no site papergames.io.
 * </p>
 *
 * @author TestSuite_122478
 */
public class UserStory1test {

    /** Instância do WebDriver partilhada pelos testes. */
    private WebDriver driver;

    /** Page Object utilizado nos testes. */
    private UserStory1 page;

    /**
     * Configuração executada antes de cada teste.
     * Inicializa o WebDriver e o Page Object.
     */
    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        page = new UserStory1(driver);
        page.abrirPagina();
        page.definirTamanhoJanela();
    }

    /**
     * Testa o fluxo completo de criação de nickname.
     * <p>
     * Verifica que um utilizador consegue clicar em "Play",
     * preencher o nickname e confirmar com "Continue".
     * </p>
     */
    @Test
    @DisplayName("US1 - Criar Nickname como utilizador convidado")
    public void testCriarNickname() throws InterruptedException {
        // Hover nos itens de navegação
        page.hoverHome();
        Thread.sleep(500);
        page.hoverShop();
        Thread.sleep(500);

        // Clicar em Play
        page.clicarPlay();
        Thread.sleep(1500);

        // Verificar que o campo de nickname aparece
        assertTrue(page.continueButtonVisivel(), "O botão Continue deve estar visível após clicar em Play");

        // Preencher nickname e continuar
        page.preencherNickname("Goncalo");
        Thread.sleep(500);
        page.clicarContinue();
        Thread.sleep(2000);
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
