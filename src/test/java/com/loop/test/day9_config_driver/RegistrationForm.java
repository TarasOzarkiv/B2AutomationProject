package com.loop.test.day9_config_driver;

import com.github.javafaker.Faker;
import com.loop.test.utilities.ConfigurationReader;
import com.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;

public class RegistrationForm{
    @Test
    public static void regFormTest(){
        Driver.getDriver().get(ConfigurationReader.getProperty("reg"));
        Faker faker = new Faker();

        WebElement firstName = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys(faker.name().firstName());

        WebElement lastName = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys(faker.name().lastName());

        WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys(faker.name().username().replace(".", ""));

        WebElement email = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        email.sendKeys(faker.internet().emailAddress());

        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@type='password']"));
        password.sendKeys(faker.internet().password());

        WebElement phoneNumber = Driver.getDriver().findElement(By.xpath("//input[@type='tel']"));
        phoneNumber.sendKeys(faker.numerify("202-###-####"));

        WebElement gender = Driver.getDriver().findElement(By.xpath("//input[@value='male']"));
        gender.click();

        WebElement dateOfBirth = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        SimpleDateFormat fakeBoth= new SimpleDateFormat ("MM/dd/YYYY");
        String dob = fakeBoth.format(faker.date().birthday(18,70));
        dateOfBirth.sendKeys(dob);

        Select dropdownDepOffice = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        dropdownDepOffice.selectByIndex(3);

        Select dropdownJobTitle = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        dropdownJobTitle.selectByVisibleText("SDET");

        WebElement programLanguages = Driver.getDriver().findElement(By.xpath("//*[@id='inlineCheckbox2']"));
        programLanguages.click();

        WebElement signUpButton = Driver.getDriver().findElement(By.xpath("//*[@id='wooden_spoon']"));
        signUpButton.click();

        WebElement successMassage = Driver.getDriver().findElement(By.xpath("//*[@id=\"flash-messages\"]/div"));
        Assert.assertEquals(successMassage.getText(), "Thanks for signing up!", "Actual massage does NOT match expected");

        Driver.getDriver().quit();


    }
}
