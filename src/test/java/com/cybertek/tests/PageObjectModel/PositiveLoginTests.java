package com.cybertek.tests.PageObjectModel;

import com.cybertek.base.TestBase;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class PositiveLoginTests extends TestBase {
    LoginPage loginPage;
    WebDriverWait wait;
    @BeforeMethod
    public void setUpTests(){
        driver.get(ConfigurationReader.getProperty("vytrack_url"));
        loginPage = new LoginPage();
        wait = new WebDriverWait(driver, 10);
    }
    @Test
    public void positiveDriverUser() {
        String username = ConfigurationReader.getProperty("driver_username");
        String password = ConfigurationReader.getProperty("driver_password");
        loginPage.login(username, password);

        wait.until(ExpectedConditions.titleIs("Dashboard"));
        String actual = driver.getTitle();
        Assert.assertEquals(actual, "Dashboard");
    }
    @Test
    public void logInAsSalesManager(){
        loginPage.login(ConfigurationReader.getProperty("sales_manager_username"),
                ConfigurationReader.getProperty("sales_manager_password"));

        wait.until(ExpectedConditions.titleIs("Dashboard"));
        String actual = driver.getTitle();
        assertEquals(actual, "Dashboard");
    }
    @Test
    public void logInAsStoreManager(){
        loginPage.login(ConfigurationReader.getProperty("store_manager_username"),
                ConfigurationReader.getProperty("store_manager_password"));

        wait.until(ExpectedConditions.titleIs("Dashboard"));
        String actual = driver.getTitle();
        assertEquals(actual, "Dashboard");
    }
}
