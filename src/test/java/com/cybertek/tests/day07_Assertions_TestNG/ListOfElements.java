package com.cybertek.tests.day07_Assertions_TestNG;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
    }
    @AfterMethod
    public void afterTest(){
        driver.quit();
    }
    /*
    go to page radio buttons
    verify that none of  the radio buttons are selected
     */
    @Test
    public void listOfRadioButtons() {
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        List<WebElement> list = driver.findElements(By.xpath("//label[@class='form-check-label'] [@for]"));
        //if the locator doesn't match, it returns empty list, no Exception
        System.out.println(list.size());
        for (WebElement radioButton : list) {
            System.out.println(radioButton.getText());
        }
    }
           /*
    go to practice website
    get all the links present in the page
    print their text
     */
        @Test
        public void getAllLinksTest(){
            driver.get("http://practice.cybertekschool.com");
            // get all the links in a page
            List<WebElement> links = driver.findElements(By.tagName("a"));
            System.out.println(links.size());
            // get the text of each link and print
            for (WebElement link : links) {
                System.out.println(link.getText());
            }
    }
}
