package com.example.blackbattleship;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserStory5Test {

    private WebDriver driver;
    private UserStory5 page;

    @BeforeEach
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        page = new UserStory5(driver);
    }

    @Test
    public void testUserStory5() throws InterruptedException {

        page.openBattleship();

        Thread.sleep(2000);

        page.clickPlayVsRobot();

        Thread.sleep(2000);

        assertTrue(page.getCurrentUrl().contains("battleship"));
    }

    @AfterEach
    public void tearDown() {

        if(driver != null) {
            driver.quit();
        }
    }
}
