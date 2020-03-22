package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class GetDriver {
    public static WebDriver getDriver (String browser){
        String opSysName = System.getProperty("os.name");
        WebDriver webDriver = null;
        if (browser.contains("Chrome")) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        }else if(browser.contains("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        }else if(browser.contains("Edge") && opSysName.contains("Windows")) {
            WebDriverManager.edgedriver().setup();
            webDriver = new EdgeDriver();
        }else if(browser.contains("Explorer") && opSysName.contains("Windows")) {
            WebDriverManager.iedriver().setup();
            webDriver = new InternetExplorerDriver();
        }else if(browser.contains("Safari") && opSysName.contains("Windows")) {
           return webDriver;
        }
        return webDriver;
    }
}

