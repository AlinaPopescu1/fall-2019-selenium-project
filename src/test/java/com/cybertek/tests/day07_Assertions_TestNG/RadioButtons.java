package com.cybertek.tests.day07_Assertions_TestNG;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Random;
public class RadioButtons {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");
    }
    /*
go to http://practice.cybertekschool.com/radio_buttons
verify the all sports checkboxes are NOT checked by default
randomly click any sport
verify that that sport is clicked
verify that all others are not clicked
repeat the last step for 5 times
     */
    @Test
    public void radioTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        List<WebElement> list = driver.findElements(By.name("sport"));
        System.out.println("verify none of them selected by default");
        System.out.println(list.size());
        //checking all the sport checkboxes are not checked
        for (int i = 0; i < list.size(); i++) {
            Assert.assertFalse(list.get(i).isSelected());
        }
        System.out.println("Start randomly selecting radio buttons");
        //randomly clicking and verifying
        for (int q = 0; q < 5; q++) {

            Thread.sleep(5000);
            Random ran = new Random();
            int num = ran.nextInt(4);
            list.get(num).click();
            System.out.println("Selecting button number: " + (num + 1));

            for (int i = 0; i < list.size(); i++) {
                if (i == num) {
                    Assert.assertTrue(list.get(num).isSelected());
                } else {
                    Assert.assertFalse(list.get(i).isSelected());
                }
            }
        }
    }
    @AfterMethod
    public void afterTest(){
        driver.quit();
    }
}
