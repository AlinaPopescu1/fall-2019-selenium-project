package com.cybertek.tests.day_Select;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopUp {
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
    public void htmlPopup() throws InterruptedException {
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        driver.findElement(By.xpath("//span[text()='Destroy the World']")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//span[.='No']")).click();
    }
    @Test
    public void jsAlerts() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        WebElement button1 = driver.findElement(By.xpath("//button[1]"));
        button1.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.dismiss();
    }
    @Test
    public void jsAlerts2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        WebElement button2 = driver.findElement(By.xpath("//button[2]"));
        button2.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();
    }
    @Test
    public void jsAlertsSendkeys(){
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        WebElement button3= driver.findElement(By.xpath("//button[3]"));
        Alert alert = null;
        try {
            alert = driver.switchTo().alert();
            alert.sendKeys("Admiral Kunkka");
            alert.accept();

        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }
}
