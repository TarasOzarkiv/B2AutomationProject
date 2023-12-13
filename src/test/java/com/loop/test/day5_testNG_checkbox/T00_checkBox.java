package com.loop.test.day5_testNG_checkbox;
import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T00_checkBox {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://the-internet.herokuapp.com/checkboxes");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement checkBox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        if (!checkBox1.isSelected())
            System.out.println("TEST PASSED: CHECKBOX#1 IS NOT SELECTED BY DEFAULT");
        else
            System.out.println("TEST FAILED: CHECKBOX#1 IS SELECTED BY DEFAULT");

        WebElement checkBox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        if (checkBox2.isSelected())
            System.out.println("TEST PASSED: CHECKBOX#2 IS SELECTED BY DEFAULT");
        else
            System.out.println("TEST FAILED: CHECKBOX#2 IS NOT SELECTED BY DEFAULT");

        checkBox1.click();
        checkBox2.click();

        if (checkBox1.isSelected())
            System.out.println("TEST PASSED: CHECKBOX#1 IS SELECTED");
        else
            System.out.println("TEST FAILED: CHECKBOX#1 IS NOT SELECTED");

        if (!checkBox2.isSelected())
            System.out.println("TEST PASSED: CHECKBOX#2 IS NOT SELECTED");
        else
            System.out.println("TEST FAILED: CHECKBOX#2 IS SELECTED");

        driver.quit();
    }
}