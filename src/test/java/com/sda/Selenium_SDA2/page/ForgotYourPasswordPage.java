package com.sda.Selenium_SDA2.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ForgotYourPasswordPage {
    private WebDriver webDriver;

    @FindBy(xpath = "/html//input[@id='email']")
    private WebElement emailAddress;

    @FindBy(xpath = "/html//form[@id='form_forgotpassword']//span")
    private WebElement retrivePasswordButton;

    @FindBy(xpath = "//div[@id='center_column']//p[@class='alert alert-success']")
    private WebElement confirmationSent;

    public ForgotYourPasswordPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver,10), this);
    }

    public void emailAddress(String email){
        this.emailAddress.sendKeys(email);
    }

    public void retrivePasswordButton(){
        this.retrivePasswordButton.click();
    }

    public boolean confirmationSentPositive(){
        return this.confirmationSent.isDisplayed();
    }
}
