package com.cybertek.tests.OfiiceHours1;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExec {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.get("https://www.etsy.com/");
    }
    @AfterMethod
    public void afterTest() { driver.quit();
    }
//    @Test(priority = 1, description = "Clicking on an element")
//    public void test(){
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("document.getElementByid('catnav-primary-link-891').click();");
//    }
//    @Test
//    public void test1(){
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        String url = js.executeScript("return document.URL").toString();
//        System.out.println("url = " + url);
//    }
//    @Test
//    public void test2() {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        String elementText = js.executeScript("return document.getElementByid('catnav-primary-link-11049')").toString();
//        elementText = elementText.trim();
//        System.out.println("elementText = " + elementText);
//
//
//    }

    @Test(priority = 0,description = "Send text to search box on etsy")
    public void test1(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementById('global-enhancements-search-query').value='Send these characters'");
    }
    @Test(priority = 2, description = "get the page title (return a value)")
    public void testcase3(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //return keyword before the script is for Selenium to know that it needs to bring back information
        String pageTitle = js.executeScript("return document.title").toString();
        System.out.println(pageTitle);
    }
    @Test(priority = 1,description = "Clicking on an element")
    public void test2(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementById('catnav-primary-link-891').click();");
    }
    @Test(description = "return page URL")
    public void test4(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //return keyword before the script is for Selenium to know that it needs to bring back information
        String pageURL = js.executeScript("return document.URL").toString();
        System.out.println(pageURL);
    }
    @Test(description = "return element text")
    public void test5(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String elementText= js.executeScript("return document.getElementById('catnav-primary-link-11049').innerHTML").toString();
        elementText=elementText.trim();
        System.out.println(elementText);
    }
    @Test(description = "scroll an element into view")
    public void test6(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementById('email-list-signup-email-input').scrollIntoView();");
    }
}
