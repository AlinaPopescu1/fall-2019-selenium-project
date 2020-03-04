package com.cybertek.tests.day01_NAVIGATION;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class EtsyVerifiTitle {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();//connect browser with the driver
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.etsy.com");
        driver.manage().window().maximize();

        String expectedResult = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        String actualResult = driver.getTitle();//getTitle() returns a String

        if(expectedResult.equals(actualResult)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Expected result is "+expectedResult);
            System.out.println("Actual result is "+actualResult);
        }
        driver.close();//or quit
    }
}
