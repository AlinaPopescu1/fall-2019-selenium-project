package com.cybertek.tests.OfiiceHours;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class NestedIframes {
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
    public void test() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/nested_frames");
        WebElement frameMain = driver.findElement(By.name("frame-top"));
        //we want to land to main frame in order to get to the inside frame
        //one frame has 3 others inside
        Thread.sleep(2000);
        driver.switchTo().frame(frameMain);
          Thread.sleep(2000);
        List<WebElement> listOfFrames = driver.findElements(By.xpath("//frame"));

        for (WebElement eachFrame:listOfFrames) {
            Thread.sleep(2000);
            driver.switchTo().frame(eachFrame);
            String bodyText = driver.findElement(By.tagName("body")).getText();
            System.out.println(bodyText);
            driver.switchTo().parentFrame();
        }
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        String bodyText = driver.findElement(By.tagName("body")).getText();
        System.out.println(bodyText);
        driver.switchTo().parentFrame();
    }
}
