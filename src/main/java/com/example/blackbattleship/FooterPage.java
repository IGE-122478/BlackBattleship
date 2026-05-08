package com.example.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object para o footer do PaperGames.
 * Contém os links legais (Terms), de programadores (Developers)
 * e ícones de redes sociais (Discord).
 * Reutilizado pelos testes US13, US14 e US16.
 */
public class FooterPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Terms: link com texto "Terms" (case-insensitive via translate)
    private final By termsLink = By.xpath(
            "//a[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'terms')]"
    );

    // Developers: link aponta para developers.papergames.io
    private final By developersLink = By.xpath("//a[contains(@href,'developers.papergames.io')]");

    // Discord: link aponta para discord.gg ou discord.com
    private final By discordLink = By.xpath("//a[contains(@href,'discord')]");

    public FooterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    /** Faz scroll até ao fundo da página para o footer ficar visível. */
    public void scrollToFooter() {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    /** Clica no link "Terms" do footer usando JS click. */
    public void clickTerms() {
        WebElement link = wait.until(ExpectedConditions.presenceOfElementLocated(termsLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);
    }

    /** Clica no link "Developers" do footer usando JS click. */
    public void clickDevelopers() {
        WebElement link = wait.until(ExpectedConditions.presenceOfElementLocated(developersLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);
    }

    /** Clica no ícone Discord do footer usando JS click. */
    public void clickDiscord() {
        WebElement link = wait.until(ExpectedConditions.presenceOfElementLocated(discordLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);
    }
}