package com.example.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserStory8 {

    private WebDriver driver;

    private By battleshipImage =
            By.cssSelector(".game-item:nth-child(1) .img-fluid");

    private By goodiesButton =
            By.cssSelector(".cdk-focused > .hide-if-collapsed");

    public UserStory8(WebDriver driver) {
        this.driver = driver;
    }

    public void openHomePage() {
        driver.get("https://papergames.io/en/");
    }

    public void clickBattleship() {
        driver.findElement(battleshipImage).click();
    }

    public void openGoodies() {
        driver.findElement(goodiesButton).click();
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }
}