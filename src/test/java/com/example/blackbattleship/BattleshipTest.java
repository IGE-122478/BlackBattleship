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
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://papergames.io/en/battleship");

        homePage = new BattleshipHomePage(driver);
        nicknameDialog = new NicknameDialogPage(driver);
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
}