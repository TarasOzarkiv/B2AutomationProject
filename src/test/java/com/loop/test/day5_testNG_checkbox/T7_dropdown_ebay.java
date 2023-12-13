package com.loop.test.day5_testNG_checkbox;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T7_dropdown_ebay {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.etsy.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @Test
    public void DropdownEbay() throws InterruptedException {
//      search for rings
//        WebElement search = driver.findElement(By.xpath("//*[@id='global-enhancements-search-query']"));
        WebElement search = driver.findElement(By.xpath("//*[@id='global-enhancements-search-query']"));
        Thread.sleep(5400);
        search.sendKeys("rings");
        Thread.sleep(3020);
        search.submit();

//      validate that Estimated Arrival
        WebElement dayDropdown = driver.findElement(By.xpath("//select[@name='day']"));
        Select selectDay = new Select(dayDropdown);
        selectDay.selectByVisibleText("30");
//        WebElement estimatedArrival = driver.findElement(By.xpath("//span[@class='wt-menu__trigger__label']"));



    }
}
