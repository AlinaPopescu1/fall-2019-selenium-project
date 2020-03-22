package com.cybertek.tests.day07_Assertions_TestNG;

        import com.cybertek.utilities.WebDriverFactory;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.testng.Assert;
        import org.testng.annotations.AfterMethod;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.Test;

public class RadioButtonsTest {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("Firefox");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
    }
    @Test
    public void test1() {
        WebElement blue = driver.findElement(By.id("blue"));
        System.out.println(blue.isSelected());
        //verify if the button is selected
        Assert.assertTrue(blue.isSelected());
        WebElement red = driver.findElement(By.id("red"));
        System.out.println(!red.isSelected());
        //OR
        Assert.assertFalse(red.isSelected());
    }
    @Test
    public void test2(){
        WebElement redB = driver.findElement(By.id("red"));
        redB.click();
        WebElement blue = driver.findElement(By.id("blue"));
        Assert.assertFalse(blue.isSelected());
        Assert.assertTrue(redB.isSelected());

        }
    @AfterMethod
    public void afterTest(){
        driver.quit();
    }
}