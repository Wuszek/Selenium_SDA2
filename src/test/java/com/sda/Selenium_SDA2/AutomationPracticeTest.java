package com.sda.Selenium_SDA2;

import com.sda.Selenium_SDA2.page.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
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
    @DisplayName("Opcja przypomnij hasło - zakończone pozytywnie")
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

    @Test
    @DisplayName("Opcja przypomnij hasło - zły adres email")
    public void sendEmailToForgottenPasswordNegative(){
        MyStorePage myStorePage = new MyStorePage(webDriver);
        myStorePage.signIn();

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.clickOnForgotYourPassword();

        ForgotYourPasswordPage forgotYourPasswordPage = new ForgotYourPasswordPage(webDriver);
        forgotYourPasswordPage.emailAddress("xxxx");
        forgotYourPasswordPage.retrivePasswordButton();

        assertTrue(forgotYourPasswordPage.confirmationSentNegative());
    }

    @Test
    @DisplayName("Zakładanie nowego konta")
    public void createNewAccount(){

        String generatedPrefix = RandomStringUtils.randomAlphabetic(10);
        String generatedSuffix = RandomStringUtils.randomAlphabetic(3);
        String email = generatedPrefix + "@" + generatedSuffix + ".com";
        String password = RandomStringUtils.randomAlphabetic(7);

        MyStorePage myStorePage = new MyStorePage(webDriver);
        myStorePage.signIn();

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.emailCreate(email);
        loginPage.createAccountButton();

        CreateAccountPage createAccountPage = new CreateAccountPage(webDriver);
        createAccountPage.selectMr();
        createAccountPage.personalFirstName("Mateosz");
        createAccountPage.personalLastName("Kekosz");

        assertEquals(email, createAccountPage.verifyEmail());

        createAccountPage.enterPassword(password);
        createAccountPage.selectDayOfBirthByValue("5");
        createAccountPage.selectMonthsOfBirthByValue("7");
        createAccountPage.selectYearOfBirthByValue("1990");

        createAccountPage.verifyFirstName("Mateosz");
        createAccountPage.verifyLastName("Kekosz");

        createAccountPage.enterAddress("Kasztanowa 22");
        createAccountPage.enterCity("Gedanensis");
        createAccountPage.selectStateByValue("5");
        createAccountPage.enterZipcode("80888");
        createAccountPage.enterPhoneNumber("500501502");

        createAccountPage.verifyAssignAddress("My address");

        createAccountPage.registerButton();

        MyAccountPage myAccountPage = new MyAccountPage(webDriver);
        assertTrue(myAccountPage.isLoaded());

    }

    @Test
    @DisplayName("Zakładanie nowego konta - email już istnieje")
    public void createNewAccountError(){
        MyStorePage myStorePage = new MyStorePage(webDriver);
        myStorePage.signIn();

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.emailCreate("test@testowisko.pl");
        loginPage.createAccountButton();

        assertTrue(loginPage.createAccountError());
    }

}
