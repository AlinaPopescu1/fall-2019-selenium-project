package com.cybertek.tests.day07_Assertions_TestNG;
import org.testng.annotations.*;

public class BeforeAndAfterTest {
    @BeforeClass
    public void beforeClass(){
        System.out.println("\tBefore class");
    }
    @AfterMethod
    public void afterMethod2(){
        System.out.println("\tAfter method2");
    }
    @Ignore
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("\tBefore method");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("\tAfter method");
    }
    @BeforeMethod
    public void beforeMethod2(){
        System.out.println("\tBefore method2");
    }
    @Test
    public void test1(){
        System.out.println("\tThis is test 1");
    }
    @Ignore
    @Test
    public void test2(){
        System.out.println("This is test 2");
    }
}
