package com.example.blackbattleship;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserStory7Test {

    private WebDriver driver;
    private UserStory7 page;

    @BeforeEach
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        page = new UserStory7(driver);
    }

    @Test
    public void testUserStory7() throws InterruptedException {

        page.openHomePage();

        Thread.sleep(2000);

        page.clickBattleship();

        Thread.sleep(2000);

        page.openPricing();

        Thread.sleep(3000);

        assertTrue(page.getCurrentUrl().contains("pricing"));
    }

    @AfterEach
    public void tearDown() {

        if(driver != null) {
            driver.quit();
        }
    }
}
