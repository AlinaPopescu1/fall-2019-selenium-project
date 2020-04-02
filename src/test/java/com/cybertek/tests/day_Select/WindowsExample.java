package com.cybertek.tests.day_Select;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowsExample {
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
    public void window(){
        driver.get("http://practice.cybertekschool.com/windows");
        WebElement window = driver.findElement(By.linkText("Click Here"));
        window.click();
        
       Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandel : windowHandles) {
            System.out.println(windowHandel);
        }
        //get id of current window
        String currentWindow = driver.getWindowHandle();
        System.out.println("currentWindow = " + currentWindow);
        System.out.println("Before switching");
        WebElement window2 = driver.findElement(By.tagName("h3"));
        System.out.println(window2.getText());

        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals("New Window")) {
                break;//once u find it, stop switching
            }
        }
        System.out.println("AFTER SWITCHING");
        System.out.println(driver.getTitle());
        System.out.println(driver.findElement(By.tagName("h3")).getText());
        }
    }

