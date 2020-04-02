package com.cybertek.tests.Homework2Actions;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ValidLinks {
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
    public void links() {
        driver.get(" https://www.selenium.dev/documentation/en/");
        List<WebElement> aLinks = driver.findElements(By.tagName("a"));
        System.out.println("aLinks size = " + aLinks.size());
        int count = 1;
        for (int i = 0; i <aLinks.size() ; i++) {
            if ((aLinks.get(i).getAttribute("href")) == null) {
                System.out.println("Link " + count++ + " : " + aLinks.get(i).getAttribute("href"));
            }else{
                System.out.println("Link " + count++ + " : " + aLinks.get(i).getAttribute("href"));
            }
        }
        Assert.assertNotNull(aLinks.toString());
            }
        }

