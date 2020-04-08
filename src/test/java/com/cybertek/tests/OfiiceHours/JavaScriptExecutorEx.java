package com.cybertek.tests.OfiiceHours;
import com.cybertek.base.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class JavaScriptExecutorEx extends TestBase {
    @Test
    public void test(){
        driver.get(ConfigurationReader.getProperty("url"));
        driver.findElement(By.linkText("Dynamic Controls")).click();

        WebElement webE = driver.findElement(By.cssSelector("#input-example>input"));
        //this class let's you speak to browser in javascript language
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        String text = "hello";
        jse.executeScript("arguments[0].setAttribute('value', '"+text+"')", webE);
    }
    @Test
    public void highlight() throws InterruptedException {
        driver.get(ConfigurationReader.getProperty("url"));
        Thread.sleep(1000);
        WebElement text = driver.findElement(By.tagName("h1"));
        highlight(text);
        List<WebElement> list = driver.findElements(By.cssSelector("li>a"));
        for (WebElement link : list) {
            highlight(link);
        }
    }
    public static void highlight(WebElement element) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        Thread.sleep(200);
        jse.executeScript("arguments[0].removeAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        Thread.sleep(200);
        }
    }
