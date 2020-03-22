package com.cybertek.tests.PracticeME;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RelativeXPATH {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/floating_menu");
        driver.manage().window().maximize();

        WebElement floating = driver.findElement(By.xpath("//h3[text()='Floating Menu']"));
        String expected = floating.getText();
        String actualResult = "Floating Menu";
        
        boolean var = expected.equalsIgnoreCase(actualResult);
        System.out.println("var = " + var);
        Thread.sleep(2000);
        driver.close();


    }
}
