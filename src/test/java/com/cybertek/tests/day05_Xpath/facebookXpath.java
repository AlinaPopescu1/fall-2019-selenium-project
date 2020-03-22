package com.cybertek.tests.day05_Xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class facebookXpath {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();

        WebElement login = driver.findElement(By.xpath("//html/body/div/div[2]/div/div/div/div/div[2]/form/table/tbody/tr[2]/td/input"));
        login.sendKeys("alina.popescu.1993@gmail.com");
        System.out.println(login.getTagName());
        Thread.sleep(2000);
        driver.close();
    }
}
