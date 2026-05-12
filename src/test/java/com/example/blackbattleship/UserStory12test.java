package com.example.blackbattleship;

import com.example.blackbattleship.UserStory12;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class para a UserStory12 - Ver histórico de partidas.
 * <p>
 * Valida que o utilizador consegue jogar uma partida contra o robot,
 * abandoná-la e navegar para a página de histórico de partidas.
 * </p>
 *
 * @author TestSuite_122457
 */
public class UserStory12test {

    /** Instância do WebDriver partilhada pelos testes. */
    private WebDriver driver;

    /** Page Object utilizado nos testes. */
    private UserStory12 page;

    /**
     * Configuração executada antes de cada teste.
     */
    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        page = new UserStory12(driver);
        page.abrirPagina();
    }

    /**
     * Testa o fluxo completo de acesso ao histórico de partidas.
     * <p>
     * Verifica que o utilizador consegue iniciar uma partida contra o robot,
     * abandoná-la e aceder à página de histórico para acompanhar a sua evolução.
     * </p>
     */
    @Test
    @DisplayName("US12 - Ver histórico das partidas")
    public void testVerHistoricoPartidas() throws InterruptedException {
        // Hover e click no primeiro jogo
        page.hoverPrimeiroJogo();
        Thread.sleep(500);
        page.clicarPrimeiroJogo();
        Thread.sleep(2000);

        // Hover/mouseOut no ícone de grupo (duas vezes, conforme .side)
        page.hoverIconeGrupo();
        Thread.sleep(300);
        page.mouseOutIconeGrupo();
        Thread.sleep(300);
        page.hoverIconeGrupo();
        Thread.sleep(300);
        page.mouseOutIconeGrupo();
        Thread.sleep(300);

        // Hover nos botões de jogo
        page.hoverPlayWithFriend();
        Thread.sleep(300);
        page.mouseOutPlayWithFriend();
        Thread.sleep(300);
        page.hoverPlayWithFriendText();
        Thread.sleep(300);
        page.mouseOutPlayWithFriend();
        Thread.sleep(300);
        page.hoverPlayWithFriendEdge();
        Thread.sleep(300);
        page.mouseOutPlayWithFriend();
        Thread.sleep(300);
        page.hoverPlayVsRobot();
        Thread.sleep(300);
        page.mouseOutPlayVsRobot();
        Thread.sleep(300);

        // Clicar em "Play vs robot"
        page.clicarPlayVsRobot();
        Thread.sleep(2000);

        // Preencher nome de utilizador convidado e continuar
        page.introduzirNome("TEst11");
        Thread.sleep(500);
        page.clicarContinue();
        Thread.sleep(3000);

        // Hover no botão de início e abortar o jogo
        page.hoverPlayVsRobot();
        Thread.sleep(500);
        page.clicarAbortarJogo();
        Thread.sleep(1000);
        page.confirmarSaidaJogo();
        Thread.sleep(2000);

        // Hover/mouseOut no link "Home" da navbar do jogo
        page.hoverHome();
        Thread.sleep(300);
        page.mouseOutHome();
        Thread.sleep(300);

        // Verificar que o link "History" está visível
        assertTrue(page.historyVisivel(),
                "O link History deve estar visível na navbar");

        // Clicar em "History"
        page.clicarHistory();
        Thread.sleep(2000);

        // Verificar que navegou para a página de histórico
        String url = page.obterUrlAtual();
        assertTrue(url.contains("match-history"),
                "O URL deve conter 'match-history' após clicar em History");
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