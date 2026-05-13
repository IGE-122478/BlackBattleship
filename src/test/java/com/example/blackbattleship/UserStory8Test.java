package com.example.blackbattleship;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserStory8Test {

    private WebDriver driver;
    private UserStory8 page;

    @BeforeEach
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        page = new UserStory8(driver);
    }

    @Test
    public void testUserStory8() throws InterruptedException {

        page.openHomePage();

        Thread.sleep(3000);

        page.acceptCookies();

        Thread.sleep(2000);

        page.clickBattleship();

        Thread.sleep(3000);

        String originalWindow = driver.getWindowHandle();

        page.openGoodies();

        Thread.sleep(5000);

        Set<String> windows = driver.getWindowHandles();

        boolean newWindowOpened = false;

        for(String window : windows) {

            if(!window.equals(originalWindow)) {

                driver.switchTo().window(window);

                newWindowOpened = true;

                break;
            }
        }

        assertTrue(newWindowOpened);
    }

    @AfterEach
    public void tearDown() {

        if(driver != null) {
            driver.quit();
        }
    }
}