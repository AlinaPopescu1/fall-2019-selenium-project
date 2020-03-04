package com.cybertek.tests.day02_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookIt {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://cybertek-reservation-qa.herokuapp.com/");
        driver.manage().window().maximize();

        String expectedResult="bookit";
        String actualResult=driver.getTitle();

        String url="cybertek-reservation";
        String getUrl = driver.getCurrentUrl();

        if (expectedResult.equals(actualResult))
            System.out.println("PASS");
        else System.out.println("FAIL");
        System.out.println("I expected "+expectedResult);
        System.out.println("Actual result "+actualResult);

        if (getUrl.contains(url))
            System.out.println("PASS");
        else System.out.println("FAIL");
        System.out.println("Get URL contains "+getUrl);
        System.out.println("Actual result "+url);
        driver.quit();

    }
}

