package com.cybertek.tests.OlimpicsHomework3;
import com.cybertek.base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class OlympicsMethodCaseTwo extends TestBase {
    @Test(description="the first from the bottom")
    public void tc2FirstFromBottomTest(){
        driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");
       // assertEquals(getCountryWithLeastGold(), "Italy");
    }
    private String getCountryWithLeastGold() {
        //number of medals
     String xpath =
             "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr//th/../td[2]";
        List<WebElement> cells = driver.findElements(By.xpath(xpath));
        List<String> medalsNumber = BrowserUtils.getElementsText(cells);
        List<Integer> numsOfMedals = new ArrayList<>();
        for (String each : medalsNumber) {
          numsOfMedals.add(Integer.parseInt(each));
        }
        // 10 countries
        String xPathCountries =
                "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//tbody//tr//th//a";
        List<WebElement> countries = driver.findElements(By.xpath(xpath));
        List<String> countriesText = BrowserUtils.getElementsText(countries);
        String country = "";
        for (int i = 0; i < numsOfMedals.size() ; i++) {
            int min = numsOfMedals.get(0);
            if(numsOfMedals.get(i) < min){
                min = numsOfMedals.get(i);
            }
            System.out.println(min);

        }
        return "";
    }
}
