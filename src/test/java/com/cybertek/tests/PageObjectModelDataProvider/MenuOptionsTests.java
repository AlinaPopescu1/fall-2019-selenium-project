package com.cybertek.tests.PageObjectModelDataProvider;
import com.cybertek.base.VytrackTestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class MenuOptionsTests extends VytrackTestBase {
          @Test
    public void test(){
              loginPage.login(ConfigurationReader.getProperty("driver_username"),
                      ConfigurationReader.getProperty("driver_password"));
              dashboardPage.changeMenu("Activities", "Calendar Events");
              wait.until(ExpectedConditions.titleIs("Calendar Events - Activities"));
              assertEquals(driver.getTitle(), "Calendar Events - Activities");

          }
          //DDT test
    @Test(dataProvider = "test-data")
    public void ddtTest(String menu1, String menu2, String expTitle){
        loginPage.login(ConfigurationReader.getProperty("driver_username"),
                ConfigurationReader.getProperty("driver_password"));
              dashboardPage.changeMenu(menu1, menu2);
              wait.until(ExpectedConditions.titleContains(expTitle));
              assertTrue(driver.getTitle().contains(expTitle));


    }
    @DataProvider(name="test-data")
    public Object[][] getData(){
        return new Object[][]{
                {"Fleet", "Vehicles", "Car"},
                {"Fleet", "Vehicle Costs", "Vehicle Costs"},
                {"Customers", "Contacts", "Contacts - Customers"},
                {"Activities", "Calendar Events", "Calendar Events - Activities"},
                {"System", "System Calendars", "System Calendars - System"}
        };

    }

    @Test
    public void testAllOptionsDriver(){
        loginPage.login(ConfigurationReader.getProperty("driver_username"),
                ConfigurationReader.getProperty("driver_password"));

        List<String> expected = Arrays.asList("Fleet", "Customers", "Activities", "System");
        List<String> actualList = BrowserUtils.getElementsText(dashboardPage.menu1Options);
        assertEquals(expected,actualList);
    }
    @Test
    public void softAssert(){
        SoftAssert soft = new SoftAssert();

    }
              }

