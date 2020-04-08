package com.cybertek.tests.OfiiceHours;
import com.cybertek.base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTables extends TestBase {
    @BeforeMethod
    public void setUpTests(){
        driver.get("https://www.mockaroo.com/");
        driver.findElement(By.id("num_rows")).clear();
        driver.findElement(By.id("num_rows")).sendKeys("10");
        driver.findElement(By.xpath("//button[@id='preview']")).click();
    }
    @Test
    public void testHeadersCount() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.switchTo().frame("preview_iframe");
        WebElement table = driver.findElement(By.tagName("table"));
        System.out.println(table.getText());
        //get all the headers
        List<WebElement> headers = driver.findElements(By.xpath("//table[@style]//th"));
        Assert.assertEquals(headers.size(), 6);
    }
        //verify that value under gender is either female or male
    @Test
    public void getValuesGender(){
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        List<WebElement> genders = driver.findElements(By.xpath("//table[@style]//tr//td[5]"));
        List<String> names = BrowserUtils.getElementsText(genders);

        for (WebElement gender : genders) {
                Assert.assertTrue(gender.getText().equals("Male") || gender.getText().equals("Female"));

            }
        }
    }

