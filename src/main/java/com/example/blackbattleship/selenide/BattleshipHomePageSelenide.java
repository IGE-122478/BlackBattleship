package com.example.blackbattleship.selenide;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Page Object Selenide para a página inicial do Battleship.
 * Versão exploratória — Ponto 2 da Parte 2 da ficha.
 *
 * Contraste com Selenium:
 *  - Não há WebDriver nem WebDriverWait.
 *  - $ e $x devolvem SelenideElement, com waits automáticos integrados.
 *  - Métodos como click() já esperam que o elemento esteja visível.
 */
public class BattleshipHomePageSelenide {

    /** Botão "Play vs robot" da página inicial. */
    public SelenideElement playVsRobotButton() {
        return $x("//button[contains(.,'Play vs robot')]");
    }

    /** Botão "Play with friend" da página inicial. */
    public SelenideElement playWithFriendButton() {
        return $x("//button[contains(.,'Play with friend')]");
    }

    /** Link "Game guides" da página inicial. */
    public SelenideElement gameGuidesLink() {
        return $x("//a[contains(.,'Game guides')] | //button[contains(.,'Game guides')]");
    }

    /** Campo de input do nickname (no diálogo que abre após Play vs robot). */
    public SelenideElement nicknameInput() {
        return $("input[formcontrolname='nickname'], input[type='text']");
    }

    /** Botão "Continue" do diálogo de nickname. */
    public SelenideElement continueButton() {
        return $x("//button[contains(.,'Continue')]");
    }

    /** Título do diálogo de nickname (usado para verificar que abriu). */
    public SelenideElement nicknameDialogTitle() {
        return $x("//*[contains(text(),'nickname') or contains(text(),'Nickname')]");
    }
}