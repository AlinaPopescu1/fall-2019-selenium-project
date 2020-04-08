package com.cybertek.tests.OfiiceHours;
import com.cybertek.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class IframeExample extends TestBase {
    @Test
    public void frame(){
        driver.get
                ("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
        driver.switchTo().frame("iframeResult");
        System.out.println(driver.findElement(By.tagName("h2")).getText());
        WebElement innerFrame = driver.findElement(By.xpath("//iframe[@src='demo_iframe.htm']"));
        driver.switchTo().frame(innerFrame);
        //If I want to get to the inner frame I have to switch to it first
        System.out.println(driver.findElement(By.tagName("h1")).getText());
        //I have to go back the the originla/default frame in order to reach the doc text
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.cssSelector(".cm-m-xml.cm-meta")).getText());


    }
}
