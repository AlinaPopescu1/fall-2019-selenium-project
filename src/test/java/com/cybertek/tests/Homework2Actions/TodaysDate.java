package com.cybertek.tests.Homework2Actions;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class TodaysDate {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("Chrome");
    }

//    @AfterMethod
//    public void afterTest() {
//        driver.quit();
//    }

    @Test
    public void todayDate(){
        driver.get("http://practice.cybertekschool.com/dropdown");
        Select year = new Select(driver.findElement(By.id("year")));
        Select month = new Select(driver.findElement(By.id("month")));
        Select day = new Select(driver.findElement(By.id("day")));

        int expected = LocalDate.now().getYear();
        String actual = year.getFirstSelectedOption().getText();
        int actualYear = Integer.parseInt(actual);
        System.out.println("actualYear = " + actualYear);
        Assert.assertEquals(expected,actualYear);

        String expectedMonth = LocalDate.now().getMonth().name().toLowerCase().replace("m", "M");
        String actualMonth = month.getFirstSelectedOption().getText();
        System.out.println("expectedMonth = " + expectedMonth);
        Assert.assertEquals(actualMonth, expectedMonth);

        int expected2 = LocalDate.now().getDayOfMonth();
        String actual2 = day.getFirstSelectedOption().getText();
        int actualDay = Integer.parseInt(actual2);
        System.out.println("actualDay = " + actualDay);
        Assert.assertEquals(expected2,actualDay);
    }
}
