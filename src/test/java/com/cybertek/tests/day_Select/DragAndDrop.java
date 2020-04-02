package com.cybertek.tests.day_Select;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDrop {
    WebDriver driver;
    Actions actions;
    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("Chrome");
        actions = new Actions(driver);

    }
    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");
        Thread.sleep(2000);
        WebElement target = driver.findElement(By.tagName("img"));
        actions.moveToElement(target).perform();
        Thread.sleep(2000);
    }
    @Test
    public void hover2(){
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        WebElement enabled = driver.findElement(By.id("ui-id-3"));
        WebElement downloads = driver.findElement(By.id("ui-id-4"));
        WebElement pdf = driver.findElement(By.id("ui-id-5"));
        actions.
                moveToElement(enabled).
                pause(2000).
                moveToElement(downloads).
                pause(2000).
                click(pdf).
                build().perform();
    }
    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        WebElement money = driver.findElement(By.id("draggable"));
        WebElement bank = driver.findElement(By.id("droptarget"));
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();//or ARROW_DOWN
        actions.dragAndDrop(money,bank).perform();
        Thread.sleep(2000);
    }
    /*
TASK
do the drag and drop by chaining actions
move mouse to source/money
mouse down
move mouse to target/bank
mouse up
 */
    @Test(priority = 0)
    public void dragAndDrop2(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        WebElement money = driver.findElement(By.id("draggable"));
        WebElement bank = driver.findElement(By.id("droptarget"));
        actions.moveToElement(money).pause(2000).clickAndHold().pause(2000).
                moveToElement(bank).pause(2000).release().build().perform();
    }
    @AfterMethod
    public void afterTest() { driver.quit();
    }

}
