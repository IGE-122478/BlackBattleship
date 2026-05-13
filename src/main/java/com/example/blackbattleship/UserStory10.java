package com.example.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Page Object Class para a UserStory10 - Participar num campeonato/torneio.
 * <p>
 * Representa as interações com a página de Batalha Naval do site papergames.io,
 * nomeadamente o fluxo de acesso a um torneio/campeonato.
 * </p>
 *
 * @author TestSuite_122457
 */
public class UserStory10 {

    /** WebDriver utilizado para interagir com o browser. */
    private final WebDriver driver;

    /** Localizador da imagem do primeiro jogo (Battleship). */
    private final By primeiroJogo = By.cssSelector(".game-item:nth-child(1) .img-fluid");

    /** Localizador do botão "Play with a friend" (face frontal). */
    private final By playWithFriendFront = By.cssSelector(".w-100:nth-child(1) .front");

    /** Localizador do botão secundário (torneio/campeonato). */
    private final By botaoSecundario = By.cssSelector(".btn-secondary:nth-child(2)");

    /** Localizador do botão de acesso ao torneio (link com face frontal). */
    private final By torneioBotao = By.cssSelector(".position-relative > .front");

    /**
     * Construtor da classe UserStory10.
     *
     * @param driver instância do WebDriver a utilizar
     */
    public UserStory10(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Abre a página principal do site papergames.io.
     */
    public void abrirPagina() {
        driver.get("https://papergames.io/en/");
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
     * Passa o rato por cima do botão secundário (torneio).
     */
    public void hoverBotaoSecundario() {
        new Actions(driver).moveToElement(driver.findElement(botaoSecundario)).perform();
    }

    /**
     * Clica no botão de acesso ao torneio.
     */
    public void clicarTorneio() {
        driver.findElement(torneioBotao).click();
    }

    /**
     * Verifica se o botão de torneio está visível na página.
     *
     * @return true se o botão estiver presente, false caso contrário
     */
    public boolean torneioVisivel() {
        return !driver.findElements(torneioBotao).isEmpty();
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