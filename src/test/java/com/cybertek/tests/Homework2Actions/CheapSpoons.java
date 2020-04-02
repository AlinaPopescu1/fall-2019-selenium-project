package com.cybertek.tests.Homework2Actions;
import com.cybertek.base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
public class CheapSpoons extends TestBase {
    @Test
    public void prime() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("wooden spoon"+ Keys.ENTER);
        WebElement department = driver.findElement(By.xpath("(//span[contains(text(),'Kitchen & Dining')])[2]"));
        wait.until(ExpectedConditions.visibilityOf(department));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        department.click();
        WebElement under = driver.findElement(By.xpath("(//span[contains(text(),'Under')])[1]"));
        under.click();
        
        List<WebElement> listPrices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
        List<String> allPrices = BrowserUtils.getElementsText(listPrices);
        System.out.println("allPrices = " + allPrices);
        List<Integer> intPrices = new ArrayList<>();
        for (String each:allPrices) {
            each = each.replace("$", "");
            intPrices.add(Integer.parseInt(each));
            for (Integer eachPrice:intPrices) {
                    Assert.assertTrue(eachPrice<25);// actual is false
                }
            }
        }
    }

