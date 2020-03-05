package com.cybertek.tests.Day03_Selenium3;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class VeriFyLogin {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");
        driver.manage().window().maximize();

        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        Thread.sleep(3000);
        driver.findElement(By.id("wooden_spoon")).click();

        WebElement actualMsg = driver.findElement(By.tagName("h4"));
        String expMsg = "Welcome to the Secure Area. When you are done click logout below.";
        //we can't compare String with WebElement(data type)

        String actualMessage = actualMsg.getText();
        // String getText(); method that belongs to WebElement interface

        Thread.sleep(2000);
        if (actualMessage.equals(expMsg)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
        driver.close();
    }
}
