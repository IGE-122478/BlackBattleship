package com.example.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Page Object Class para a UserStory14 - Aceder à página Developers.
 * <p>
 * Esta classe representa as interações com a página do site papergames.io,
 * nomeadamente o fluxo de acesso à página de Developers que abre
 * numa nova janela do browser.
 * </p>
 *
 * @author TestSuite_122488
 */
public class UserStory14 {

    /** WebDriver utilizado para interagir com o browser. */
    private final WebDriver driver;

    /** Localizador da imagem do primeiro jogo (Batalha Naval). */
    private final By primeiroJogoImagem = By.cssSelector(".game-item:nth-child(1) .img-fluid");

    /** Localizador do botão "Play with a Friend". */
    private final By playWithFriendIcon = By.cssSelector(".w-100:nth-child(1) .front > .ng-fa-icon");

    /** Localizador do texto "Play with a Friend". */
    private final By playWithFriendText = By.cssSelector(".w-100:nth-child(1) .flex-grow-1");

    /** Localizador do botão "Play with a Friend" (front). */
    private final By playWithFriendFront = By.cssSelector(".w-100:nth-child(1) .front");

    /** Localizador da imagem do Playstore. */
    private final By playstoreImagem = By.cssSelector(".d-none:nth-child(1) img");

    /** Localizador da imagem do AppStore. */
    private final By appstoreImagem = By.cssSelector(".d-none:nth-child(2) img");

    /** Localizador do link "Developers" no rodapé. */
    private final By developersLink = By.cssSelector(".col-md-6:nth-child(3) > div:nth-child(4) > .text-reset");

    /**
     * Construtor da classe UserStory14.
     *
     * @param driver instância do WebDriver a utilizar
     */
    public UserStory14(WebDriver driver) {
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
     * Clica na imagem do primeiro jogo (Batalha Naval).
     */
    public void clicarPrimeiroJogo() {
        driver.findElement(primeiroJogoImagem).click();
    }

    /**
     * Passa o rato por cima do ícone "Play with a Friend".
     */
    public void hoverPlayWithFriendIcon() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(playWithFriendIcon)).perform();
    }

    /**
     * Passa o rato por cima do texto "Play with a Friend".
     */
    public void hoverPlayWithFriendText() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(playWithFriendText)).perform();
    }

    /**
     * Passa o rato por cima do botão "Play with a Friend" (front).
     */
    public void hoverPlayWithFriendFront() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(playWithFriendFront)).perform();
    }

    /**
     * Passa o rato por cima da imagem do Playstore.
     */
    public void hoverPlaystore() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(playstoreImagem)).perform();
    }

    /**
     * Passa o rato por cima da imagem do AppStore.
     */
    public void hoverAppstore() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(appstoreImagem)).perform();
    }

    /**
     * Faz scroll para o topo da página.
     */
    public void scrollParaTopo() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)");
    }

    /**
     * Clica no link "Developers" no rodapé da página.
     */
    public void clicarDevelopers() {
        driver.findElement(developersLink).click();
    }

    /**
     * Muda o foco do WebDriver para a nova janela aberta.
     */
    public void mudarParaNovaJanela() {
        String janelaOriginal = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(janelaOriginal)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    /**
     * Verifica se o link "Developers" está presente na página.
     *
     * @return true se o link estiver presente, false caso contrário
     */
    public boolean developersLinkVisivel() {
        return !driver.findElements(developersLink).isEmpty();
    }

    /**
     * Obtém o URL atual do browser.
     *
     * @return o URL da página atual
     */
    public String obterUrlAtual() {
        return driver.getCurrentUrl();
    }

    /**
     * Obtém o título da página atual.
     *
     * @return o título da página
     */
    public String obterTituloPagina() {
        return driver.getTitle();
    }
}