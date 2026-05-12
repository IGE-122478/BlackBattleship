package com.example.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Page Object Class para a UserStory4 - Gerar link para jogar com um amigo.
 * <p>
 * Esta classe representa as interações com a página de Batalha Naval
 * do site papergames.io, nomeadamente o fluxo de criação de um link
 * de convite para jogar com outro utilizador.
 * </p>
 *
 * @author TestSuite_122478
 */
public class UserStory4 {

    /** WebDriver utilizado para interagir com o browser. */
    private final WebDriver driver;

    /** Localizador do contentor de imagem do primeiro jogo. */
    private final By primeiroJogoContainer = By.cssSelector(".game-item:nth-child(1) .img-container");

    /** Localizador do botão "Play with a Friend" (primeiro botão). */
    private final By playWithFriendButton = By.cssSelector(".w-100:nth-child(1) > .btn-lg .flex-grow-1");

    /** Localizador do botão "Play vs Bot" (segundo botão). */
    private final By playVsBotButton = By.cssSelector(".w-100:nth-child(2) > .btn .flex-grow-1");

    /**
     * Construtor da classe UserStory4.
     *
     * @param driver instância do WebDriver a utilizar
     */
    public UserStory4(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Abre a página principal do site papergames.io.
     */
    public void abrirPagina() {
        driver.get("https://papergames.io/en/");
    }

    /**
     * Clica no contentor do primeiro jogo para aceder à Batalha Naval.
     */
    public void clicarPrimeiroJogo() {
        driver.findElement(primeiroJogoContainer).click();
    }

    /**
     * Passa o rato por cima do botão "Play with a Friend".
     */
    public void hoverPlayWithFriend() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(playWithFriendButton)).perform();
    }

    /**
     * Passa o rato por cima do botão "Play vs Bot".
     */
    public void hoverPlayVsBot() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(playVsBotButton)).perform();
    }

    /**
     * Clica no botão "Play with a Friend" para gerar link de convite.
     */
    public void clicarPlayWithFriend() {
        driver.findElement(playWithFriendButton).click();
    }

    /**
     * Verifica se o botão "Play with a Friend" está visível na página.
     *
     * @return true se o botão estiver presente, false caso contrário
     */
    public boolean playWithFriendVisivel() {
        return !driver.findElements(playWithFriendButton).isEmpty();
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
