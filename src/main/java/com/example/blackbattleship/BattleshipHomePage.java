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

    public BattleshipHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}