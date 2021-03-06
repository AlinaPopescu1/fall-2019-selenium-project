package com.cybertek.utilities;
import com.cybertek.tests.Test_Base_Props_Driver.Singleton;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
public class Driver {
    //private constructor so nobody can create object from it
    //lock this driver only for this class, so it can
    private Driver() {}
    //static so we can share the driver between classes(tests)
    private static WebDriver driver;
    public static WebDriver getDriver() {
        //check if the driver has value, if not initialize new object
        if (driver == null) { // TODO we want to make this true, second time, so assign null to it in closeDriver()
            //get the driver type from properties
           String browser = ConfigurationReader.getProperty("browser");
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;
                case "ie":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "edge":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Edge");
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac"))
                        throw new WebDriverException("Your OS doesn't support Safari");
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    break;
            }
        }
        return driver;
    }
    public static void closeDriver(){
        //first time I call it will be null
        //the second time I will open the browser will not be null
        //I have to make it null in order to instantiate another driver
        driver.quit();
        driver = null;
        //close the browser if there is browser

        //if the driver does not exist and you try to close it,
        // you'll get an error "Session does not exist"

//        if(driver!=null){   //this is allowed too
//            driver.quit();
//            driver=null;
//        }
    }
}
