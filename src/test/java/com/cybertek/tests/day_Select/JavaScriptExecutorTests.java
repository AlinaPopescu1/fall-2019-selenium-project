package com.cybertek.tests.day_Select;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorTests {
    WebDriver driver;
    JavascriptExecutor jse;
    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("Chrome");
        jse = (JavascriptExecutor) driver;
    }

    @Test
    public void scroll() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com");
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        Thread.sleep(3000);
        jse.executeScript("arguments[0].scrollIntoView(true);", link);
        Thread.sleep(3000);
    }
    @Test(priority = 0)
    public void sendKeysWithJS() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement input = driver.findElement(By.cssSelector("input[disabled]"));
        String text = "hi world";
        Thread.sleep(2000);
        jse.executeScript("arguments[0].setAttribute('value', '"+text+"')", input);
        Thread.sleep(2000);
        //arguments[0].setAttribute('value','Hello World');--> explanation
    }
    @AfterMethod
    public void afterTest() { driver.quit();
    }

}
