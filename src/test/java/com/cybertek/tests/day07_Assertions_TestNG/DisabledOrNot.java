package com.cybertek.tests.day07_Assertions_TestNG;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DisabledOrNot {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
    }
    @AfterMethod
    public void afterTest(){
        driver.quit();
    }
    //verify green is disabled and verify black is enabled
    @Test
    public void disabledTest(){
        WebElement green = driver.findElement(By.id("green"));
        WebElement black = driver.findElement(By.id("black"));

        Assert.assertFalse(Boolean.parseBoolean("is green enabled? "+green.isEnabled()));
        Assert.assertFalse(Boolean.parseBoolean("is black enabled? " +black.isEnabled()));

    }
    @Test
    public void disabledWithAttribute() throws InterruptedException {
        WebElement green = driver.findElement(By.id("green"));
        WebElement black = driver.findElement(By.id("black"));
        Thread.sleep(2000);

        System.out.println("black "+black.getAttribute("disabled"));
        System.out.println("green "+green.getAttribute("disabled"));

        Assert.assertEquals(black.getAttribute("disabled"), null);
        //verify that value of black.getAttribute("disabled") is NULL
        Assert.assertNull(black.getAttribute("disabled"), null);

        // verify that certain value is equal to TRUE. verify element is DISALBED
        Assert.assertEquals(green.getAttribute("disabled"), "true");
        Assert.assertTrue(Boolean.parseBoolean(green.getAttribute("disabled")));
    }
    @Test
    public void testElementVisible() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        WebElement username = driver.findElement(By.id("username"));
        WebElement start = driver.findElement(By.tagName("button"));

        //verify username is not visible
        //isDisplayed()--> returns true if element we found is visible

        System.out.println("Username is visible "+username.isDisplayed());
        Assert.assertFalse(username.isDisplayed());

        System.out.println("click on start");
        start.click();

        Thread.sleep(7000);
        System.out.println("Username is visible: " + username.isDisplayed());
        Assert.assertTrue(username.isDisplayed());
    }
}
