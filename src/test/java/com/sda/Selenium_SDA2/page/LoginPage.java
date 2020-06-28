package com.sda.Selenium_SDA2.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver webDriver;

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement emailAddressInput;

    @FindBy(xpath = "//*[@id=\"passwd\"]")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"login_form\"]/div/p[1]/a")
    private WebElement forgotYourPasswordLink;

    @FindBy(xpath = "//*[@id=\"SubmitLogin\"]/span")
    private WebElement signInButton;

    @FindBy(xpath = "/html//input[@id='email_create']")
    private WebElement emailAddressCreate;

    @FindBy(xpath = "//button[@id='SubmitCreate']/span")
    private WebElement createAccountButton;

    @FindBy(xpath = "/html//div[@id='create_account_error']")
    private WebElement createAccountError;


    public LoginPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver,10), this);

    }

    public void email(String email){
        this.emailAddressInput.sendKeys(email);
    }

    public void password(String password){
        this.passwordInput.sendKeys(password);
    }

    public void clickOnForgotYourPassword(){
        this.forgotYourPasswordLink.click();
    }

    public void signIn(){
        signInButton.click();
    }

    public boolean isAutentificationFailed(){
        return this.webDriver.findElement(By.xpath("//div[@id='center_column']//ol/li[.='Authentication failed.']")).isDisplayed();
    }

    public void emailCreate(String email){
        this.emailAddressCreate.sendKeys(email);
    }

    public void createAccountButton(){
        this.createAccountButton.click();
    }

    public boolean createAccountError(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("create_account_error"))).isDisplayed();
    }

}
