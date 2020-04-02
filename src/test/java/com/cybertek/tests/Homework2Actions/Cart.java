package com.cybertek.tests.Homework2Actions;
import com.cybertek.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Cart extends TestBase {
    JavascriptExecutor jse;
    WebDriverWait wait;
    @BeforeMethod
    public void waiting() {
        wait = new WebDriverWait(driver, 10);
    }
    @Test
    public void cart(){
        jse = (JavascriptExecutor) driver;
        driver.get("https://amazon.com");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("wooden spoon"+ Keys.ENTER);
        List<WebElement> allRes = driver.findElements(By.cssSelector(".a-size-base-plus.a-color-base.a-text-normal"));
        Random ran = new Random(allRes.size());
        int num = ran.nextInt(allRes.size());
        WebElement selectedItem = allRes.get(num);
        wait.until(ExpectedConditions.elementToBeClickable(selectedItem));
        selectedItem.click();
        wait.until(ExpectedConditions.elementToBeSelected(selectedItem));
        //selectedItem = allRes.get(num);
        String name = selectedItem.getText();
        System.out.println("name = " + name);
        WebElement whole = driver.findElement(By.xpath("//span[@class='a-price-whole']"));
        WebElement fraction = driver.findElement(By.xpath("//span[@class='a-price-fraction']"));
        String price = whole.getText()+"."+fraction.getText();
        System.out.println("price = " + price);

//        Select dropDwn = new Select(driver.findElement(By.cssSelector("select[name='quantity']")));
//        int expected = 1;
//        String act = dropDwn.getFirstSelectedOption().getText().trim();
//        String expected1 = String.valueOf(expected);
//        Assert.assertEquals(expected1,act);


    }
}
