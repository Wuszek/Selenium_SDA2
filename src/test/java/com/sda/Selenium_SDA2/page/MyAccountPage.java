package com.sda.Selenium_SDA2.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MyAccountPage {
    private WebDriver webDriver;

    public MyAccountPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver,10), this);
    }

    public boolean isLoaded(){
        return this.webDriver.findElement(By.linkText("My account")).isDisplayed();
    }

}
