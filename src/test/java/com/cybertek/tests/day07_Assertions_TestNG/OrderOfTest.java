package com.cybertek.tests.day07_Assertions_TestNG;
import org.testng.Assert;
import org.testng.annotations.Test;
public class OrderOfTest {
    String title;
    @Test(priority = 0)
    public void login() {
        System.out.println("opening the browser");
        System.out.println("capturing title");
        title = "cbt";
    }
    @Test(priority = 1)
    public void assertTitle() {
        System.out.println("verifying the title");
        Assert.assertEquals(title, "cbt");
    }
    @Test(priority = 55)
    public void verifyOtherThings() {
        System.out.println("verify smth else");
    }
}
