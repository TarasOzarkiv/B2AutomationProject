package com.loop.test.day8_windowsTables_config;

import com.loop.test.base.TestBase;
import com.loop.test.utilities.DocuportConstants;
import com.loop.test.utilities.DocuportUtils;
import com.loop.test.utilities.DocuportWebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class T1_webTables extends TestBase {

    @Test
    public void test_webTables() throws InterruptedException{
        DocuportUtils.login(driver, DocuportConstants.ADVISOR);
        Thread.sleep(3000);
        WebElement users = driver.findElement(By.xpath("//span[contains(text(),'Users')]"));
        users.click();
        Thread.sleep(3000);
        String expectedFullName = "Alex De Souza";
        String actualFullName = DocuportWebTableUtils.returnAnyField(driver, "alex.de.souza@gmail.com", "Full name");
        System.out.println("actualFullName = " + actualFullName);
        assertEquals(actualFullName, expectedFullName, "Actual does not match expected");

        String expectedUserName = "alexdesouze";
        String actualUserName = DocuportWebTableUtils.returnAnyField(driver,"alex.de.souza@gmail.com", "username");
        assertEquals(actualUserName,expectedUserName,"Actual does not match expected");
    }

}
