package com.sda.Selenium_SDA2.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

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

}