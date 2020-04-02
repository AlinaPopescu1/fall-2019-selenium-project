package com.cybertek.tests.OfiiceHours1;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Etsy extends TestBase {
    @Test
    public void verifyCountrylist(){
        driver.get("http://etsy.com");
        driver.findElement(By.id("global-enhancements-search-query")).
                sendKeys("wooden spoon" + Keys.ENTER);
        String exp = "Wooden spoon | Etsy";
        //wait until title changes to right one using explicit
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleIs(exp));
        Assert.assertEquals(driver.getTitle(), exp);
        //verify ship to location
        //NoSuchElementException use implicit way
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Select shipToList = new Select(driver.findElement(By.name("ship_to")));
        Assert.assertEquals(shipToList.getFirstSelectedOption().getText(), "United States");

       List<String> countries = BrowserUtils.getElementsText(shipToList.getOptions());
       Assert.assertTrue(countries.contains("Australia"));

       WebElement freeShip = driver.findElement(By.xpath("//label[.='FREE shipping']"));
       Assert.assertFalse(freeShip.isSelected());
        freeShip.click();

        Assert.assertTrue(driver.getCurrentUrl().endsWith("free_shipping=true"));


    }
}
