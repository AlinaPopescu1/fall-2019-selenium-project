package com.cybertek.tests.day_Select;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iFrame {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("Chrome");
    }

//    @AfterMethod
//    public void afterTest() {
//        driver.quit();
//    }

    @Test
    public void iframe() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/tinymce");
        Thread.sleep(2000);
        //TODO we will swith to iframe
        //TODO switch by id/name

        driver.switchTo().frame("mce_0_ifr");
        WebElement frame = driver.findElement(By.id("tinymce"));
        frame.clear();
        Thread.sleep(3000);
        frame.sendKeys("edited");
        //get out of the frame
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.tagName("h3")));
        //todo switch by webelement
        WebElement frame1 = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(frame1);
        frame1 = driver.findElement(By.id("tinymce"));
        frame1.clear();
        Thread.sleep(3000);
        frame1.sendKeys("edited2");
        //TODO get out of the frame
        driver.switchTo().parentFrame();
        System.out.println(driver.findElement(By.tagName("h3")).getText());
        //TODO switch by index
        driver.switchTo().frame(0);
        frame1 = driver.findElement(By.id("tinymce"));
        frame1.clear();
        Thread.sleep(3000);
        frame1.sendKeys("edited3");

    }
}
