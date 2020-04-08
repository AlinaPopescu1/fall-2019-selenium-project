package com.cybertek.tests.HTMLReport;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtendReportExample {
    ExtentTest test;
    ExtentReports report;
    ExtentHtmlReporter htmlReporter;
    @BeforeMethod
    public void setUp() {
        //initialize the report
        report = new ExtentReports();
        //I need to point to the location where the report is.
        //    /Users/alinapopescu/IdeaProjects/fall-2019-selenium-project
        String path = System.getProperty("user.dir") + "/test-output/report.html";
        //initialize the html reporter with the given path
        htmlReporter = new ExtentHtmlReporter(path);
        //attach the htmlReporter to the report object.
        report.attachReporter(htmlReporter);
        // /Users/alinapopescu/IdeaProjects/fall-2019-selenium-project ==> my project's location
        //set environment information
        htmlReporter.config().setReportName("Vytrack Automated tests");
        report.setSystemInfo("Environment", "QA");
    }
    @Test
    public void test(){
        //we have to create a test = report.createTest every test case
        test = report.createTest("VYT-123 Title verification test");
        test.info("Opening browser");
        //driver = new ChromeDriver
        test.info("Going to website");
        //driver.get()
        test.info("verifying title");
        //assertEquals(google, google)
        test.pass("VYT-123 Title verification test");
    }
        @AfterMethod
                public void tearDown(){
            //the report will be created when we call this line
            //if we don't call it it will not be generated
            //we do it at the end of everything.
            report.flush();
        }
    }

