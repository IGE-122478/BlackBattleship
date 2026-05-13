package com.example.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Page Object Class para a UserStory1 - Criar Nickname.
 * <p>
 * Esta classe representa as interações com a página de Batalha Naval
 * do site papergames.io, nomeadamente o fluxo de criação de nickname
 * de um utilizador convidado.
 * </p>
 *
 * @author TestSuite_122478
 */
public class UserStory1 {

    /** WebDriver utilizado para interagir com o browser. */
    private final WebDriver driver;

    /** Localizador do botão "Play" (primeiro botão de ação). */
    private final By playButton = By.cssSelector(".w-100:nth-child(1) .flex-grow-1");

    /** Localizador do campo de input para o nickname. */
    private final By nicknameInput = By.cssSelector(".input-xl");

    /** Localizador do botão de submissão "Continue". */
    private final By continueButton = By.cssSelector(".p-3 > .btn");

    /** Localizador do link "Home" na navegação. */
    private final By homeLink = By.linkText("Home");

    /** Localizador do link "Shop" na navegação. */
    private final By shopLink = By.linkText("Shop");

    /**
     * Construtor da classe UserStory1.
     *
     * @param driver instância do WebDriver a utilizar
     */
    public UserStory1(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Abre a página de Batalha Naval no site papergames.io.
     */
    public void abrirPagina() {
        driver.get("https://papergames.io/en/battleship");
    }

    /**
     * Define o tamanho da janela do browser.
     */
    public void definirTamanhoJanela() {
        driver.manage().window().maximize();
    }

    /**
     * Passa o rato por cima do link "Home" da navegação.
     */
    public void hoverHome() {
        Actions actions = new Actions(driver);
        WebElement home = driver.findElement(homeLink);
        actions.moveToElement(home).perform();
    }

    /**
     * Passa o rato por cima do link "Shop" da navegação.
     */
    public void hoverShop() {
        Actions actions = new Actions(driver);
        WebElement shop = driver.findElement(shopLink);
        actions.moveToElement(shop).perform();
    }

    /**
     * Clica no botão "Play" para iniciar o jogo.
     */
    public void clicarPlay() {
        driver.findElement(playButton).click();
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
     * Verifica se o botão "Continue" está visível na página.
     *
     * @return true se o botão estiver presente, false caso contrário
     */
    public boolean continueButtonVisivel() {
        return !driver.findElements(continueButton).isEmpty();
    }
}
