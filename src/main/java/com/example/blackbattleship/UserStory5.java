package com.example.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserStory5 {

    private WebDriver driver;

    private By battleshipLink = By.linkText("Battleship");

    private By playVsRobotButton =
            By.cssSelector(".cdk-focused > .mat-mdc-button-touch-target");

    public UserStory5(WebDriver driver) {
        this.driver = driver;
    }

    public void openBattleship() {
        driver.get("https://papergames.io/en/battleship");
    }

    public void clickPlayVsRobot() {
        driver.findElement(playVsRobotButton).click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}