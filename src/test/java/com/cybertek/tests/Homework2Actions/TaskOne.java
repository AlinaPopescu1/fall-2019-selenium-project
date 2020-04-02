package com.cybertek.tests.Homework2Actions;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Random;
public class TaskOne {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("Chrome");
    }
    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
    @Test
    public void day() throws InterruptedException {
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        Thread.sleep(2000);
         List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
         List<WebElement> checkBoxNames = driver.findElements(By.tagName("label"));

         int countFriday = 0;
         Random ran = new Random();
         while(countFriday<3){
             int num = ran.nextInt(7);
             if(checkBoxes.get(num).isEnabled()){
                 WebElement selected = checkBoxNames.get(num);
                 WebElement selectedBox = checkBoxes.get(num);
                 String selectedOption = selected.getText();
                 Thread.sleep(1000);
                 selectedBox.click();
                 System.out.println("selectedOption = " + selectedOption);
                 Thread.sleep(1000);
                 selectedBox.click();

                 if(selectedOption.equals("Friday")){
                     countFriday++;
                 }
             }
         }
        }
    }





