package com.cybertek.tests.OfiiceHours1;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.*;
public class DropDown {
    WebDriver driver;
    Actions actions;
    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("Chrome");
        actions = new Actions(driver);
    }
    @AfterMethod
    public void afterTest() { driver.quit();
    }
    @Test
    public void test3(){
        driver.get("http://practice.cybertekschool.com/dropdown");
        Select days = new Select(driver.findElement(By.id("day")));
        List<WebElement> options = days.getOptions();
        System.out.println(options.size());
        //I have a list of webElements,
        // I need to verify if the values(numbers) are sorted in ascending order
        //list of webElement to list of String
       List<String> stringList = BrowserUtils.getElementsText(options);

       //list of String to list of ints
        List<Integer> ints = new ArrayList<>();
        for (String string:stringList) {
            ints.add(Integer.parseInt(string));
        }
        System.out.println(ints);
        //verify list of ints is sorted
        //create new class with values of the given list
        List<Integer> intsCopy = new ArrayList<>(ints);
        //sorting the copy
        Collections.sort(intsCopy);
        //compare them
        Assert.assertEquals(ints, intsCopy);
        }
        @Test
    public void google(){
        driver.get("https://www.google.com");
        WebElement feelLucky = driver.findElement(By.xpath("//input[@id='gbqfbb']"));
        actions.pause(2000).moveToElement(feelLucky).pause(2000).build().perform();
            String notExpected = "I'm Feeling Lucky";
            String button = feelLucky.getAttribute("value");
            System.out.println(button);
            Assert.assertEquals(button,notExpected);


/*
Go to google.com
Move your mouse on top of I am feeling lucky
Verify that button now has a different text
Move the mouse away
Do this many times
When you get “I am feeling stellar” 3 times,
print “Deal with it” in console and exit the program
 */

        }
    }

