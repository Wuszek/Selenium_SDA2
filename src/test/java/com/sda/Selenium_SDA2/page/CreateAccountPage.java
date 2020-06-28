package com.sda.Selenium_SDA2.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

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

    @FindBy(id = "days")
    private WebElement dayOfBirthDropdown;

    @FindBy(id = "months")
    private WebElement monthOfBirthDropdown;

    @FindBy(id = "years")
    private WebElement yearOfBirthDropdown;

    @FindBy(xpath = "/html//input[@id='firstname']")
    private WebElement checkedFirstName;

    @FindBy(xpath = "/html//input[@id='customer_lastname']")
    private WebElement checkedLastName;

    @FindBy(xpath = "/html//form[@id='account-creation_form']//input[@name='address1']")
    private WebElement address;

    @FindBy(xpath = "/html//input[@id='city']")
    private WebElement city;

    @FindBy(xpath = "/html//select[@id='id_state']")
    private WebElement state;

    @FindBy(xpath = "/html//input[@id='postcode']")
    private WebElement zipcode;

    @FindBy(xpath = "/html//input[@id='phone_mobile']")
    private WebElement telephone;

    @FindBy(xpath = "/html//input[@id='alias']")
    private WebElement assignAddress;

    @FindBy(xpath = "//button[@id='submitAccount']/span")
    private WebElement registerButton;




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
        return this.email.getAttribute("value");
    }

    public void clearEmail(){
        this.email.clear();
    }

    public void enterPassword(String password){
        this.password.sendKeys(password);
    }

    public void selectDayOfBirthByValue(String value) {
        Select dayDropdown = new Select(dayOfBirthDropdown);
        dayDropdown.selectByValue(value);
    }

    public void selectMonthsOfBirthByValue(String value) {
        Select monthDropdown = new Select(monthOfBirthDropdown);
        monthDropdown.selectByValue(value);
    }

    public void selectYearOfBirthByValue(String value) {
        Select yearDropdown = new Select(yearOfBirthDropdown);
        yearDropdown.selectByValue(value);
    }

    public String verifyFirstName(String value){
        return this.checkedFirstName.getAttribute("value");
    }

    public String verifyLastName(String value){
        return this.checkedLastName.getAttribute("value");
    }

    public void enterAddress(String address){
        this.address.sendKeys(address);
    }

    public void enterCity(String address){
        this.city.sendKeys(address);
    }

    public void selectStateByValue(String value) {
        Select stateDropdown = new Select(state);
        stateDropdown.selectByValue(value);
    }

    public void enterZipcode(String zipcode){
        this.zipcode.sendKeys(zipcode);
    }

    public void enterPhoneNumber(String phone){
        this.telephone.sendKeys(phone);
    }

    public String verifyAssignAddress(String value){
        return this.assignAddress.getAttribute("value");
    }

    public void registerButton(){
        this.registerButton.click();
    }

    public List<String> getErrors(){
        List<String> errors = new ArrayList<>();
        WebDriverWait wait = new WebDriverWait(this.webDriver, 10);
        List<WebElement> errorsElements =  wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ol/li")));
        for(WebElement errorElement: errorsElements){
            errors.add(errorElement.getText());
        }
        return errors;
    }


}
