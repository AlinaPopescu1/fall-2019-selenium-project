package com.cybertek.tests.day06_CSSlocator;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTestWithTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("https://amazon.com");

        WebElement searchInput = driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/form/div[3]/div/input"));
        //XPATH /html/body/div/header/div/div/div/div/form/div[3]/div/input
        searchInput.sendKeys("Selenium cookbook"+ Keys.ENTER);

        WebElement findIT = driver.findElement(By.xpath("//span[.='Selenium Testing Tools Cookbook - Second Edition']"));
        String iFoundIt = findIT.getText();
        Thread.sleep(2000);
        findIT.click();
        String actual = "Selenium Testing Tools Cookbook - Second Edition";

        if(iFoundIt.equals(actual)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("iFoundIt = " + iFoundIt);
            System.out.println("actual = " + actual);
            driver.close();
        }


    }
}
