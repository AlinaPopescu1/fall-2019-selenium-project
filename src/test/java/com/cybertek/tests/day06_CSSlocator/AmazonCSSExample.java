package com.cybertek.tests.day06_CSSlocator;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonCSSExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("https://amazon.com");
//<a href="/gp/goldbox?ref_=nav_cs_gb_azl"
// class="nav-a  "
// tabindex="47">Today's Deals</a>
        WebElement element = driver.
                findElement(By.cssSelector("a[tabindex='47']"));
        element.click();
        Thread.sleep(2000);
        //when you open a new page(by clicking)
        // find that moment and put a wait there,
        // after the click

        String expected = "Today's Deals";
        WebElement topHeader = driver.findElement(By.cssSelector(".nav-a-content"));
        String actual = topHeader.getText();

        if(expected.equals(actual)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expected = " + expected);
            System.out.println("topHeader = " + actual);
        }
       WebElement bottomHeader = driver.findElement(By.cssSelector("h1>div:nth-of-type(1)"));
        System.out.println(bottomHeader.getText());
        driver.close();
    }
}
