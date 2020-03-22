package com.cybertek.utilities;

public class SystemProperties {
    public static void main(String[] args) {
        String property = System.getProperty("os.name");
        System.out.println("property = " + property);

        System.out.println("OS: " + System.getProperty("os.name") + "; Version: " + System.getProperty("os.version"));
    }
    }

