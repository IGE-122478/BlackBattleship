package com.example.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Page Object Class para a UserStory16 - Aceder ao servidor de Discord.
 * <p>
 * Esta classe representa as interações com a página do site papergames.io,
 * nomeadamente o fluxo de acesso ao servidor de Discord do PaperGames
 * que abre numa nova janela do browser.
 * </p>
 *
 * @author TestSuite_122488
 */
public class UserStory16 {

    /** WebDriver utilizado para interagir com o browser. */
    private final WebDriver driver;

    /** Localizador do thumbnail do primeiro jogo. */
    private final By primeiroJogoThumbnail = By.cssSelector(".game-item:nth-child(1) .thumbnail");

    /** Localizador do link "Discord" no rodapé. */
    private final By discordLink = By.linkText("Discord");

    /**
     * Construtor da classe UserStory16.
     *
     * @param driver instância do WebDriver a utilizar
     */
    public UserStory16(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Abre a página principal do site papergames.io.
     */
    public void abrirPagina() {
        driver.get("https://papergames.io/en/");
    }

    /**
     * Clica no thumbnail do primeiro jogo (Batalha Naval).
     */
    public void clicarPrimeiroJogo() {
        driver.findElement(primeiroJogoThumbnail).click();
    }

    /**
     * Faz scroll para o topo da página.
     */
    public void scrollParaTopo() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)");
    }

    /**
     * Clica no link "Discord" no rodapé da página.
     */
    public void clicarDiscord() {
        driver.findElement(discordLink).click();
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
     * Volta para a janela original do browser.
     *
     * @param handleOriginal o handle da janela original
     */
    public void voltarParaJanelaOriginal(String handleOriginal) {
        driver.switchTo().window(handleOriginal);
    }

    /**
     * Obtém o handle da janela atual.
     *
     * @return o handle da janela atual
     */
    public String obterHandleJanelaAtual() {
        return driver.getWindowHandle();
    }

    /**
     * Verifica se o link "Discord" está presente na página.
     *
     * @return true se o link estiver presente, false caso contrário
     */
    public boolean discordLinkVisivel() {
        return !driver.findElements(discordLink).isEmpty();
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