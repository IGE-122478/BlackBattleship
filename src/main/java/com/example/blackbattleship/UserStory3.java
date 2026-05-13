package com.example.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Page Object Class para a UserStory3 - Jogar contra um robot.
 * <p>
 * Esta classe representa as interações com a página de Batalha Naval
 * do site papergames.io, nomeadamente o fluxo de iniciar uma partida
 * contra um robot (bot).
 * </p>
 *
 * @author TestSuite_122478
 */
public class UserStory3 {

    /** WebDriver utilizado para interagir com o browser. */
    private final WebDriver driver;

    /** Localizador do thumbnail do primeiro jogo (Batalha Naval). */
    private final By primeiroJogoThumbnail = By.cssSelector(".game-item:nth-child(1) .thumbnail");

    /** Localizador do segundo jogo na lista (Tic Tac Toe). */
    private final By segundoJogoImagem = By.cssSelector(".game-item:nth-child(2) .img-fluid");

    /** Localizador do botão "Play vs Bot" (segundo botão de ação). */
    private final By playVsBotButton = By.cssSelector(".w-100:nth-child(2) > .btn .flex-grow-1");

    /** Localizador do botão "Play" principal. */
    private final By playButton = By.cssSelector(".w-100:nth-child(1) > .btn-lg .flex-grow-1");

    /** Localizador do campo de input para o nickname. */
    private final By nicknameInput = By.cssSelector(".input-xl");

    /** Localizador do botão de submissão "Continue". */
    private final By continueButton = By.cssSelector("button[type='submit']");

    /**
     * Construtor da classe UserStory3.
     *
     * @param driver instância do WebDriver a utilizar
     */
    public UserStory3(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Abre a página principal do site papergames.io.
     */
    public void abrirPagina() {
        driver.get("https://papergames.io/en/");
    }

    /**
     * Passa o rato por cima da imagem do segundo jogo da lista.
     */
    public void hoverSegundoJogo() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(segundoJogoImagem)).perform();
    }

    /**
     * Clica no thumbnail do primeiro jogo (Batalha Naval).
     */
    public void clicarPrimeiroJogo() {
        driver.findElement(primeiroJogoThumbnail).click();
    }

    /**
     * Passa o rato por cima do botão "Play vs Bot".
     */
    public void hoverPlayVsBot() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(playVsBotButton)).perform();
    }

    /**
     * Clica no botão "Play vs Bot" para iniciar jogo contra robot.
     */
    public void clicarPlayVsBot() {
        driver.findElement(playVsBotButton).click();
    }

    /**
     * Verifica se o botão "Play vs Bot" está presente na página.
     *
     * @return true se o botão estiver disponível, false caso contrário
     */
    public boolean playVsBotVisivel() {
        return !driver.findElements(playVsBotButton).isEmpty();
    }

    /**
     * Verifica se o diálogo de nickname está visível na página.
     *
     * @return true se o campo de nickname estiver presente, false caso contrário
     */
    public boolean nicknameDialogVisivel() {
        return !driver.findElements(nicknameInput).isEmpty();
    }

    /**
     * Preenche o campo de nickname com o valor fornecido.
     *
     * @param nickname o nome de utilizador a inserir
     */
    public void preencherNickname(String nickname) {
        WebElement input = driver.findElement(nicknameInput);
        input.click();
        input.sendKeys(nickname);
    }

    /**
     * Clica no botão "Continue" para confirmar o nickname.
     */
    public void clicarContinue() {
        driver.findElement(continueButton).click();
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
