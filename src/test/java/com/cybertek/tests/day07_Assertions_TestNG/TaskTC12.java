package com.cybertek.tests.day07_Assertions_TestNG;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TaskTC12 {
    private WebDriver driver;
        @BeforeMethod
        public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        }
        @DataProvider(name = "testData")
        public static Object[] testData () {

            return new Object[]{"404", "500", "301", "200"};
        }
        @Test(dataProvider = "testData")
        //(priority = 10, description = "Verify that the following message is displayed: 'This page returned a 500 status code'")
        public void statusCode (String code) {
          /*
        Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
        Step 2. And click on “Status Codes”.
        Step 3. Then click on “500”.
        Step 4. Verify that following message is displayed: “This page returned a 500 status code”
         */
            WebElement statusCodes = driver.findElement(By.cssSelector("li>a[href='/status_codes']"));
            statusCodes.click();
            WebElement fiveHundreed = driver.findElement(By.linkText(code));
            fiveHundreed.click();
            String expected = "This page returned a " + code + " status code";
            WebElement text = driver.findElement(By.xpath("//p"));
            String actual = text.getText();

            if (actual.contains(expected)) {
                System.out.println("TRUE");
            } else {
                System.out.println("FAIL");
                System.out.println("expected = " + expected);
                System.out.println("actual = " + actual);
            }  //OR
            Assert.assertTrue(actual.contains(expected), "The statis code does not exist");
        }
                @AfterMethod
                public void tearDown () {
                    driver.close();
                }
            }


