package com.example.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserStory5 {

    private WebDriver driver;

    private By settingsButton =
            By.cssSelector(".w-100:nth-child(2) > .btn .mat-mdc-button-touch-target");

    public UserStory5(WebDriver driver) {
        this.driver = driver;
    }

    public void openBattleship() {
        driver.get("https://papergames.io/en/battleship");
    }

    public void clickSettings() {
        driver.findElement(settingsButton).click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}