package com.cybertek.tests.day01_NAVIGATION;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyTitle {
    public static void main(String[] args) {
        //go to practice website
        //verify title
        //1st step is to do it manually
        //connect browser and driver
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com");
        driver.manage().window().maximize();
        String expectedResult = "practice";
        String actualResult = driver.getTitle();

        if (expectedResult.equals(actualResult)){
            System.out.println("Test passed");
        }else {
            System.out.println("Fail");
            System.out.println("actualResult=" + actualResult + " expectedResult=" + expectedResult);
        }
        driver.close();

    }
}
