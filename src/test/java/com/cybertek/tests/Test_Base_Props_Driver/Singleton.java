package com.cybertek.tests.Test_Base_Props_Driver;
import org.testng.annotations.Test;

//this is not a utility, it just explains the concept
public class Singleton {
    private Singleton() {
    }
    private static String string;
    public static String getInstance(){
        if(string == null){
            string = "chrome";
        }
        return string;
    }
}
