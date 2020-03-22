package com.cybertek.tests.day07_Assertions_TestNG;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AmazonElementsList {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
    }
//    @AfterMethod
//    public void afterTest(){
//        driver.quit();
//    }

    @Test
    public void AmazonList(){
        driver.get("https://www.amazon.com/");
        WebElement input = driver.findElement(By.id("twotabsearchtextbox"));
        input.sendKeys("paper towels"+ Keys.ENTER);

        List<WebElement> allResults = driver.findElements(By.cssSelector("span.a-size-base-plus"));
        System.out.println("Number of results: "+ allResults.size());

            System.out.println(allResults.get(0).getText());
            System.out.println(allResults.get(allResults.size()-1).getText());


        }
    }

