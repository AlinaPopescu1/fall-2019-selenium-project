package com.cybertek.tests.Homework2Actions;
import com.cybertek.base.TestBase;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;
public class YearsMonthsDays extends TestBase {
    /*
          1. go to http://practice.cybertekschool.com/dropdown
          2. select a random year under Select your date of birth
          3. select month January
          4. verify that days dropdown has current number of days
          5. repeat steps 3, 4 for all the months
          NOTE: if you randomly select a leap year, verify February has 29 days
     */
    @Test
    public void task3 () throws InterruptedException {
        driver.get(" http://practice.cybertekschool.com/dropdown");
        WebElement yearDrop =  driver.findElement(By.id("year"));
        Select yearSelect = new Select(yearDrop);
        List yearList = yearSelect.getOptions();
        System.out.println(yearList.size());
        Random rd = new Random();
        int yearNums = yearList.size();
        int randomly = rd.nextInt(yearNums);
        yearSelect.selectByIndex(randomly);
        String yearByString = yearSelect.getFirstSelectedOption().getText();
        System.out.println(yearByString);
        int yearByInt = Integer.parseInt(yearByString);
        WebElement monthDrop = driver.findElement(By.id("month"));
        Select monthSelect = new Select(monthDrop);
        List monthList = monthSelect.getOptions();
        WebElement dayDrop = driver.findElement(By.id("day"));
        Select daySelect = new Select(dayDrop);
        int i =0;
        do {
            Thread.sleep(2000);
            monthSelect.selectByIndex(i);
            // this is class which gives us a specific month in a specific year
            YearMonth yearMonthObj = YearMonth.of(yearByInt, (i+1));
            int expectedDaysInMonth = yearMonthObj.lengthOfMonth();
            // System.out.println(expectedDaysInMonth);
            List dayList = daySelect.getOptions();
            int actualDaysInMonth = dayList.size();
            Assert.assertEquals(expectedDaysInMonth, actualDaysInMonth);
            i++;
        }while (i<12);
    }
        }




