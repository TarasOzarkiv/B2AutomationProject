package com.loop.test.day5_testNG_checkbox;

import com.loop.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class T8_dropdown_task1 {


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;

        // Set the path to the ChromeDriver executable
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/dropdown");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Step 2: Validate "Please select an option" is selected by default
        WebElement defaultOption = driver.findElement(By.xpath("//select[@id='dropdown']/option[@selected='selected']"));
        String defaultOptionText = defaultOption.getText();
        System.out.println("Default Option: " + defaultOptionText);
        Thread.sleep(5400);

        // Step 3: Choose option 1 and validate that it is selected
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Option 1");
        Thread.sleep(5400);

        WebElement selectedOption = select.getFirstSelectedOption();
        String selectedOptionText = selectedOption.getText();
        System.out.println("Selected Option: " + selectedOptionText);
        Thread.sleep(5400);

        // Step 4: Choose option 2 and validate that it is selected
        select.selectByVisibleText("Option 2");
        selectedOption = select.getFirstSelectedOption();
        selectedOptionText = selectedOption.getText();
        System.out.println("Selected Option: " + selectedOptionText);
        Thread.sleep(5400);

        // Step 5: Validate dropdown name is "Dropdown List"
        WebElement dropdownName = driver.findElement(By.xpath("//h3[text()='Dropdown List']"));
        String dropdownNameText = dropdownName.getText();
        System.out.println("Dropdown Name: " + dropdownNameText);
        Thread.sleep(5400);

        // Close the browser
        driver.quit();
    }
}
