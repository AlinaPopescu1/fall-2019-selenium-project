package com.cybertek.tests.day04_Xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextMethodFromXpath {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/context_menu");

        WebElement context = driver.findElement(By.xpath("//h3[text()='Context Menu']"));
        String actual = context.getText();

        boolean var = context.equals(actual);
        System.out.println("var = " + var);
        Thread.sleep(2000);

        driver.close();


    }
}
