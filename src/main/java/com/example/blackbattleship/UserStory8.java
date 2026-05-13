package com.example.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserStory8 {

    private WebDriver driver;

    private By cookiesButton =
            By.cssSelector(".fc-cta-consent");

    private By battleshipImage =
            By.cssSelector(".game-item:nth-child(1) .img-fluid");

    private By goodiesButton =
            By.xpath("//span[contains(text(),'Goodies')]");

    public UserStory8(WebDriver driver) {
        this.driver = driver;
    }

    public void openHomePage() {
        driver.get("https://papergames.io/en/");
    }

    public void acceptCookies() {
        driver.findElement(cookiesButton).click();
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

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}