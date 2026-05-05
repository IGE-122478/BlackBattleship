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
}