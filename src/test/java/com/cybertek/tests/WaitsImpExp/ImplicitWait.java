package com.cybertek.tests.WaitsImpExp;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class ImplicitWait {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }
//    @AfterMethod
//    public void afterTest() {
//        driver.quit();
//    }

    @Test
    public void thread() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        WebElement msg = driver.findElement(By.cssSelector("#finish>h4"));
        //find the element that has id = finish,
        // # is id, with child h4
        Assert.assertTrue(msg.isDisplayed());
        System.out.println("msg.getText() = " + msg.getText());
    }
        @Test
        public void test1(){
            driver.get("http://practice.cybertekschool.com/dynamic_loading/4");
            WebElement message = driver.findElement(By.cssSelector("#finish>h4"));
            Assert.assertTrue(message.isDisplayed());
            System.out.println(message.getText());
            driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
            WebElement button = driver.findElement(By.tagName("button"));
            button.click();
            message = driver.findElement(By.cssSelector("#finish>h4"));
            Assert.assertTrue(message.isDisplayed());
            System.out.println(message.getText());
    }
}
