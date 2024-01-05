package com.loop.test.day11_waits_pom;

import com.loop.pages.SmartBearSoftwareWeb;
import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class task11 {

    SmartBearSoftwareWeb smartBearSoftwareWeb;
    @BeforeMethod
    public void setUpMethod(){
        Driver.getDriver().get(ConfigurationReader.getProperty("smartbearsoftware"));
        smartBearSoftwareWeb = new SmartBearSoftwareWeb();
    }

    @Test
    public void test_link(){
        smartBearSoftwareWeb.username.sendKeys("Tester");
        smartBearSoftwareWeb.password.sendKeys("test");
        smartBearSoftwareWeb.button.click();
        System.out.println("Links on the page: " + smartBearSoftwareWeb.linksList.size());
        for (WebElement each : smartBearSoftwareWeb.linksList){
            System.out.println(each.getText());
        }

    }
}
