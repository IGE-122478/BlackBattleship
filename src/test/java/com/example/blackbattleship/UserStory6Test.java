package com.example.blackbattleship;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserStory6Test {

    private WebDriver driver;
    private UserStory6 page;

    @BeforeEach
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        page = new UserStory6(driver);
    }

    @Test
    public void testUserStory6() throws InterruptedException {

        page.openHomePage();

        Thread.sleep(2000);

        page.clickBattleship();

        Thread.sleep(2000);

        page.openShop();

        Thread.sleep(3000);

        assertTrue(page.getCurrentUrl().contains("shop"));
    }

    @AfterEach
    public void tearDown() {

        if(driver != null) {
            driver.quit();
        }
    }
}