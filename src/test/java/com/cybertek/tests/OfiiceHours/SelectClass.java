package com.cybertek.tests.OfiiceHours;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class SelectClass {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("Chrome");
    }
    /*
 go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellTable
select option Coworkers
verify that that Coworkers is now selected
select options Contacts
verify that contacts is selected
 */
    @Test
    public void test() throws InterruptedException {
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellTable");
        Thread.sleep(2000);
        WebElement values = driver.findElement(By.cssSelector("select[tabindex='-1']"));
        Select table = new Select(values);
        //getOptions--> gives all available options as a list of elements
        List<WebElement> allOptions = table.getOptions();
        System.out.println("Alloptions.size() = " + allOptions.size());
        List <String> expectedOptions = Arrays.asList("Family", "Friends", "Coworkers", "Businesses", "Contacts");
        //given a list of webElements, extract the text of the elements into new List of Strings
        List<String> allOptionsStr = BrowserUtils.getElementsText(allOptions);
        Assert.assertEquals(expectedOptions, allOptionsStr);
    }
    @Test
    public void test2() throws InterruptedException {
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCellTable");
        Thread.sleep(2000);
        Select categories = new Select(driver.findElement(By.cssSelector("select[tabindex='-1']")));
         //select option Coworkers
        categories.selectByVisibleText("Coworkers");
        // verify that that Coworkers is now selected
        // getFirstSelectedOption --> returns the currently selected option as Web element
        categories = new Select(driver.findElement(By.cssSelector("select[tabindex='-1']")));
        String actual = categories.getFirstSelectedOption().getText();
        Assert.assertEquals(actual, "Coworkers");
        categories = new Select(driver.findElement(By.cssSelector("select[tabindex='-1']")));
        categories.selectByVisibleText("Contacts");

        categories = new Select(driver.findElement(By.cssSelector("select[tabindex='-1']")));
        String actual1 = categories.getFirstSelectedOption().getText();

        Assert.assertEquals(actual1, "Contacts");
        }

    @AfterMethod
    public void afterTest() { driver.quit();
    }
}
