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

    // US10 - Create tournament
    @FindBy(xpath = "//a[contains(@href,'create-tournament')]")
    public WebElement createTournamentButton;

    // US11 - Settings (engrenagem no canto superior direito)
    @FindBy(css = "button[mattooltip='Settings']")
    public WebElement settingsButton;

    // US12 - Match History
    @FindBy(xpath = "//a[contains(@href,'match-history')]")
    public WebElement matchHistoryButton;

    public BattleshipHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}