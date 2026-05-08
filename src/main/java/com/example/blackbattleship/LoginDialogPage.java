package com.example.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object para o diálogo de login (LogIn) do PaperGames.
 * Apresenta o formulário com email/password e a opção "Continue with Google".
 */
public class LoginDialogPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Botão "LogIn" / "Log in" / "Login" no canto superior — case-insensitive via translate
    private final By loginButton = By.xpath(
            "//button[contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'login')]" +
                    " | //a[contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'login')]" +
                    " | //button[contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'log in')]" +
                    " | //a[contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'log in')]"
    );

    // Campo de email — vários atributos possíveis
    private final By emailField = By.xpath(
            "//input[@type='email']" +
                    " | //input[@name='email']" +
                    " | //input[contains(@placeholder,'mail') or contains(@placeholder,'Mail')]"
    );

    // Campo de password
    private final By passwordField = By.xpath(
            "//input[@type='password']" +
                    " | //input[@name='password']"
    );

    public LoginDialogPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    /** Clica no botão "LogIn" para abrir o diálogo. */
    public void clickLogin() {
        WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(loginButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
    }

    /** Verifica se o campo de email está visível. */
    public boolean isEmailFieldVisible() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(emailField));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /** Verifica se o campo de password está visível. */
    public boolean isPasswordFieldVisible() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(passwordField));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /** Verifica se a opção "Continue with Google" está presente no diálogo. */
    public boolean hasGoogleLoginOption() {
        String pageSource = driver.getPageSource().toLowerCase();
        return pageSource.contains("google");
    }
}
