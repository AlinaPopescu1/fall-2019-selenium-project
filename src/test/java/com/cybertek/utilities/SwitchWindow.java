package com.cybertek.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class SwitchWindow {
    // write a utility that takes a String title,
    // changes to tab with given title,
    // if such title is not found, go back to original window

    // write a utility that takes a String url,
    // changes to tab with given url,
    // if such title is not found, go back to original window

    public static void switchWindow(WebDriver driver, String title) {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals(title)) {
                return;
            }
        }
        driver.switchTo().defaultContent();
            }

    public static void switchURL(WebDriver driver, String url) {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if (driver.getCurrentUrl().equals(url)) {
                return;
            }
        }
                driver.switchTo().parentFrame();
            }
        }

