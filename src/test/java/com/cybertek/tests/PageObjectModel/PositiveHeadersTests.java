package com.cybertek.tests.PageObjectModel;

import com.cybertek.base.VytrackTestBase;
import com.cybertek.pages.DashboardPage;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class PositiveHeadersTests extends VytrackTestBase {
    // go to vytrack
    // login as driver
    // verify  header is "Dashboard"

    @Test
    public void dashboardPageTest() {
        test = report.createTest("Dashboard page title test");
        String username = ConfigurationReader.getProperty("driver_username");
        String password = ConfigurationReader.getProperty("driver_password");
        test.info("Logging in to application");
        loginPage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage();
        wait.until(ExpectedConditions.textToBePresentInElement
                (dashboardPage.pageHeader, "Quick Launchpad"));
        String actual = dashboardPage.pageHeader.getText();
        test.info("Verifying pageheader");
        assertEquals(actual, "Quick Launchpad");
        test.pass("PASS: Dashboard page title test");
    }
    // go to vytrack
    // go to Fleet vehicles
    // login as driver
    // verify  header is "All Cars"
    @Test
    public void fleetVehiclesTest() throws InterruptedException{

        test = report.createTest("Vehicles page title test");

        String username = ConfigurationReader.getProperty("driver_username");
        String password = ConfigurationReader.getProperty("driver_password");
        test.info("Logging in to application");
        loginPage.login(username,password);
        //use dashboard to change page
        test.info("Going to Fleet --> Vehicles");
        wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.fleet));
        dashboardPage.fleet.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.vehicles));
        dashboardPage.vehicles.click();
        //use the fleet / vehicles page to get text
        wait.until(ExpectedConditions.textToBePresentInElement(vehiclesPage.pageHeader, "Cars"));
        test.info("Verifying page header");
        String actual = vehiclesPage.pageHeader.getText();
        assertEquals(actual, "Caroorros");
        test.fail("Fail: Vehicles page title test");
    }
}





