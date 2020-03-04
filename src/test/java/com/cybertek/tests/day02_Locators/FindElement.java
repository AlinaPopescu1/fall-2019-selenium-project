package com.cybertek.tests.day02_Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElement {
    public static void main(String[] args) throws InterruptedException {
     //Location 1: id
        //<input
        // type="text" placeholder=""
        // name="username"
        // id="okta-signin-username"
        // value="" aria-label="" autocomplete="off">
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://cybertekschool.okta.com/");
        //write email in text box
        //first step is to find text box, then findElement() method from WebDriver Interface
        //findElement it returns WebElement object
        Thread.sleep(2000);
        WebElement emailBox=driver.findElement(By.id("okta-signin-username"));
        emailBox.sendKeys("alina.popescu.1993@gmail.com");
        Thread.sleep(2000);

        WebElement password=driver.findElement(By.id("okta-signin-password"));
        password.sendKeys("Americababy1");
        Thread.sleep(2000);

        WebElement sumbit=driver.findElement(By.id("okta-signin-submit"));
        sumbit.click();
        Thread.sleep(2000);

//        WebElement pushButton=driver.findElement(By.xpath("//*[@id=\"form8\"]/div[2]/input"));
//        pushButton.click();

        WebElement pushButton2=driver.findElement(By.cssSelector("#form8 > div.o-form-button-bar > input"));
        pushButton2.click();





    }
}
