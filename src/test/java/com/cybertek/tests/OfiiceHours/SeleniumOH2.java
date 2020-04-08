package com.cybertek.tests.OfiiceHours;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumOH2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("http://automationpractice.com");
        //check if it landed to correct page and do it manually

        WebElement searchBox = driver.findElement(By.id("search_query_top"));
        searchBox.sendKeys("tshirt "+ Keys.ENTER);

        /*
        <p class="alert alert-warning">
					No results were found for your search&nbsp;"tshirts"
			</p>
         */
        Thread.sleep(3000);
        WebElement error = driver.findElement(By.xpath("//p[@class='alert alert-warning']"));
        String errorText = error.getText();
        System.out.println("Error text "+errorText);
        //getText() return String (text from the Element)

        searchBox=driver.findElement(By.id("search_query_top"));
        searchBox.clear();
        searchBox.sendKeys("t-shirt"+Keys.ENTER);

        driver.quit();
        //StaleElementException-element is old, is not found on the page.
        //we want to find it again

          //WebElement is a class in Selenium and it has many useful methods and sendKeys is on of them.
        //sendKeys(value that we want to send-input)
        //Selenium is written in Java
        //validate you got no results message on UI
//        driver.findElement(By.className("search_query form-control ac_input")).sendKeys("t-shirt");
//        driver.findElement(By.className("btn btn-default button-search")).click();

    }
}
