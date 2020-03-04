package com.cybertek.tests.day01_NAVIGATION;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class FirstClass {
    public static void main(String[] args) throws InterruptedException {
        //binary the driver and browsers
        //1.set up the webdriver manager
        //connection the driver with the browser
        WebDriverManager.chromedriver().setup();
        //I have a driver object from WebDriver Interface
        //command and hover over
        //create our driver
        WebDriver driver = new ChromeDriver();
        //command and hover over
        //i want to open Google home page
      //  driver.get("https://www.facebook.com");
       // driver.navigate().to("https://www.facebook.com");
        //shortcut ctrl space or return
       // driver.navigate().back();
       // driver.get("https://www.google.com");
      //  Thread.sleep(2000);
       // driver.navigate().to("http://practice.cybertekschool.com");
      //  driver.navigate().back();
       // driver.findElement(By.id("Dropdown"));
        //navigate().forward--> navigate one step forward
        //for the 1st time we will use get then navigate
        driver.get("http://practice.cybertekschool.com");
        Thread.sleep(3000);
        driver.navigate().to("https://www.google.com");
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();

        driver.findElement(By.linkText("About")).click();

    }

    public static class SecondClass {
        public static void main(String[] args) throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            WebDriver driver  = new ChromeDriver();
            driver.manage().window().fullscreen();
    //       driver.manage().window().maximize();

            String webURL = "http://practice.cybertekschool.com";
            driver.get(webURL);
            Thread.sleep(3000);

            String google = "https://www.google.com";
            driver.navigate().to(google);
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
            driver.navigate().refresh();
            Thread.sleep(2000);
            driver.navigate().forward();
            driver.findElement(By.linkText("Gmail")).click();
            driver.findElement(By.linkText("For Work")).click();




        }
    }
}
