package com.cybertek.tests.day02_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VyTrack {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://app.vytrack.com/user/login");
        driver.manage().window().maximize();

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager52");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");

        Thread.sleep(2000);
        WebElement submit = driver.findElement(By.id("_submit"));
        submit.click();
        Thread.sleep(3000);


        String expectedResult = "Dashboard";
        String actualResult = driver.getTitle();

        if(expectedResult.equalsIgnoreCase(actualResult)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }
        driver.close();
    }
}
