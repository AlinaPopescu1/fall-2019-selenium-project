package com.cybertek.tests.Day03_Selenium3;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FakePractice {
    public static void main(String[] args) throws InterruptedException {

        Faker faker = new Faker();

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");
        driver.manage().window().maximize();

        driver.findElement(By.name("username")).sendKeys(faker.name().firstName());
        driver.findElement(By.name("password")).sendKeys(faker.app().author());
        Thread.sleep(3000);
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(2000);
//        WebElement error = driver.findElement(By.id("flash"));
//        String text = error.getText();
//        System.out.println(text);

        if(driver.findElement(By.id("flash")).getText().contains("Your username is invalid!")){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }
        Thread.sleep(2000);
        driver.quit();

    }}
