package com.sda.Selenium_SDA2.page;

import org.eclipse.jetty.websocket.common.extensions.compress.XWebkitDeflateFrameExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MyStorePage {
    private WebDriver webDriver;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    private WebElement signInButton;



    public MyStorePage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver,10), this);
    }

    public void signIn(){
        signInButton.click();
    }

}
