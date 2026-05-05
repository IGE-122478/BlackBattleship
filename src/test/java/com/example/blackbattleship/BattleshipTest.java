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
}