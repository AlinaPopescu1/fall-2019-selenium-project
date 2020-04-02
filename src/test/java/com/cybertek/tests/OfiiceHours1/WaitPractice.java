package com.cybertek.tests.OfiiceHours1;
import com.cybertek.base.TestBase;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitPractice extends TestBase {
         @Test
         public void testWait(){
         driver.get("http://qa3.vytrack.com");
/*
http://qa3.vytrack.com
salesmanager110
UserUser123
 */
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         WebDriverWait wdw = new WebDriverWait(driver, 10);
         wdw.until(ExpectedConditions.titleIs("Login"));
         WebElement username = driver.findElement(By.id("prependedInput"));
         username.sendKeys("salesmanager110");
         WebElement password = driver.findElement(By.id("prependedInput2"));
         password.sendKeys("UserUser123");
         password.submit();


 }
}
