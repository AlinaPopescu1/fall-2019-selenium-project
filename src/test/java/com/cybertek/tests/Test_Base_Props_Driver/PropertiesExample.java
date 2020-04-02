package com.cybertek.tests.Test_Base_Props_Driver;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Properties;

public class PropertiesExample {
    @Test
    public void test(){
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("user.home"));

        //browser url
        Properties properties = new Properties();
        properties.setProperty("browser", "chrome");
        properties.setProperty("url", "http://practice.cybertekschool.com");

        String browser = properties.getProperty("browser");
        System.out.println("browser name = " + browser);

        //I need the browser/url from properties file
        String pBrowser = ConfigurationReader.getProperty("browser");
        System.out.println("pBrowser = " + pBrowser);

        String url = ConfigurationReader.getProperty("url");
        System.out.println("url = " + url);
    }
    @Test
    public void test2(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //get the url from props file
        String url = ConfigurationReader.getProperty("url");
        driver.get(url);
        driver.close();
    }
    @Test
    public void test3(){
        String str = Singleton.getInstance();
        System.out.println(str);
    }
}
