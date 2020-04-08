package com.cybertek.tests.OfiiceHours;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertions {
    public void softA(){
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(11, 1, "first assertion failed");
        soft.assertEquals(11, 11, "third assertion failed");
        soft.assertEquals(11, 1, "second assertion failed");
        soft.assertAll();

    }
}
