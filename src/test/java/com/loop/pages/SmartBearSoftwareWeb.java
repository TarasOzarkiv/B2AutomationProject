package com.loop.pages;

import com.loop.test.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SmartBearSoftwareWeb {

    @FindBy (id = "ctl00_MainContent_username")
    public WebElement username;

    @FindBy (id = "ctl00_MainContent_password")
    public WebElement password;

    @FindBy (id = "ctl00_MainContent_login_button")
    public WebElement button;

    @FindBy (tagName = "a")
    public List<WebElement> linksList;

    public SmartBearSoftwareWeb(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
