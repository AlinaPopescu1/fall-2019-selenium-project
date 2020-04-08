package com.cybertek.tests.OlimpicsHomework3;
import com.cybertek.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
public class OlympicsTestTwo extends TestBase {
    @Test
    public void test2() {
        gettingCountry("silver");
        gettingCountry("Gold");
        gettingCountry("Bronze");
    }
    public void gettingCountry(String color) {
        color = color.toLowerCase();
        if (color.equals("bronze")) {
            color = "#c96";
        }
        String xpath = "//th[@style='width:4em;background-color:" + color + "']";
        driver.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement medal = driver.findElement(By.xpath(xpath));
        medal.click();
        WebElement firstCountry = driver.findElement(By.xpath("//table[9]/tbody/tr[1]/th"));
        System.out.println(firstCountry.getText());
    }
}
