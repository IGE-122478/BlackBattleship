package com.example.blackbattleship;

import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class BattleshipTest {

    private WebDriver driver;
    private BattleshipHomePage homePage;
    private NicknameDialogPage nicknameDialog;
    private GamePage gamePage;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://papergames.io/en/battleship");

        homePage = new BattleshipHomePage(driver);
        nicknameDialog = new NicknameDialogPage(driver);
        gamePage = new GamePage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * US01 — Como visitante, quero criar um nickname para poder ser identificado durante o jogo.
     */
    @Test
    public void US01_createNickname() throws InterruptedException {
        Thread.sleep(5000); // espera que a página carregue completamente

        // Espera até o botão estar visível e clicável
        wait.until(ExpectedConditions.elementToBeClickable(homePage.playVsRobotButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", homePage.playVsRobotButton);
        Thread.sleep(3000);

        // Espera pelo diálogo de nickname
        wait.until(ExpectedConditions.visibilityOf(nicknameDialog.dialogTitle));
        assertTrue(nicknameDialog.dialogTitle.isDisplayed(), "Diálogo de nickname não apareceu");

        nicknameDialog.nicknameInput.sendKeys("TestUser123");
        Thread.sleep(1000);

        assertEquals("TestUser123", nicknameDialog.nicknameInput.getAttribute("value"));
    }

    /**
     * US02 — Como utilizador, quero ver as instruções/regras do jogo para perceber como jogar.
     */
    @Test
    public void US02_viewGameGuides() throws InterruptedException {
        Thread.sleep(5000);

        // Espera até o botão estar visível
        wait.until(ExpectedConditions.elementToBeClickable(homePage.gameGuidesButton));

        // Guarda a janela atual
        String originalWindow = driver.getWindowHandle();

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", homePage.gameGuidesButton);
        Thread.sleep(3000);

        // O guia abre numa nova aba — muda para essa aba
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        Thread.sleep(2000);
        assertTrue(driver.getCurrentUrl().contains("game-guides"),
                "A página dos guias do jogo não abriu. URL atual: " + driver.getCurrentUrl());
    }

    /**
     * US03 — Como utilizador, quero jogar contra um robot para treinar sem precisar de outro jogador.
     */
    @Test
    public void US03_playVsRobot() throws InterruptedException {
        Thread.sleep(5000);

        // Clica em "Play vs robot"
        wait.until(ExpectedConditions.elementToBeClickable(homePage.playVsRobotButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", homePage.playVsRobotButton);
        Thread.sleep(3000);

        // Espera pelo diálogo de nickname
        wait.until(ExpectedConditions.visibilityOf(nicknameDialog.dialogTitle));
        assertTrue(nicknameDialog.dialogTitle.isDisplayed(), "Diálogo de nickname não apareceu");

        // Preenche o nickname
        nicknameDialog.nicknameInput.sendKeys("RobotPlayer");
        Thread.sleep(1500);

        // Clica em Continue
        wait.until(ExpectedConditions.elementToBeClickable(nicknameDialog.continueButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", nicknameDialog.continueButton);
        Thread.sleep(4000);

        // Verifica que saímos do diálogo (já entrámos no jogo contra o robot)
        assertFalse(driver.getPageSource().contains("Who are you?"),
                "Ainda estamos no diálogo de nickname - não entrámos no jogo");
    }

    /**
     * US04 — Como utilizador, quero criar um link de partida e enviá-lo a um amigo.
     */
    @Test
    public void US04_playWithFriend() throws InterruptedException {
        Thread.sleep(5000);

        // Clica em "Play with a friend"
        wait.until(ExpectedConditions.elementToBeClickable(homePage.playWithFriendButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", homePage.playWithFriendButton);
        Thread.sleep(3000);

        // Aparece o diálogo do nickname (passo necessário antes de criar o link da partida)
        wait.until(ExpectedConditions.visibilityOf(nicknameDialog.dialogTitle));
        assertTrue(nicknameDialog.dialogTitle.isDisplayed(),
                "Diálogo de nickname não apareceu ao clicar em Play with a friend");

        // Preenche o nickname
        nicknameDialog.nicknameInput.sendKeys("FriendInviter");
        Thread.sleep(1500);

        // Verifica que o nickname foi escrito corretamente
        assertEquals("FriendInviter", nicknameDialog.nicknameInput.getAttribute("value"),
                "Nickname não foi escrito corretamente");
    }

    /**
     * US05 — Como utilizador, quero escolher quem joga primeiro.
     */
    @Test
    public void US05_openPlayVsRobotSettings() throws InterruptedException {
        Thread.sleep(5000);

        // Clica na engrenagem ao lado de "Play vs robot"
        wait.until(ExpectedConditions.elementToBeClickable(homePage.playVsRobotSettingsButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", homePage.playVsRobotSettingsButton);
        Thread.sleep(3000);

        // Verifica que o diálogo "Game settings" abriu
        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("Game settings"),
                "Diálogo de Game Settings não abriu");
    }
    /**
     US06 — Como utilizador, quero aceder à loja para comprar artigos virtuais.
     */
    @Test
    public void US06_accessShop() throws InterruptedException {
        Thread.sleep(5000);

        // Clica no botão Shop na sidebar
        wait.until(ExpectedConditions.elementToBeClickable(homePage.shopButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", homePage.shopButton);
        Thread.sleep(3000);

        // Verifica que navegou para a página da Shop
        assertTrue(driver.getCurrentUrl().contains("shop"),
                "Não navegou para a página Shop. URL atual: " + driver.getCurrentUrl());
    }
    /**
     US07 — Como utilizador, quero aceder à página de preços para conhecer os planos.*/
    @Test
    public void US07_accessPricing() throws InterruptedException {
        Thread.sleep(5000);

        // Clica no botão Pricing na sidebar
        wait.until(ExpectedConditions.elementToBeClickable(homePage.pricingButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", homePage.pricingButton);
        Thread.sleep(3000);

        // Verifica que navegou para a página de Pricing
        assertTrue(driver.getCurrentUrl().contains("pricing"),
                "Não navegou para a página Pricing. URL atual: " + driver.getCurrentUrl());
    }
    /**
     US08 — Como utilizador, quero aceder à secção Goodies para receber recompensas.*/
    @Test
    public void US08_accessGoodies() throws InterruptedException {
        Thread.sleep(5000);

        String originalWindow = driver.getWindowHandle();

        // Clica no botão Goodies na sidebar
        wait.until(ExpectedConditions.elementToBeClickable(homePage.goodiesButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", homePage.goodiesButton);
        Thread.sleep(4000);

        // O Goodies abre numa nova aba — muda para essa aba
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        Thread.sleep(2000);

        // Verifica que estamos na página de merchandise (Goodies)
        String urlAtual = driver.getCurrentUrl();
        assertTrue(urlAtual.contains("merch.papergames") || urlAtual.contains("goodies"),
                "Não foi aberta a página de Goodies. URL atual: " + urlAtual);

    }
    /**
     * US09 — Como utilizador, quero consultar a tabela de classificação (leaderboard).
     */
    @Test
    public void US09_viewLeaderboard() throws InterruptedException {
        Thread.sleep(5000);

        // Faz scroll para baixo para ver o leaderboard
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 800)");
        Thread.sleep(3000);

        // Verifica que existe a secção da leaderboard pelo título visível
        // (case-insensitive: apanha "Leaderboard", "LEADERBOARD", "leaderboard")
        String pageSource = driver.getPageSource().toLowerCase();

        boolean temTituloLeaderboard =
                pageSource.contains("leaderboard")
                        || pageSource.contains("top players")
                        || pageSource.contains("rankings")
                        || pageSource.contains("classificação");

        assertTrue(
                temTituloLeaderboard,
                "Não foi encontrado o título da leaderboard na página"
        );

        // Verificação adicional: a leaderboard deve ter pelo menos um número
        // (posição #1, #2, etc. ou pontuações). Procuramos o símbolo "#" ou padrão de pontos
        boolean temEntradas =
                pageSource.contains("#1")
                        || pageSource.matches("(?s).\\b\\d{3,4}\\b."); // qualquer número de 3-4 dígitos (pontuações típicas)

        assertTrue(
                temEntradas,
                "A leaderboard não tem entradas (posições ou pontuações) visíveis"
        );

        System.out.println("✅ Leaderboard encontrada com título e entradas visíveis");
    }

    /**
     * US10 — Como utilizador, quero participar num campeonato/torneio.
     */
    @Test
    public void US10_createTournament() throws InterruptedException {
        Thread.sleep(5000);

        // Clica em "Create tournament"
        wait.until(ExpectedConditions.elementToBeClickable(homePage.createTournamentButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", homePage.createTournamentButton);
        Thread.sleep(3000);

        // Verifica que navegou para a página de criação de torneio
        assertTrue(driver.getCurrentUrl().contains("tournament"),
                "Não navegou para a página de criação de torneio. URL atual: " + driver.getCurrentUrl());
    }
    /**

     US11 — Como utilizador, quero verificar que o menu de definições abre e contém opções de configuração.*/
    @Test
    public void US11_openSettings() throws InterruptedException {
        Thread.sleep(5000);

        // Clica no ícone de Settings (engrenagem)
        wait.until(ExpectedConditions.elementToBeClickable(homePage.settingsButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", homePage.settingsButton);
        Thread.sleep(2000);

        // Verifica que o menu de Settings abriu
        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("Settings") && pageSource.contains("Language"),
                "Menu de definições não abriu corretamente");
    }

    /**
     * US12 — Como utilizador, quero ver o histórico das minhas partidas.
     */
    @Test
    public void US12_viewMatchHistory() throws InterruptedException {
        Thread.sleep(5000);

        // 1. Faz login: clica em "Play vs robot" para iniciar o processo
        wait.until(ExpectedConditions.elementToBeClickable(homePage.playVsRobotButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", homePage.playVsRobotButton);
        Thread.sleep(3000);

        // 2. Preenche o nickname
        wait.until(ExpectedConditions.visibilityOf(nicknameDialog.dialogTitle));
        nicknameDialog.nicknameInput.sendKeys("HistoryTester");
        Thread.sleep(1500);

        // 3. Clica em Continue para ficar logado
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", nicknameDialog.continueButton);
        Thread.sleep(5000);

        // 4. Navega diretamente para a página de histórico
        driver.get("https://papergames.io/en/match-history");
        Thread.sleep(4000);

        // 5. Verifica que estamos na página de histórico
        assertTrue(driver.getCurrentUrl().contains("match-history") || driver.getCurrentUrl().contains("history"),
                "Não estamos na página de histórico. URL: " + driver.getCurrentUrl());

        // 6. Verifica que a página tem conteúdo relacionado com histórico
        String pageSource = driver.getPageSource().toLowerCase();
        assertTrue(pageSource.contains("history") || pageSource.contains("match")
                        || pageSource.contains("game") || pageSource.contains("histórico"),
                "Página de histórico não carregou corretamente");

    }

    @Test
    public void US13_viewTermsAndConditions() throws InterruptedException {
        Thread.sleep(5000);

        FooterPage footer = new FooterPage(driver);

        // Scroll até ao fundo para o footer ficar visível
        footer.scrollToFooter();
        Thread.sleep(2000);

        // Clicar em "Terms"
        footer.clickTerms();
        Thread.sleep(3000);

        // Verificação: URL contém "terms"
        String currentUrl = driver.getCurrentUrl();
        System.out.println("URL após clicar em Terms: " + currentUrl);

        assertTrue(
                currentUrl.toLowerCase().contains("terms"),
                "Após clicar em Terms, o URL deveria conter 'terms'. URL atual: " + currentUrl
        );
    }

    /**

     US14 — Como utilizador, quero aceder à página Developers para conhecer
     as ferramentas disponíveis para programadores na plataforma.*/
    @Test
    public void US14_viewDevelopersPage() throws InterruptedException {
        Thread.sleep(5000);

        FooterPage footer = new FooterPage(driver);

        // Guardar a janela original (Developers pode abrir em nova aba)
        String originalWindow = driver.getWindowHandle();

        // Scroll até ao fundo para o footer ficar visível
        footer.scrollToFooter();
        Thread.sleep(2000);

        // Clicar em "Developers"
        footer.clickDevelopers();
        Thread.sleep(4000);

        // Procurar a aba/janela onde o Developers abriu
        // (pode abrir em nova aba ou na mesma — tratamos os dois casos)
        String developersUrl = null;

        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
            String url = driver.getCurrentUrl();
            if (url.contains("developers")) {
                developersUrl = url;
                break;
            }
        }

        // Se não abriu em nova aba, verifica o URL atual da janela original
        if (developersUrl == null) {
            driver.switchTo().window(originalWindow);
            developersUrl = driver.getCurrentUrl();
        }

        System.out.println("URL após clicar em Developers: " + developersUrl);

        // Verificação: o URL contém "developers"
        assertTrue(
                developersUrl.toLowerCase().contains("developers"),
                "Após clicar em Developers, o URL deveria conter 'developers'. URL atual: " + developersUrl
        );
    }

    /**

     US15 — Como utilizador, quero ver o formulário de login com os campos de
     email e password disponíveis para poder iniciar sessão na plataforma.*/
    @Test
    public void US15_viewLoginForm() throws InterruptedException {
        Thread.sleep(5000);

        LoginDialogPage loginPage = new LoginDialogPage(driver);

        // Clicar no botão LogIn
        loginPage.clickLogin();
        Thread.sleep(3000);

        // Verificação 1: campo de email está visível
        assertTrue(
                loginPage.isEmailFieldVisible(),
                "O campo de email deveria estar visível no diálogo de login"
        );

        // Verificação 2: campo de password está visível
        assertTrue(
                loginPage.isPasswordFieldVisible(),
                "O campo de password deveria estar visível no diálogo de login"
        );

        // Verificação 3: opção de login com Google está presente
        assertTrue(
                loginPage.hasGoogleLoginOption(),
                "A opção 'Continue with Google' deveria estar visível no diálogo de login"
        );

        System.out.println("✅ Diálogo de login aberto com email, password e opção Google");
    }

    /**

     US16 — Como utilizador, quero aceder ao servidor de Discord do PaperGames
     para interagir com a comunidade de jogadores.*/
    @Test
    public void US16_accessDiscordServer() throws InterruptedException {
        Thread.sleep(5000);

        FooterPage footer = new FooterPage(driver);

        // Guardar a janela original (Discord abre em nova aba)
        String originalWindow = driver.getWindowHandle();

        // Scroll até ao fundo para o footer ficar visível
        footer.scrollToFooter();
        Thread.sleep(2000);

        // Clicar no ícone Discord
        footer.clickDiscord();
        Thread.sleep(4000);

        // Procurar a aba/janela onde o Discord abriu
        String discordUrl = null;

        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
            String url = driver.getCurrentUrl();
            if (url.contains("discord")) {
                discordUrl = url;
                break;
            }
        }

        // Fallback: se não abriu em nova aba, verifica o URL atual da janela original
        if (discordUrl == null) {
            driver.switchTo().window(originalWindow);
            discordUrl = driver.getCurrentUrl();
        }

        System.out.println("URL após clicar em Discord: " + discordUrl);

        // Verificação: o URL contém "discord" (apanha discord.gg ou discord.com)
        assertTrue(
                discordUrl.toLowerCase().contains("discord"),
                "Após clicar em Discord, o URL deveria conter 'discord'. URL atual: " + discordUrl
        );
    }
}