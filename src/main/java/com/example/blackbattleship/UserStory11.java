package com.example.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Page Object Class para a UserStory11 - Aceder às definições gerais.
 * <p>
 * Representa as interações com o menu de navegação do site papergames.io,
 * nomeadamente o acesso às definições/configurações gerais do utilizador.
 * </p>
 *
 * @author TestSuite_122457
 */
public class UserStory11 {

    /** WebDriver utilizado para interagir com o browser. */
    private final WebDriver driver;

    /** Localizador do link "Home" na barra de navegação. */
    private final By homeLink = By.linkText("Home");

    /** Localizador do botão de definições no header (segundo nav). */
    private final By definicoesBotao = By.cssSelector(
            "app-header-nav:nth-child(2) .mat-mdc-button-touch-target");

    /** Localizador do botão de definições com foco ativo. */
    private final By definicoesFocado = By.cssSelector(
            ".cdk-focused > .mat-mdc-button-touch-target");

    /**
     * Construtor da classe UserStory11.
     *
     * @param driver instância do WebDriver a utilizar
     */
    public UserStory11(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Abre a página principal do site papergames.io.
     */
    public void abrirPagina() {
        driver.get("https://papergames.io/en/");
    }

    /**
     * Passa o rato por cima do link "Home".
     */
    public void hoverHome() {
        new Actions(driver).moveToElement(driver.findElement(homeLink)).perform();
    }

    /**
     * Passa o rato por cima do ícone de definições no header.
     */
    public void hoverDefinicoes() {
        new Actions(driver).moveToElement(driver.findElement(definicoesBotao)).perform();
    }

    /**
     * Clica no botão de definições quando este tem foco ativo.
     */
    public void clicarDefinicoes() {
        driver.findElement(definicoesFocado).click();
    }

    /**
     * Remove o rato de cima do botão de definições.
     */
    public void mouseOutDefinicoes() {
        new Actions(driver).moveByOffset(0, 200).perform();
    }

    /**
     * Verifica se o botão de definições está visível na página.
     *
     * @return true se o botão estiver presente, false caso contrário
     */
    public boolean definicoesVisivel() {
        return !driver.findElements(definicoesBotao).isEmpty();
    }

    /**
     * Obtém o URL atual do browser.
     *
     * @return o URL da página atual
     */
    public String obterUrlAtual() {
        return driver.getCurrentUrl();
    }
}