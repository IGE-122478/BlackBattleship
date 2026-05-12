package com.example.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Page Object Class para a UserStory9 - Consultar tabela de classificação (leaderboard).
 * <p>
 * Representa as interações com a página principal e de jogo do site papergames.io,
 * nomeadamente a navegação até à secção de leaderboard da Batalha Naval.
 * </p>
 *
 * @author TestSuite_122457
 */
public class UserStory9 {

    /** WebDriver utilizado para interagir com o browser. */
    private final WebDriver driver;

    /** Localizador do link "Home" na barra de navegação. */
    private final By homeLink = By.linkText("Home");

    /** Localizador da imagem do primeiro jogo (Battleship). */
    private final By primeiroJogo = By.cssSelector(".game-item:nth-child(1) .img-fluid");

    /** Localizador do botão "Play with a friend" (face frontal). */
    private final By playWithFriendFront = By.cssSelector(".w-100:nth-child(1) .front");

    /** Localizador do texto interior do botão "Play with a friend". */
    private final By playWithFriendText = By.cssSelector(".w-100:nth-child(1) .flex-grow-1");

    /** Localizador do botão secundário (leaderboard/rankings). */
    private final By botaoSecundario = By.cssSelector(".btn-secondary:nth-child(2)");

    /**
     * Construtor da classe UserStory9.
     *
     * @param driver instância do WebDriver a utilizar
     */
    public UserStory9(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Abre a página principal do site papergames.io.
     */
    public void abrirPagina() {
        driver.get("https://papergames.io/en/");
    }

    /**
     * Passa o rato por cima do link "Home" na barra de navegação.
     */
    public void hoverHome() {
        new Actions(driver).moveToElement(driver.findElement(homeLink)).perform();
    }

    /**
     * Remove o rato de cima do link "Home".
     */
    public void mouseOutHome() {
        new Actions(driver).moveByOffset(0, 200).perform();
    }

    /**
     * Clica na imagem do primeiro jogo para aceder à Batalha Naval.
     */
    public void clicarPrimeiroJogo() {
        driver.findElement(primeiroJogo).click();
    }

    /**
     * Passa o rato por cima do botão "Play with a friend".
     */
    public void hoverPlayWithFriend() {
        new Actions(driver).moveToElement(driver.findElement(playWithFriendFront)).perform();
    }

    /**
     * Remove o rato de cima do botão "Play with a friend".
     */
    public void mouseOutPlayWithFriend() {
        new Actions(driver).moveByOffset(0, 200).perform();
    }

    /**
     * Passa o rato pelo texto interior do botão "Play with a friend".
     */
    public void hoverPlayWithFriendText() {
        new Actions(driver).moveToElement(driver.findElement(playWithFriendText)).perform();
    }

    /**
     * Remove o rato do texto interior do botão "Play with a friend".
     */
    public void mouseOutPlayWithFriendText() {
        new Actions(driver).moveByOffset(0, 200).perform();
    }

    /**
     * Passa o rato por cima do botão secundário (leaderboard).
     */
    public void hoverBotaoSecundario() {
        new Actions(driver).moveToElement(driver.findElement(botaoSecundario)).perform();
    }

    /**
     * Verifica se o botão secundário (leaderboard) está visível na página.
     *
     * @return true se o botão estiver presente, false caso contrário
     */
    public boolean leaderboardVisivel() {
        return !driver.findElements(botaoSecundario).isEmpty();
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