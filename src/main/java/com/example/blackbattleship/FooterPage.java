package com.example.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FooterPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By termsLink = By.xpath(
            "//a[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'terms')]"
    );
    private final By aboutLink = By.xpath(
            "//a[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'about')]"
    );

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

    /** Clica no link "About" do footer usando JS click. */
    public void clickAbout() {
        WebElement link = wait.until(ExpectedConditions.presenceOfElementLocated(aboutLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);
    }

    /** Clica no ícone Discord do footer usando JS click. */
    public void clickDiscord() {
        WebElement link = wait.until(ExpectedConditions.presenceOfElementLocated(discordLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", link);
    }
}
