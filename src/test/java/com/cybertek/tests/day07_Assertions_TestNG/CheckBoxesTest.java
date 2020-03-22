package com.cybertek.tests.day07_Assertions_TestNG;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxesTest {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");
    }

    @AfterMethod
    public void afterTest(){
        driver.quit();
    }
    @Test
    public void test1(){
        WebElement checkbox1 = driver.findElement(By.xpath("//input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[2]"));
        //by default one is checked, two is checked
        Assert.assertTrue(checkbox2.isSelected());
        Assert.assertFalse(checkbox1.isSelected());
        System.out.println("Check the 1st checkbox");
        checkbox1.click();
        System.out.println("is one selected "+checkbox1.isSelected());
        System.out.println("is two selected "+checkbox2.isSelected());

        Assert.assertTrue(checkbox1.isSelected());
        Assert.assertTrue(checkbox2.isSelected());
    }
}
