package com.loop.test.day9_config_driver;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.PizzaOrderWebTableUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PizzaOrderValidation extends TestBase {
    @Test
    public void pizzaOrder(){
        driver.get("https://loopcamp.vercel.app/web-tables.html");
        validatePizzaOrder("John Doe", "Pepperoni", "3", "01/08/2021", "12, Cherry Ave",
                "Arlington, VA", "Canada", "76743", "MasterCard", "980077987700", "01/23");

        validatePizzaOrder("Stewart Dawidson", "Sausage", "4", "03/29/2021", "19, Victor Ave",
                "Cate Island", "Canada", "24232", "VISA", "774555444555", "03/23");

        validatePizzaOrder("Stewart Dawidson", "Sausage","4","03/29/2021","19, Victor Ave",
                "Cate Island", "Canada","24232", "VISA",	"774555444555",	"03/23");
    }

    public static void validatePizzaOrder(String name, String type, String amount, String data,
                                          String street, String city, String state, String zipCode, String card,
                                          String cartNumber, String expirationDate ){

        String actualName = driver.findElement(By.xpath("//td[.='" + name + "']")).getText();
        assertEquals(actualName, name, "Actual dose not match expected");


        String actualType = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, name, "Pizza Type");
        assertEquals(actualType, type, "Actual dose not match expected");

        String actualAmount = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, name, "Amount");
        assertEquals(actualAmount, amount, "Actual dose not match expected");

        String actualData = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, name, "Date");
        assertEquals(actualData, data, "Actual dose not match expected");

        String actualStreet = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, name, "Street");
        assertEquals(actualStreet, street, "Actual dose not match expected");

        String actualCity = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, name, "City");
        assertEquals(actualCity, city, "Actual dose not match expected");

        String actualState = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, name, "State");
        assertEquals(actualState, state, "Actual dose not match expected");

        String actualZipCode = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, name, "Zip");
        assertEquals(actualZipCode, zipCode, "Actual dose not match expected");

        String actualCard = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, name, "Card");
        assertEquals(actualCard, card, "Actual dose not match expected");

        String actualCartNumber = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, name, "Card Number");
        assertEquals(actualCartNumber, cartNumber, "Actual dose not match expected");

        String actualExpirationDate = PizzaOrderWebTableUtils.returnAnyFieldValue(driver, name, "Exp");
        assertEquals(actualExpirationDate, expirationDate, "Actual dose not match expected");

    }
}