package com.cybertek.tests.day04_Xpath;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class XpathDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.manage().window().maximize();

        driver.findElement(By.name("email")).sendKeys("alina.popen@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("form_submit")).submit();
        Thread.sleep(2000);
//        driver.findElement(By.linkText("Retrieve password")).submit();


        String expectedResult = "http://practice.cybertekschool.com/email_sent";
        String actualResult = driver.getCurrentUrl();

        boolean var = expectedResult.equals(actualResult);
        System.out.println("Result is: "+ var);


        //<h4 name="confirmation_message">Your e-mail's been sent!</h4>
        String expected = "Your e-mail's been sent!";
        WebElement message = driver.findElement(By.name("confirmation_message"));
        String actual = message.getText();
        System.out.println(actual);

        boolean var1 = expected.equals(actual);
        System.out.println("Result is: "+var1);

        driver.close();
    }
}
