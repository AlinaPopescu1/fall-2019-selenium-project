package com.cybertek.tests.day01_NAVIGATION;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyURL {
    public static void main(String[] args) {
        //set up the browser itself
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.etsy.com/");
        driver.manage().window().maximize();

        //for verify title we use getTitle method
        String expectedURL = "https://www.etsy.com/";

        //for verify URL we'll use getCurrentUrl()
        String actualURL = driver.getCurrentUrl();

        if (expectedURL.equals(actualURL))
            System.out.println("PASS");
        else System.out.println("FAIL");
        System.out.println("I expected "+expectedURL);
        System.out.println("Actual result "+actualURL);
        driver.quit();
    }
}
