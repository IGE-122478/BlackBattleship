package com.example.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserStory6 {

    private WebDriver driver;

    private By battleshipGame =
            By.cssSelector(".game-item:nth-child(1) .text-light");

    private By shopButton =
            By.linkText("Shop");

    public UserStory6(WebDriver driver) {
        this.driver = driver;
    }

    public void openHomePage() {
        driver.get("https://papergames.io/en/");
    }

    public void clickBattleship() {
        driver.findElement(battleshipGame).click();
    }

    public void openShop() {
        driver.findElement(shopButton).click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}