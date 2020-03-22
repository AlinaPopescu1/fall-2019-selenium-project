package com.cybertek.tests.day05_Xpath;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathDemo {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        driver.manage().window().maximize();

        WebElement buttonOne = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        System.out.println(buttonOne.getText());
        WebElement buttonTwo = driver.findElement(By.xpath("//h3/following-sibling::button[2]"));
        System.out.println(buttonTwo.getText());
        WebElement buttonThree = driver.findElement(By.xpath("//button[3]"));
        System.out.println(buttonThree.getText());
        WebElement buttonFour = driver.findElement(By.xpath("//button[.='Button 4']"));
        System.out.println(buttonFour.getText());
        WebElement buttonFive = driver.findElement(By.xpath("//div/button[5]"));
        System.out.println(buttonFive.getText());
        WebElement buttonSix = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[1]/button[6]"));
        System.out.println(buttonSix.getAttribute("outerHTML"));
        System.out.println(buttonSix.getAttribute("innerHTML"));

        driver.close();




    }
}
