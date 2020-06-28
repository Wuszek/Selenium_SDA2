package com.sda.Selenium_SDA2;

import com.sda.Selenium_SDA2.page.ForgotYourPasswordPage;
import com.sda.Selenium_SDA2.page.LoginPage;
import com.sda.Selenium_SDA2.page.MyAccountPage;
import com.sda.Selenium_SDA2.page.MyStorePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AutomationPracticeTest {

    private WebDriver webDriver;
    public WebDriverWait wait;

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

    @Test
    @DisplayName("Logowanie na istniejącego użytkownika")
    public void loginToPagePositive(){
        MyStorePage myStorePage = new MyStorePage(webDriver);
        myStorePage.signIn();

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.email("test@testowisko.pl");
        loginPage.password("Test111");
        loginPage.signIn();

        MyAccountPage myAccountPage = new MyAccountPage(webDriver);
        assertTrue(myAccountPage.isLoaded());
    }

    @Test
    @DisplayName("Logowanie na nieistniejącego użytkownika")
    public void loginToPageNegative(){
        MyStorePage myStorePage = new MyStorePage(webDriver);
        myStorePage.signIn();

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.email("test@testowisko.pl");
        loginPage.password("Test1112");
        loginPage.signIn();

        assertTrue(loginPage.isAutentificationFailed());
    }

    @Test
    @DisplayName("Opcja przypomnij hasło")
    public void sendEmailToForgottenPassword(){
        MyStorePage myStorePage = new MyStorePage(webDriver);
        myStorePage.signIn();

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.clickOnForgotYourPassword();

        ForgotYourPasswordPage forgotYourPasswordPage = new ForgotYourPasswordPage(webDriver);
        forgotYourPasswordPage.emailAddress("test@testowisko.pl");
        forgotYourPasswordPage.retrivePasswordButton();

        assertTrue(forgotYourPasswordPage.confirmationSentPositive());
    }
}
