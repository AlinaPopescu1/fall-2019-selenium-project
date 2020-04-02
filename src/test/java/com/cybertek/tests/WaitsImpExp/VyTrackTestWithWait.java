package com.cybertek.tests.WaitsImpExp;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VyTrackTestWithWait {
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
    public void vytrack(){
        driver.get("http://qa3.vytrack.com");
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("salesmanager110");
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        password.submit();

        WebElement pageName = driver.findElement(By.cssSelector(".oro-subtitle"));
        Assert.assertEquals(pageName.getText(), "Dashboard");
        Assert.assertEquals(driver.getTitle(), "Dashboard");


    }
}
