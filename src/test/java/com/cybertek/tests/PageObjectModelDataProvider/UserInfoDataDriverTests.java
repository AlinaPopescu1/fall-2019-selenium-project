package com.cybertek.tests.PageObjectModelDataProvider;

import com.cybertek.pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserInfoDataDriverTests {
    @Test(dataProvider = "users")
    public void test(String name, String password){
        System.out.println("Opening application");
        System.out.println("Login as: " + name);
        System.out.println("Verify info");
    }
    @DataProvider (name = "users")
    public Object [][] getUsers(){
        return new Object [][]{
                {"user1", "UserUser123"},
                {"user2", "UserUser123"},
                {"user3", "UserUser123"}
        };
        }
    }

