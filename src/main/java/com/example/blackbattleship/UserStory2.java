package com.example.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Page Object Class para a UserStory2 - Aceder às regras do jogo.
 * <p>
 * Esta classe representa as interações com a página principal do site
 * papergames.io, nomeadamente o acesso aos guias de jogo (Game Guides)
 * que abrem numa nova janela do browser.
 * </p>
 *
 * @author TestSuite_122478
 */
public class UserStory2 {

    /** WebDriver utilizado para interagir com o browser. */
    private final WebDriver driver;

    /** Localizador do link "Game guides" na barra lateral. */
    private final By gameGuidesLink = By.cssSelector(".cdk-focused > .hide-if-collapsed");

    /**
     * Construtor da classe UserStory2.
     *
     * @param driver instância do WebDriver a utilizar
     */
    public UserStory2(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Abre a página principal do site papergames.io.
     */
    public void abrirPagina() {
        driver.get("https://papergames.io/en/");
    }

    /**
     * Faz scroll para o topo da página.
     */
    public void scrollParaTopo() {
        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0,0)");
    }

    /**
     * Clica no link "Game guides" que abre numa nova janela.
     */
    public void clicarGameGuides() {
        driver.findElement(gameGuidesLink).click();
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
     * Obtém o título da página atual.
     *
     * @return o título da página
     */
    public String obterTituloPagina() {
        return driver.getTitle();
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
