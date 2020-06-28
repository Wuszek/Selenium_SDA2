package com.sda.Selenium_SDA2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AutomationPracticeTest {

    private WebDriver webDriver;

    @BeforeAll
    public static void setUpClass(){
        // Lokalizacja sterownika
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() throws InterruptedException {
        // Uruchom przeglądarke i wejdź na stronę
        this.webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("http://automationpractice.com/index.php");
    }

    @AfterEach
    public void tearDown(){
        // Zamknij przeglądarkę
        this.webDriver.quit();
    }
}
