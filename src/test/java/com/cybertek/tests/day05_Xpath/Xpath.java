package com.cybertek.tests.day05_Xpath;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Xpath {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/floating_menu");
        driver.manage().window().maximize();

        WebElement button1 = driver.findElement(By.xpath("//button[@onclick='button1()'"));
        System.out.println(button1.getText());
        driver.close();

    }
}
