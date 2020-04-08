package com.cybertek.tests.OfiiceHours;

import com.cybertek.base.TestBase;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.util.Set;

public class Cookies extends TestBase {
    @Test
    public void cookies() {
        //print some cookies
        driver.get("http://a.testaddressbook.com/addresses");
        driver.findElement(By.id("session_email")).sendKeys("kexesobepu@zsero.com");
        driver.findElement(By.id("session_password")).sendKeys("password" + Keys.ENTER);
        System.out.println(driver.getCurrentUrl());

        //get all cookies, Set to remove duplicates
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("cookies.size() = " + cookies.size());
        for (Cookie cookie : cookies) {
            System.out.println(cookie.toString());
        }
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        System.out.println(driver.getCurrentUrl());

        //Print cookies after deletion
        Set<Cookie> cookies2 = driver.manage().getCookies();
        System.out.println("cookies2.size() = " + cookies2.size());

        //add cookies back
        Driver.closeDriver();
        driver = Driver.getDriver();
        driver.get("http://a.testaddressbook.com/addresses");

        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
        driver.navigate().refresh();
        System.out.println(driver.getCurrentUrl());
    }
}