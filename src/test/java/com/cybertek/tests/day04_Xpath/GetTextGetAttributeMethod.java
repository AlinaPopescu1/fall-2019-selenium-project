package com.cybertek.tests.day04_Xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextGetAttributeMethod {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.manage().window().maximize();
        WebElement pass = driver.findElement(By.id("form_submit"));
        System.out.println(pass.getAttribute("type"));
        System.out.println(pass.getAttribute("class"));
        driver.close();
    }
}
