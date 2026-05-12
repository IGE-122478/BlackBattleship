package com.example.blackbattleship;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserStory7 {

    private WebDriver driver;

    private By battleshipImage =
            By.cssSelector(".game-item:nth-child(1) .img-fluid");

    private By pricingButton =
            By.cssSelector(".cdk-focused > .hide-if-collapsed");

    public UserStory7(WebDriver driver) {
        this.driver = driver;
    }

    public void openHomePage() {
        driver.get("https://papergames.io/en/");
    }

    public void clickBattleship() {
        driver.findElement(battleshipImage).click();
    }

    public void openPricing() {
        driver.findElement(pricingButton).click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}