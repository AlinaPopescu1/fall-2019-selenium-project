package com.cybertek.tests.PageObjectModelDataProvider;

import com.cybertek.base.VytrackTestBase;
import com.cybertek.pages.CreateCalendarEventPage;
import com.cybertek.utilities.ConfigurationReader;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class CreateCalendarEvents extends VytrackTestBase {

    @Test
    public void allDayEventRadioTest(){
        loginPage.login(ConfigurationReader.getProperty("driver_username"),
                ConfigurationReader.getProperty("driver_password"));
        driver.get("https://qa3.vytrack.com/calendar/event/create");
        //verify both buttons are not selected
        assertFalse(calendarEventPage.allDayEventCheckBox.isSelected());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        assertFalse(calendarEventPage.repeatCheckBox.isSelected());
    }
}
