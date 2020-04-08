package com.cybertek.tests.PageObjectModel;
import com.cybertek.base.TestBase;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NegativeLoginTest extends TestBase {
    LoginPage loginPage;
    @BeforeMethod
    public void setUpTests(){
        driver.get(ConfigurationReader.getProperty("vytrack_url"));
         loginPage = new LoginPage();
    }
    @Test
    public void wrongUserNameTest(){
        loginPage.username.sendKeys("user20000");
        loginPage.password.sendKeys("UserUser123");
        loginPage.login.click();

        String actual = loginPage.errorMsg.getText();
        String expected = "Invalid user name or password.";

        Assert.assertEquals(actual,expected);
        Assert.assertTrue(loginPage.errorMsg.isDisplayed());
    }
    @Test
    public void wrongPasswordTest(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage.username.sendKeys("SalesManager110");
        loginPage.password.sendKeys("MD");
        loginPage.login.click();

        String actual = loginPage.errorMsg.getText();
        Assert.assertEquals(actual, "Invalid user name or password.");
        Assert.assertTrue(loginPage.errorMsg.isDisplayed());
    }
}
