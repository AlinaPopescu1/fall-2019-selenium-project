package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    public static WebDriver getDriver(String browserType) {
        WebDriver type = null;
        switch (browserType) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                type=new ChromeDriver();
                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                type= new FirefoxDriver();

        }
        return type;
    }
    public static void main(String[] args) {
        getDriver("Chrome");
        getDriver("Firefox");
    }
}
