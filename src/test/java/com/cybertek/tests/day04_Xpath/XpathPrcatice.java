package com.cybertek.tests.day04_Xpath;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class XpathPrcatice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/login");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id=\"login\"]/div[1]/div/input"))
                .sendKeys("tomsmith");//username
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"login\"]/div[2]/div/input"))
                .sendKeys("SuperSecretPassword");//password
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div/form/button"))
                .click();//login
        Thread.sleep(2000);
        driver.close();





    }
}
