package com.example.blackbattleship.selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

/**
 * Bateria de testes em Selenide — recriação dos US01 a US04 da Parte 1.
 * Ponto 2 da Parte 2 da ficha.
 *
 * Comparação com a versão Selenium:
 *  - Não há setup manual de WebDriver (ChromeDriver, options, etc.).
 *  - Selenide abre/fecha o browser automaticamente, mas usamos closeWebDriver()
 *    para garantir limpeza entre testes.
 *  - Os métodos do Page Object devolvem SelenideElement, com waits implícitos.
 */
public class BattleshipTestSelenide {

    private static final String BASE_URL = "https://papergames.io/en/battleship";

    @BeforeAll
    static void setUpClass() {
        // Configurações globais Selenide
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 15000; // 15 segundos de timeout default
        Configuration.headless = false; // queremos ver o browser para a demo
    }

    @BeforeEach
    void setUp() {
        open(BASE_URL);
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }

    /**
     * US01 — Como utilizador, quero criar um nickname para jogar.
     * Recriação Selenide: clica "Play vs robot" → verifica que o diálogo de nickname abre.
     */
    @Test
    void US01_createNickname() throws InterruptedException {
        Thread.sleep(5000); // mantemos para alinhar com a Parte 1

        BattleshipHomePageSelenide home = new BattleshipHomePageSelenide();

        // Clicar em "Play vs robot"
        home.playVsRobotButton().shouldBe(visible).click();

        // Verificar que o diálogo de nickname aparece
        home.nicknameInput().shouldBe(visible);

        System.out.println("✅ US01 Selenide — diálogo de nickname abriu");
    }
}