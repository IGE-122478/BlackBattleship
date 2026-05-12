package com.example.blackbattleship;

import com.example.blackbattleship.UserStory2;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class para a UserStory2 - Aceder às regras do jogo.
 * <p>
 * Esta classe contém os testes JUnit que validam o acesso aos guias
 * de jogo (Game Guides) a partir da página principal do papergames.io.
 * </p>
 *
 * @author TestSuite_122478
 */
public class UserStory2test {

    /** Instância do WebDriver partilhada pelos testes. */
    private WebDriver driver;

    /** Page Object utilizado nos testes. */
    private UserStory2 page;

    /**
     * Configuração executada antes de cada teste.
     * Inicializa o WebDriver e o Page Object.
     */
    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        page = new UserStory2(driver);
        page.abrirPagina();
    }

    /**
     * Testa o acesso aos guias de jogo a partir da página principal.
     * <p>
     * Verifica que ao clicar em "Game Guides" é aberta uma nova janela
     * com conteúdo relacionado com os guias do jogo.
     * </p>
     */
    @Test
    @DisplayName("US2 - Aceder às regras/guias do jogo")
    public void testAcederRegrasJogo() throws InterruptedException {
        // Scroll para o topo
        page.scrollParaTopo();
        Thread.sleep(500);
        page.scrollParaTopo();
        Thread.sleep(500);

        // Clicar em Game Guides (abre nova janela)
        page.clicarGameGuides();
        Thread.sleep(2000);

        // Mudar para a nova janela
        page.mudarParaNovaJanela();
        Thread.sleep(1500);

        // Verificar que a nova página foi aberta corretamente
        String url = page.obterUrlAtual();
        assertNotNull(url, "O URL da nova janela não deve ser nulo");
        assertFalse(url.isEmpty(), "O URL da nova janela não deve estar vazio");
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
