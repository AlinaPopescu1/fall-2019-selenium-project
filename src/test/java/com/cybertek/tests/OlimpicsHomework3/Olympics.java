package com.cybertek.tests.OlimpicsHomework3;
import com.cybertek.base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Olympics extends TestBase {
    @Test
    public void test1() {
        driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");
        //verify if MedalRank is sorted by rank in ascending order
        WebElement table = driver.findElement(
                By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']"));

        List<WebElement> numbers = driver.findElements(
                By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//td/..//td[1]"));

        for (int j = 1; j <= numbers.size() - 2; j++) {
            String xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//td[.='" + j + "']";
            WebElement cell = driver.findElement(By.xpath(xpath));
            List<Integer> nums = Collections.singletonList(Integer.parseInt(cell.getText()));
            System.out.print(nums.toString());

            for (int i = 0; i < nums.size() - 1; i++) {
                Assert.assertTrue(nums.get(i) < nums.get(i + 1));
            }
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement
                (By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//thead//tr//th[2]")).click();
        List<WebElement> countries = driver.findElements
                (By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr//th//a"));
        System.out.println(BrowserUtils.getElementsText(countries));

        for (int i = 0; i < countries.size() - 1; i++) {
            Assert.assertTrue(countries.get(i).getText().compareTo(countries.get(i + 1).getText()) < 0);
        }
        //verify is not acs anymore

        List<WebElement> numsChanged = driver.findElements(By.xpath
                ("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr/..//tr//td[1]"));
        List<String> listStr = BrowserUtils.getElementsText(numsChanged);
        System.out.println("listStr = " + listStr.toString());
        //remove the 11-86



        }
    }













