package com.cybertek.tests.day01_NAVIGATION;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class VerifyPracticeURL {
    public static void main(String[] args) {

        //WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com");
        driver.manage().window().maximize();

        String expectedResult = "http://practice.cybertekschool.com/";
        String actualResult = driver.getCurrentUrl();//validate if you are landed on the page


        if (expectedResult.equals(actualResult))
            System.out.println("PASS");
        else System.out.println("FAIL");
        System.out.println("I expected "+expectedResult);
        System.out.println("Actual result "+actualResult);
        driver.quit();




    }
}
