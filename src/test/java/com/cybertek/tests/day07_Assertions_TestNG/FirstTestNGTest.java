package com.cybertek.tests.day07_Assertions_TestNG;
import org.testng.Assert;
import org.testng.annotations.Test;
public class FirstTestNGTest {
    @Test
    public void test1() {
        String expected = "one";
        String actual = "one";
        Assert.assertEquals(actual, expected);
        Assert.assertEquals(1, 1);
        Assert.assertEquals(true, true);
        System.out.println("Test 1 completed");
    }

    @Test
    public void test2() {
        String expected = "one";
        String actual = "two";
        System.out.println("Starting to compare");
        Assert.assertEquals(actual, expected);
        System.out.println("Test 2 completed");
    }

    @Test
    public void test3() {
        String expected = "one";
        String actual = "two";
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void test4() {
        String expected = "one";
        String actual = "one";
        Assert.assertTrue(expected.equals(actual));
    }

    @Test
    public void test5() {
        String expected = "one";
        String actual = " not two";
        Assert.assertFalse(expected.equals(actual));
    }
}
