package com.cybertek.tests.PracticeME;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSSPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("http://google.com");
        WebElement el1 = driver.findElement(By.cssSelector("input[type^='sub'] + [id$='b']"));
        Thread.sleep(2000);
        el1.click();
        driver.get("https://www.facebook.com/");
        driver.navigate().back();

        WebElement el2 = driver.findElement(By.cssSelector("input[name='btnI'][id='gbqfbb']"));
        Thread.sleep(2000);
        el2.click();
        Thread.sleep(2000);
        WebElement review = driver.findElement(By.xpath("/html/body/div/div[3]/div/div/a[1]"));
        Thread.sleep(2000);
        review.click();
        driver.close();
    }
}
