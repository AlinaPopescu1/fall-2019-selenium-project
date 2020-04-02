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
import java.util.List;

public class MainDepartments {
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
    public void mainDepartments() {
        driver.get("https://www.amazon.com/gp/site-directory");
        //verify that every main department name (indicated by blue rectangles in the picture) is
        //present in the All departments dropdown (indicated by green rectangle in the picture)
        List<WebElement> departmentNames = driver.findElements(By.tagName("h2"));
        List<String> actualDepNamesBlue = BrowserUtils.getElementsText(departmentNames);
        System.out.println("actualDepNamesBlue = " + actualDepNamesBlue);
        Select all = new Select(driver.findElement(By.id("searchDropdownBox")));
        List<WebElement> allDepartments = all.getOptions();
        List<String> allNamesGreen = BrowserUtils.getElementsText(allDepartments);
        System.out.println("allNamesGreen = " + allNamesGreen);

//        for(int i=0;i<allNamesGreen.size();i++) {
//            if(allNamesGreen.toString().equals(actualDepNamesBlue.toString())){
//                System.out.println("Item found: "+ actualDepNamesBlue.get(i));
//            }else {
//                System.out.println("Item not found: "+ actualDepNamesBlue.get(i));
//            }
//        }
        boolean var = allNamesGreen.containsAll(actualDepNamesBlue);
        Assert.assertFalse(var);
            }
        }

