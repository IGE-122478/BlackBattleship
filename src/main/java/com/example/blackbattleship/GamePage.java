package com.example.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GamePage {

    // ============ GAME SETTINGS DIALOG (US05) ============

    @FindBy(xpath = "//h2[contains(text(),'Game settings')]")
    public WebElement gameSettingsTitle;

    @FindBy(xpath = "//mat-option//span[contains(text(),'I start first')]")
    public WebElement iStartFirstOption;

    @FindBy(xpath = "//button//span[contains(text(),'Save settings')]")
    public WebElement saveSettingsButton;

    // ============ GAME PLAY (US06, US07, US08) ============

    // Botão "Place randomly" / "Random"
    @FindBy(xpath = "//button[contains(.,'Random') or contains(.,'Aleatório')] | //span[contains(text(),'Random')]")
    public WebElement randomPlacementButton;

    // Tabuleiro do adversário (células onde se clica para disparar)
    @FindBy(css = ".cell, .board-cell, [class='cell']")
    public WebElement boardCell;

    // Resultado dos tiros
    @FindBy(xpath = "//[contains(@class,'hit') or contains(@class,'miss') or contains(@class,'sunk')]")
    public WebElement shotResult;

    // Botão Ready/Start
    @FindBy(xpath = "//button[contains(.,'Ready') or contains(.,'Start') or contains(.,'Play')]")
    public WebElement readyButton;

    public GamePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}