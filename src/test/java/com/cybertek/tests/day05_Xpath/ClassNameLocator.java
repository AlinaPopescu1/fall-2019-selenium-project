package com.cybertek.tests.day05_Xpath;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassNameLocator {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/login");
        driver.manage().window().maximize();

        WebElement link = driver.findElement(By.className("nav-link"));
        System.out.println(link.getText());

        driver.close();


    }
}
