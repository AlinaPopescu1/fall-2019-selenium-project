package com.cybertek.tests.Day03_Selenium3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorLinkText {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        driver.manage().window().maximize();

        //make it WebElement
        WebElement linktext = driver.findElement(By.linkText("Example 3: Element on page that is hidden and become visible after 5 seconds"));
        //and then convert it to String
        System.out.println(linktext.getText());//I made it a String

        WebElement linkTextLocator = driver.findElement(By.linkText("Cybertek School"));

        String asString = linkTextLocator.getText();
        System.out.println(asString);

        WebElement homeElement = driver.findElement(By.linkText("Home"));
        String homeAsString = homeElement.getText();
        System.out.println(homeAsString);
        // output: Example 3: Element on page that is hidden and become visible after 5 seconds
        driver.quit();
    }
}
