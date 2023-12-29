package com.loop.test.day10_upload_download;

import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T4_JSExecutor_scroll {


    @Test
    public void etsy_scroll_test(){

        Driver.getDriver().get(ConfigurationReader.getProperty("etsy"));
        WebElement emailBox = Driver.getDriver().findElement(By.id("email-list-signup-email-input"));

        Actions action = new Actions(Driver.getDriver());
//        action.moveToElement(emailBox).perform();
//        action.scrollToElement(emailBox).perform();

//        action.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();

        //scroll
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
//        js.executeScript("window.scroll(0, 5000)");

        js.executeScript("arguments[0].scrollIntoView(true)", emailBox);
        js.executeScript("arguments[0].click", emailBox);


    }
}
