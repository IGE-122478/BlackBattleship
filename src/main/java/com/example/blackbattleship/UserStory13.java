package com.example.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Page Object Class para a UserStory13 - Aceder aos Termos e Condições.
 * <p>
 * Esta classe representa as interações com a página do site papergames.io,
 * nomeadamente o fluxo de acesso à página de Termos e Condições
 * da plataforma.
 * </p>
 *
 * @author TestSuite_122488
 */
public class UserStory13 {

    /** WebDriver utilizado para interagir com o browser. */
    private final WebDriver driver;

    /** Localizador do segundo jogo na lista. */
    private final By segundoJogoLink = By.cssSelector(".game-item:nth-child(2) > a");

    /** Localizador da imagem do primeiro jogo (Batalha Naval). */
    private final By primeiroJogoImagem = By.cssSelector(".game-item:nth-child(1) .img-fluid");

    /** Localizador do link "Terms & conditions" no rodapé. */
    private final By termsLink = By.linkText("Terms & conditions");

    /**
     * Construtor da classe UserStory13.
     *
     * @param driver instância do WebDriver a utilizar
     */
    public UserStory13(WebDriver driver) {
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
     * Passa o rato por cima do segundo jogo na lista.
     */
    public void hoverSegundoJogo() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(segundoJogoLink)).perform();
    }

    /**
     * Clica na imagem do primeiro jogo (Batalha Naval).
     */
    public void clicarPrimeiroJogo() {
        driver.findElement(primeiroJogoImagem).click();
    }

    /**
     * Faz scroll para o topo da página.
     */
    public void scrollParaTopo() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)");
    }

    /**
     * Clica no link "Terms & conditions" no rodapé da página.
     */
    public void clicarTermsAndConditions() {
        driver.findElement(termsLink).click();
    }

    /**
     * Verifica se o link "Terms & conditions" está presente na página.
     *
     * @return true se o link estiver presente, false caso contrário
     */
    public boolean termsLinkVisivel() {
        return !driver.findElements(termsLink).isEmpty();
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
