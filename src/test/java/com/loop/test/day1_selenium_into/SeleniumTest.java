package com.loop.test.day1_selenium_into;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        Thread.sleep(5000);

//        driver.get("https://www.loopcamp.io");
        driver.navigate().to("https://www.google.com");


        driver.manage().window().maximize();
//        driver.manage().window().fullscreen();

        driver.navigate().refresh();
//        driver.quit();
        driver.close();

    }
}
