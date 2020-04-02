package com.cybertek.tests.Homework2Actions;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DepartmentsSort {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("Chrome");
    }
   @AfterMethod
    public void afterTest() {
        driver.quit();
    }
    @Test
    public void depSort(){
        //1
        driver.get(" https://www.amazon.com");
        //2
        Select all = new Select(driver.findElement(By.id("searchDropdownBox")));
        String defaultButton = all.getFirstSelectedOption().getText();
        String expected = "All";
        Assert.assertNotEquals(defaultButton, expected);
          //3
        List<WebElement> options = all.getOptions();
        List <String> actualValues = BrowserUtils.getElementsText(options);

        List<String> expectedValues = new ArrayList<>(actualValues);
        Collections.sort(expectedValues);

        System.out.println("Expected: " + expectedValues.toString());
        //Collections.sort(actualValues);
        System.out.println("Actual: " + actualValues.toString());
        //if the sorted one(expected) is equals actual means
        // actual is sorted, otherwise is not, so it will fail.
        Assert.assertEquals(expectedValues, actualValues);//FAIL//Negative failed







        }
    }

