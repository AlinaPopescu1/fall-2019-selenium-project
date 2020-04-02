package com.cybertek.tests.Homework2Actions;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Links {
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
    public void w3schools(){
        driver.get("https://www.w3schools.com/");
        List<WebElement> elementTag = driver.findElements(By.tagName("a"));

        for (WebElement each : elementTag){
            if(each.isDisplayed()){
                System.out.println("Displayed: "+each.getText()+"\n with href value: "+each.getAttribute("href"));
            }
        }
    }
}
