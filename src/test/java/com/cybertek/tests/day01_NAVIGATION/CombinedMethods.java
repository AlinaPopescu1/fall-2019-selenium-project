package com.cybertek.tests.day01_NAVIGATION;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class CombinedMethods {
    public static void main(String[] args) throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();

        SafariDriver driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        Thread.sleep(1000);


        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        String google = "Google";
        String ActualGoogle = driver.getTitle();

        driver.navigate().to("https://www.etsy.com/");

        String etsy = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        String ActualEtsy = driver.getTitle();

        if(google.equals(ActualGoogle)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }

        driver.navigate().forward();

        if(etsy.equals(ActualEtsy)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }
        driver.quit();
    }
}
