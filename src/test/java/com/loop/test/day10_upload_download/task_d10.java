package com.loop.test.day10_upload_download;

import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class task_d10 {
    @Test
    public void test_loop_vercel(){

        Driver.getDriver().get(ConfigurationReader.getProperty("loopver"));
        WebElement smallCircle = Driver.getDriver().findElement(By.xpath("//*[@id='draggable']"));
        WebElement bigCircle = Driver.getDriver().findElement(By.xpath("//*[@id='droptarget']"));
        Actions actions = new Actions(Driver.getDriver());

        actions.clickAndHold(smallCircle).moveToElement(bigCircle).perform();

        String actual = bigCircle.getText();
        String expected = "Now drop...";
        Assert.assertEquals(actual,expected, "Test fail");

        //        actions.dragAndDrop(smallCircle, bigCircle).perform();


    }
    @Test
    public void test_loop_vercel2(){
        Driver.getDriver().get(ConfigurationReader.getProperty("loopver"));
        WebElement smallCircle = Driver.getDriver().findElement(By.xpath("//*[@id='draggable']"));
        WebElement bigCircle = Driver.getDriver().findElement(By.xpath("//*[@id='droptarget']"));
        WebElement outCircle = Driver.getDriver().findElement(By.xpath("//div[@class='container']"));
        Actions actions = new Actions(Driver.getDriver());

        actions.dragAndDrop(smallCircle, outCircle).perform();
        String actual = bigCircle.getText();
        String expected = "Try again!";
        Assert.assertEquals(actual,expected, "Test fail");

    }
}
