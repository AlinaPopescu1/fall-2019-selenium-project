package com.cybertek.tests.Homework2Actions;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class TodaysdateTask {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("Chrome");
    }

//    @AfterMethod
//    public void afterTest() {
//        driver.quit();
//    }
    //TODO 1. go to http://practice.cybertekschool.com/dropdown
    //TODO 2. verify that dropdowns under Select your date of birth display current year, month, day

    @Test
    public void TodayDate(){
        driver.get("http://practice.cybertekschool.com/dropdown");
        Select year = new Select(driver.findElement(By.id("year")));
        Select month = new Select(driver.findElement(By.id("month")));
        Select day = new Select(driver.findElement(By.id("day")));

        int expected = LocalDate.now().getYear();
        String actual = year.getFirstSelectedOption().getText();
        int actualYear = Integer.parseInt(actual);
        System.out.println("actualYear = " + actualYear);
        Assert.assertEquals(expected, actualYear);

        String expectedMonth = LocalDate.now().getMonth().
                name().toLowerCase().replace("m", "M");
        String actualMonth = month.getFirstSelectedOption().getText();
        System.out.println("actualMonth = " + actualMonth);
        Assert.assertEquals(expectedMonth,actualMonth);

        int expectedDay = LocalDate.now().getDayOfMonth();
        String actualDay = day.getFirstSelectedOption().getText();
       // int actualDAY = Integer.parseInt(actualDay);
        System.out.println("actualDAY = " + actualDay);
        Assert.assertEquals(actualDay, ""+expectedDay);

    }
}
