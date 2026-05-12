package com.example.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Page Object Class para a UserStory12 - Ver histórico de partidas.
 * <p>
 * Representa as interações com o site papergames.io necessárias para
 * aceder ao histórico de partidas do utilizador, incluindo jogar uma
 * partida contra o robot e navegar para a página de histórico.
 * </p>
 *
 * @author TestSuite_122457
 */
public class UserStory12 {

    /** WebDriver utilizado para interagir com o browser. */
    private final WebDriver driver;

    /** Localizador da imagem do primeiro jogo (Battleship). */
    private final By primeiroJogo = By.cssSelector(".game-item:nth-child(1) .img-fluid");

    /** Localizador do ícone de grupo de utilizadores. */
    private final By iconeGrupo = By.cssSelector(".fa-user-group");

    /** Localizador do botão "Play with a friend" (face frontal). */
    private final By playWithFriendFront = By.cssSelector(".w-100:nth-child(1) .front");

    /** Localizador do texto interior do botão "Play with a friend". */
    private final By playWithFriendText = By.cssSelector(".w-100:nth-child(1) .flex-grow-1");

    /** Localizador da borda do botão "Play with a friend". */
    private final By playWithFriendEdge = By.cssSelector(".w-100:nth-child(1) .edge");

    /** Localizador do botão "Play vs robot" (face frontal). */
    private final By playVsRobotFront = By.cssSelector(".w-100:nth-child(2) > .btn > .front");

    /** Localizador do texto interior do botão "Play vs robot". */
    private final By playVsRobotText = By.cssSelector(".w-100:nth-child(2) > .btn .flex-grow-1");

    /** Localizador do botão para abortar o jogo. */
    private final By abortarJogo = By.cssSelector(".btn");

    /** Localizador do botão de confirmação de saída (danger). */
    private final By confirmarSaida = By.cssSelector(".btn-danger");

    /** Localizador do link "Home" na navbar do jogo. */
    private final By homeLink = By.linkText("Home");

    /** Localizador do link "History" na navbar. */
    private final By historyLink = By.linkText("History");

    /**
     * Construtor da classe UserStory12.
     *
     * @param driver instância do WebDriver a utilizar
     */
    public UserStory12(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Abre a página principal do site papergames.io.
     */
    public void abrirPagina() {
        driver.get("https://papergames.io/en/");
    }

    /**
     * Passa o rato por cima da imagem do primeiro jogo.
     */
    public void hoverPrimeiroJogo() {
        new Actions(driver).moveToElement(driver.findElement(primeiroJogo)).perform();
    }

    /**
     * Clica na imagem do primeiro jogo para aceder à Batalha Naval.
     */
    public void clicarPrimeiroJogo() {
        driver.findElement(primeiroJogo).click();
    }

    /**
     * Passa o rato por cima do ícone de grupo.
     */
    public void hoverIconeGrupo() {
        new Actions(driver).moveToElement(driver.findElement(iconeGrupo)).perform();
    }

    /**
     * Remove o rato de cima do ícone de grupo.
     */
    public void mouseOutIconeGrupo() {
        new Actions(driver).moveByOffset(0, 200).perform();
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
     * Passa o rato pela borda do botão "Play with a friend".
     */
    public void hoverPlayWithFriendEdge() {
        new Actions(driver).moveToElement(driver.findElement(playWithFriendEdge)).perform();
    }

    /**
     * Passa o rato por cima do botão "Play vs robot".
     */
    public void hoverPlayVsRobot() {
        new Actions(driver).moveToElement(driver.findElement(playVsRobotFront)).perform();
    }

    /**
     * Remove o rato de cima do botão "Play vs robot".
     */
    public void mouseOutPlayVsRobot() {
        new Actions(driver).moveByOffset(0, 200).perform();
    }

    /**
     * Clica no botão "Play vs robot" para iniciar uma partida contra o robot.
     */
    public void clicarPlayVsRobot() {
        driver.findElement(playVsRobotText).click();
    }

    /**
     * Digita o nome de utilizador no campo de registo de convidado.
     *
     * @param nome nome a introduzir no campo de texto
     */
    public void introduzirNome(String nome) {
        driver.findElement(By.cssSelector(".input-xl")).sendKeys(nome);
    }

    /**
     * Clica no botão "Continue" para confirmar o registo de convidado.
     */
    public void clicarContinue() {
        driver.findElement(By.cssSelector(".p-3 > .btn")).click();
    }

    /**
     * Clica no botão para abortar o jogo em curso.
     */
    public void clicarAbortarJogo() {
        driver.findElement(abortarJogo).click();
    }

    /**
     * Confirma a saída do jogo clicando no botão de danger.
     */
    public void confirmarSaidaJogo() {
        driver.findElement(confirmarSaida).click();
    }

    /**
     * Passa o rato por cima do link "Home" na navbar.
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
     * Clica no link "History" na barra de navegação.
     */
    public void clicarHistory() {
        driver.findElement(historyLink).click();
    }

    /**
     * Verifica se o link "History" está visível na navbar.
     *
     * @return true se o link estiver presente, false caso contrário
     */
    public boolean historyVisivel() {
        return !driver.findElements(historyLink).isEmpty();
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