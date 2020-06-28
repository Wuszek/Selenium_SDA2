package com.sda.Selenium_SDA2;

import com.sda.Selenium_SDA2.page.MyStorePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static  org.junit.jupiter.api.Assertions.*;
public class BaseTest {

    @Test
    public void sandboxTest() throws URISyntaxException, InterruptedException {
        // Ustalenie lokalizacji sterownika
        URL driverLocalization = getClass().getClassLoader().getResource("chromedriver.exe");
        File file = Paths.get(driverLocalization.toURI()).toFile();
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        // Uruchom przeglądarke
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("http://automationpractice.com/index.php");

        MyStorePage myStorePage = new MyStorePage(webDriver);
        myStorePage.signIn();

        TimeUnit.SECONDS.sleep(5);
        webDriver.quit();
    }

    @Test
    public void sandboxTest2() throws InterruptedException{
        WebDriverManager.chromedriver().setup();

        WebDriver webDriver = new ChromeDriver();
        TimeUnit.SECONDS.sleep(15);
        webDriver.quit();
    }

}
