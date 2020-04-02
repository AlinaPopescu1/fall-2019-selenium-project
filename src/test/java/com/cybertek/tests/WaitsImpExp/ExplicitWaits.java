package com.cybertek.tests.WaitsImpExp;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class ExplicitWaits {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void beforeMethod() {
        //wait for the title of the page
        //create web object
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

//    @AfterMethod
//    public void afterTest() {
//        driver.quit();
//    }

    @Test
    public void explicitExample() {
        driver.get("https://google.com");
        System.out.println(driver.getTitle());
        driver.get("https://store.steampowered.com/");


        //start waiting for title contain text
        wait.until(ExpectedConditions.titleContains("Steam"));
        System.out.println(driver.getTitle());
        System.out.println("\"title to be \\\"%s\\\". Current title: \\\"%s\\\"\"");
    }

    @Test
    public void test2ExplicitWay() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement button = driver.findElement(By.tagName("button"));
        button.click();

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("pwd"));

        //waits for given element to be visible on page
        wait.until(ExpectedConditions.visibilityOf(username));
        // make sure that username is visible on page
        Assert.assertTrue(username.isDisplayed());
        username.sendKeys("johndoe");
    }

    @Test(description = "this will throw a TimeOutException")
    public void test2ExplicitWayFail() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement button = driver.findElement(By.tagName("button"));
        button.click();

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("pwd"));

        //give not enough time, changing the wait time to 2
        wait.withTimeout(Duration.ofSeconds(4));

        //waits for given element to be visible on page
        wait.until(ExpectedConditions.visibilityOf(username));
        // make sure that username is visible on page
        Assert.assertTrue(username.isDisplayed());
        username.sendKeys("johndoe");
    }

    @Test
    public void test3WaitForClickable() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/6");
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("pwd"));
        WebElement submit = driver.findElement(By.tagName("button"));

        Assert.assertTrue(username.isDisplayed());
        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword");

        //wait for element to disappear
        //wait until the overlay element disappears
        wait.until(ExpectedConditions.
                invisibilityOf(driver.findElement(
                        By.cssSelector("div[class='loadingoverlay']"))));

        //waits for given element to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();
    }

    @Test
    public void test4WaitForVisible() {
        driver.get("http://qa3.vytrack.com");
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("salesmanager110");
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        password.submit();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement calendar = driver.findElement(By.linkText("My Calendar"));
        //wait until the element with class loader-mask is not visible
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loader-mask")));
        calendar.click();

    }

    @Test
    public void test5Fluent() {

        driver.get("http://practice.cybertekschool.com/dynamic_loading/6");

        Wait<WebDriver> fluentWait = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(10)).
                pollingEvery(Duration.ofSeconds(5)).
                ignoring(NoSuchElementException.class).
                ignoring(ElementClickInterceptedException.class);


        WebElement submitBtn = fluentWait.until(driver -> driver.findElement(By.xpath("//button[text()='Submit']")));

        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");

        submitBtn.click();
    }
}
