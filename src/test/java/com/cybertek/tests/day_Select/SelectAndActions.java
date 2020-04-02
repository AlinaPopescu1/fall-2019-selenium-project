package com.cybertek.tests.day_Select;

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
import java.util.*;

public class SelectAndActions {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
    }


    @Test
    public void getSelectedOption() {
        //find the element that has select tag
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        //create a select class using web element
        Select dropDownList = new Select(dropdown);
        //get the selected option
        WebElement selectedOption = dropDownList.getFirstSelectedOption();
        System.out.println("selectedOption = " + selectedOption);
        //verify selected option
        Assert.assertEquals(selectedOption.getText(), "Please select an option");
    }

    @Test
    public void selectFromList() throws InterruptedException {
        //get the element with select tag
        WebElement dropdown = driver.findElement(By.id("state"));
        Select states = new Select(dropdown);
        //TODO selectByVisibleText--> select by the text of the options
        states.selectByVisibleText("Iowa");
        Thread.sleep(1000);
        states.selectByVisibleText("Maryland");
        Thread.sleep(1000);
        states.selectByVisibleText("California");
        Thread.sleep(1000);
        //TODO selectByIndex() --> zero based count
        states.selectByIndex(8);
        Thread.sleep(1000);
        states.selectByIndex(3);
        Thread.sleep(1000);
        states.selectByIndex(2);
        Thread.sleep(1000);
        //TODO selectByValue --> selects based on the value attribute of the option
        //TODO it's not select text
        states.selectByValue("AL");
        Thread.sleep(1000);
        states.selectByValue("DE");
        Thread.sleep(1000);
        states.selectByValue("MD");
        Thread.sleep(1000);
    }
    @Test
    public void getAllAvailableOptions() {
        Select monthsList = new Select(driver.findElement(By.id("month")));
        //print the current selection
        System.out.println(monthsList.getFirstSelectedOption().getText());

        System.out.println("LIST OF MONTHS");
        List<WebElement> allOptions = monthsList.getOptions();
        System.out.println("Number of months: " + allOptions.size());

        for (WebElement month : allOptions) {
            System.out.println(month.getText());
        }

        //TODO verify that list always shows the current month
        //get current month using java
        String expected = LocalDate.now().getMonth().name();
        String actual = monthsList.getFirstSelectedOption().getText();
        Assert.assertEquals(expected.toLowerCase(), actual.toLowerCase());

        //TODO verify that list has following values: January...December
        List<String> expectedMonths = Arrays.asList("January", "February", "March",
                "April", "May", "June", "July", "August",
                "September", "October", "November", "December");
        //get options gives me list of WebElements, so allOptions is list of webElements
        //but my expected it a list of strings, i have to make sure both list are string
        //I need to get list String from list of WebElement
        List<String> actualMonths = new ArrayList<>();
        for (WebElement option : allOptions) {
            actualMonths.add(option.getText());
        }
        Assert.assertEquals(expectedMonths, actualMonths);
    }
    @Test
    public void verifyOptions(){
        Select list = new Select(driver.findElement(By.id("dropdown")));
        //verify list has 3 options
        int expSize = 3;
        int actualSize = list.getOptions().size();

        Assert.assertEquals(expSize, actualSize);

        List<String> expectedValues = Arrays.asList("Please select an option", "Option 1", "Option 2");

        List<String> actualValue = new ArrayList<>();
        for (WebElement option:list.getOptions()) {
            actualValue.add(option.getText());
        }
        Assert.assertEquals(actualValue, expectedValues);
    }
    @AfterMethod
    public void afterTest() {
        // driver.quit();
    }
}

