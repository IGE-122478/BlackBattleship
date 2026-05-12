package com.example.blackbattleship;

import com.example.blackbattleship.UserStory4;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class para a UserStory4 - Gerar link para jogar com um amigo.
 * <p>
 * Esta classe contém os testes JUnit que validam o fluxo de criação
 * de um link de convite para jogar Batalha Naval com outro utilizador
 * no site papergames.io.
 * </p>
 *
 * @author TestSuite_122478
 */
public class UserStory4test {

    /** Instância do WebDriver partilhada pelos testes. */
    private WebDriver driver;

    /** Page Object utilizado nos testes. */
    private UserStory4 page;

    /**
     * Configuração executada antes de cada teste.
     * Inicializa o WebDriver e o Page Object.
     */
    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        page = new UserStory4(driver);
        page.abrirPagina();
    }

    /**
     * Testa o fluxo de geração de link para jogar com um amigo.
     * <p>
     * Verifica que o utilizador consegue aceder à Batalha Naval,
     * visualizar o botão "Play with a Friend" e iniciar o processo
     * de criação de um link de convite.
     * </p>
     */
    @Test
    @DisplayName("US4 - Gerar link para jogar com um amigo")
    public void testGerarLinkParaAmigo() throws InterruptedException {
        // Clicar no primeiro jogo (Batalha Naval)
        page.clicarPrimeiroJogo();
        Thread.sleep(2000);

        // Verificar que o botão "Play with a Friend" está disponível
        assertTrue(page.playWithFriendVisivel(), "O botão Play with a Friend deve estar visível");

        // Hover nos dois botões de ação
        page.hoverPlayVsBot();
        Thread.sleep(500);
        page.hoverPlayWithFriend();
        Thread.sleep(500);

        // Clicar em "Play with a Friend"
        page.clicarPlayWithFriend();
        Thread.sleep(2000);

        // Verificar que o URL mudou (link de convite gerado)
        String url = page.obterUrlAtual();
        assertNotNull(url, "O URL após criar o link não deve ser nulo");
        assertFalse(url.equals("https://papergames.io/en/"), "O URL deve ter mudado após clicar em Play with a Friend");
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
