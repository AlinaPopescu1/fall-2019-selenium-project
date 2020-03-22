package com.cybertek.tests.day06_CSSlocator;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSSlocator {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        driver.manage().window().maximize();

        WebElement css = driver.findElement(By.cssSelector("button[onclick='button1()']"));

        System.out.println(css.getText());
        Thread.sleep(2000);
        driver.quit();
    }
}
