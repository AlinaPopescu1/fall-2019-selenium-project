package com.cybertek.tests.OlimpicsHomework3;
import com.cybertek.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Olympics extends TestBase {
    @Test
    public void test1(){
        driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");
        //verify if MedalRank is sorted by rank in ascending order
        WebElement table = driver.findElement(
                By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']"));
        List<WebElement> numbers = driver.findElements(
                By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//td/..//td[1]"));
        //size is 12 i need the first 10
        int columnSize = numbers.size()-2;
        for (int i = 1; i <= columnSize; i++) {
            String xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//td[.='"+i+"']";
            WebElement cell = driver.findElement(By.xpath(xpath));
            System.out.println(cell.getText());

        }
    }
}
