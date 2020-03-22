package com.cybertek.tests.day06_CSSlocator;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Day07_Practice {
    public static void main(String[] args) throws InterruptedException {
      //  practiceTests();
        secondNameTest();
    }


    private static void secondNameTest() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");

        driver.get("https://amazon.com");
        String searchItem = "disinfectant wipes";
        WebElement searchInput = driver.findElement(By.id("twotabsearchtextbox"));
        //enter search term and hit enter
        //OPTION 1
        // searchInput.sendKeys(searchItem+ Keys.ENTER);
        //OPTION 2
        searchInput.sendKeys(searchItem);
        WebElement srchButton = driver.findElement(By.className("nav-input"));
        srchButton.click();
        Thread.sleep(2000);

        WebElement secondResult = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[2]"));
        System.out.println(secondResult.getText());

        String expectedResult = secondResult.getText();
        secondResult.click();

        WebElement productName = driver.findElement(By.id("productTitle"));
        String actualName = productName.getText();
        System.out.println("actualName = " + actualName);

        if (expectedResult.equals(actualName)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("expectedResult = " + expectedResult);
            System.out.println("actualName = " + actualName);
            driver.quit();
        }
    }


        private static void practiceTests () throws InterruptedException {
            WebDriver driver1 = WebDriverFactory.getDriver("Chrome");

            driver1.get("https://amazon.com");
            String searchItem1 = "disinfectant wipes";
            WebElement searchInput1 = driver1.findElement(By.id("twotabsearchtextbox"));
            //enter search term and hit enter
            //OPTION 1
            // searchInput.sendKeys(searchItem+ Keys.ENTER);
            //OPTION 2
            searchInput1.sendKeys(searchItem1);
            WebElement srchButton1 = driver1.findElement(By.className("nav-input"));
            srchButton1.click();
            Thread.sleep(2000);

            WebElement firstItem1 = driver1.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
            System.out.println(firstItem1.getText());

            String expectedResult1 = firstItem1.getText();
            firstItem1.click();

            WebElement productName1 = driver1.findElement(By.id("productTitle"));
            String actualName1 = productName1.getText();
            System.out.println("actualName = " + actualName1);

            if (expectedResult1.equals(actualName1)) {
                System.out.println("PASS");
            } else {
                System.out.println("FAIL");
                System.out.println("expectedResult = " + expectedResult1);
                System.out.println("actualName = " + actualName1);
                driver1.quit();

            }
        }
    }


