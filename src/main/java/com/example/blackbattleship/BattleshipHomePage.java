package com.example.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = https://papergames.io/en/battleship
public class BattleshipHomePage {

    @FindBy(xpath = "//span[@class='flex-grow-1' and contains(text(),'Play with a friend')]")
    public WebElement playWithFriendButton;

    @FindBy(xpath = "//span[@class='flex-grow-1' and contains(text(),'Play vs robot')]")
    public WebElement playVsRobotButton;

    @FindBy(xpath = "//span[@class='flex-grow-1' and contains(text(),'Play online')]")
    public WebElement playOnlineButton;

    @FindBy(xpath = "//a[contains(@href,'/docs/game-guides/')]")
    public WebElement gameGuidesButton;

    // US09 - Leaderboard (lista de jogadores no fundo da página)
    @FindBy(xpath = "//ol[contains(@class,'leaderboard')] | //div[contains(@class,'leaderboard')] | //ol")
    public WebElement leaderboard;

    // US10 - Create tournament
    @FindBy(xpath = "//a[contains(@href,'create-tournament')] | //span[contains(text(),'Create tournament')]")
    public WebElement createTournamentButton;

    // US11 - Settings (engrenagem no canto superior direito)
    @FindBy(css = "button[mattooltip='Settings']")
    public WebElement settingsButton;

    // US12 - Match History
    @FindBy(xpath = "//a[contains(@href,'match-history')] | //span[contains(text(),'History')]")
    public WebElement matchHistoryButton;

    public BattleshipHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}