package com.sda.Selenium_SDA2.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class CreateAccountPage {
    private WebDriver webDriver;

    @FindBy(xpath = "/html//form[@id='account-creation_form']/div[1]/div[1]/div[1]/label[@class='top']/div[@class='radio']//input[@name='id_gender']")
    private WebElement genderRadioButtonMr;

    @FindBy(xpath = "/html//form[@id='account-creation_form']/div[1]/div[1]/div[2]/label[@class='top']/div[@class='radio']//input[@name='id_gender']")
    private WebElement genderRadioButtonMs;

    @FindBy(xpath = "/html//input[@id='customer_firstname']")
    private WebElement peronalFirstName;

    @FindBy(xpath = "/html//input[@id='customer_lastname']")
    private WebElement personalLastName;

    @FindBy(xpath = "/html//input[@id='email']")
    private WebElement email;

    @FindBy(xpath = "/html//input[@id='passwd']")
    private WebElement password;

    @FindBy(xpath = "/html//select[@id='days']")
    private WebElement day;

    @FindBy(xpath = "/html//select[@id='months']")
    private WebElement month;

    @FindBy(xpath = "/html//select[@id='years']")
    private WebElement year;

    @FindBy(xpath = "/html//form[@id='account-creation_form']//input[@name='address1']")
    private WebElement address;

    @FindBy(xpath = "/html//input[@id='city']")
    private WebElement city;






    public CreateAccountPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver,10), this);
    }

    public void selectMr(){
        this.genderRadioButtonMr.click();
    }

    public void selectMs(){
        this.genderRadioButtonMs.click();
    }

    public void personalFirstName(String name){
        this.peronalFirstName.sendKeys(name);
    }

    public void personalLastName(String lname){
        this.personalLastName.sendKeys(lname);
    }

    public void enterEmail(String email){
        this.email.sendKeys(email);
    }

    public String verifyEmail(){
        return this.email.getText();
    }

}
