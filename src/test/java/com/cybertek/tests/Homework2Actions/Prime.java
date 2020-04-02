package com.cybertek.tests.Homework2Actions;
import com.cybertek.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class Prime extends TestBase {
    @Test
    public void prime(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
    driver.get("https://www.amazon.com/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
    searchBox.sendKeys("wooden spoon"+ Keys.ENTER);
    String xpath = "//i[@class='a-icon a-icon-prime a-icon-medium']/../../../../../../div[2]/h2/a/span";
    WebElement first = driver.findElement(By.xpath(xpath));
    String firstPrimeLabelresult = first.getText();
    System.out.println("firstPrimeLabelresult = " + firstPrimeLabelresult);
    WebElement primeBtn = driver.findElement(By.cssSelector("i.a-icon.a-icon-checkbox"));
    primeBtn.click();
    WebElement firstResultInPrime = driver.findElement
            (By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
    String firstResultInPrimeText = firstResultInPrime.getText();
    System.out.println("firstResultInPrimeText = " + firstResultInPrimeText);
    Assert.assertEquals(firstPrimeLabelresult, firstResultInPrimeText);
    }
}

