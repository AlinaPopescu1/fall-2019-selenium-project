package com.cybertek.tests.day02_Locators;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Homework {
    public static void main(String[] args) throws InterruptedException {
        /*
        Task:
     Go to amazon  https://www.amazon.com/
     Go to Ebay   https://www.ebay.com/
     Enter a search term
     Click on search button
     Verify title contains search term
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.ebay.com");
        driver.navigate().to("https://www.amazon.com/");
        driver.manage().window().maximize();

//        driver.navigate().to("https://www.ebay.com/");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Alexa amazon", Keys.ENTER);
        //because of keys.Enter we don't need to find it and click we just
        driver.findElement(By.className("nav-input")).click();
        Thread.sleep(2000);

        String expectedResult = "Alexa amazon";
        String actualResult = driver.getTitle();

        if(actualResult.contains(expectedResult)){
            System.out.println("Pass, this is expected result "+ expectedResult);
        }else{
            System.out.println("Fail, this is actual result "+ actualResult);
        }
        driver.quit();
    }
}
