package com.example.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NicknameDialogPage {

    @FindBy(css = "input[formcontrolname='username']")
    public WebElement nicknameInput;

    @FindBy(xpath = "//button[@type='submit' and contains(.,'Continue')]")
    public WebElement continueButton;

    @FindBy(xpath = "//h2[contains(.,'Who are you?')]")
    public WebElement dialogTitle;

    public NicknameDialogPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}