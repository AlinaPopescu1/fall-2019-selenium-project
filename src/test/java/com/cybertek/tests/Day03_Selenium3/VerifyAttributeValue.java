package com.cybertek.tests.Day03_Selenium3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyAttributeValue {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");
        driver.manage().window().maximize();

        String userNameBox = driver.findElement(By.name("username")).getAttribute("type");
        System.out.println("Value of type is :"+userNameBox);

        //<button class="btn btn-primary" type="submit" id="wooden_spoon">Login</button>
        WebElement loginButton = driver.findElement(By.id("wooden_spoon"));
        System.out.println(loginButton.getAttribute("class"));




    }
}
