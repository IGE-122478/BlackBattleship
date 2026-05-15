package com.example.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object Class para a UserStory15 - Ver formulário de login.
 * <p>
 * Esta classe representa as interações com a página do site papergames.io,
 * nomeadamente o fluxo de acesso ao formulário de login com os campos
 * de email e password.
 * </p>
 *
 * @author TestSuite_122488
 */
public class UserStory15 {

    /** WebDriver utilizado para interagir com o browser. */
    private final WebDriver driver;

    /** Localizador do contentor de imagem do primeiro jogo. */
    private final By primeiroJogoContainer = By.cssSelector(".game-item:nth-child(1) .img-container");

    /** Localizador do botão "Login". */
    private final By loginButton = By.cssSelector(".btn-outline-dark");

    /** Localizador do campo de email no formulário de login. */
    private final By emailField = By.cssSelector("input[type='email']");

    /** Localizador do campo de password no formulário de login. */
    private final By passwordField = By.cssSelector("input[type='password']");

    /**
     * Construtor da classe UserStory15.
     *
     * @param driver instância do WebDriver a utilizar
     */
    public UserStory15(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Abre a página principal do site papergames.io.
     */
    public void abrirPagina() {
        driver.get("https://papergames.io/en/");
    }

    /**
     * Define o tamanho da janela do browser.
     *
     * @param largura largura da janela em pixels
     * @param altura altura da janela em pixels
     */
    public void definirTamanhoJanela(int largura, int altura) {
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(largura, altura));
    }

    /**
     * Clica no contentor do primeiro jogo (Batalha Naval).
     */
    public void clicarPrimeiroJogo() {
        driver.findElement(primeiroJogoContainer).click();
    }

    /**
     * Clica no botão "Login".
     */
    public void clicarLogin() {
        driver.findElement(loginButton).click();
    }

    /**
     * Verifica se o botão "Login" está presente na página.
     *
     * @return true se o botão estiver presente, false caso contrário
     */
    public boolean loginButtonVisivel() {
        return !driver.findElements(loginButton).isEmpty();
    }

    /**
     * Verifica se o campo de email está presente no formulário.
     *
     * @return true se o campo estiver presente, false caso contrário
     */
    public boolean emailFieldVisivel() {
        return !driver.findElements(emailField).isEmpty();
    }

    /**
     * Verifica se o campo de password está presente no formulário.
     *
     * @return true se o campo estiver presente, false caso contrário
     */
    public boolean passwordFieldVisivel() {
        return !driver.findElements(passwordField).isEmpty();
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