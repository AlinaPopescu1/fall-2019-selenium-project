package com.cybertek.tests.OfiiceHours;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;

public class Day03_locators {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("http://qa3.vytrack.com");
        Thread.sleep(2000);
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("salesmanager110");
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        password.submit();
        Thread.sleep(2000);

        WebElement contactsLink = driver.findElement(By.xpath("//span[.='Contacts']/following-sibling::a"));
        Thread.sleep(2000);
        contactsLink.click();

        Thread.sleep(2000);
        WebElement createContact = driver.findElement(By.linkText("Create Contact"));
        createContact.click();

        String currentTitle = driver.getTitle();
        Thread.sleep(3000);

        if(currentTitle.equalsIgnoreCase("CCreate Contact - Contacts - Customers")){
            System.out.println("Title is expected");
        }else{
            System.out.println("Title is not expected");
        }

        HashMap<String, String> contact1 = new HashMap<>();
        contact1.put("First name", "John");
        contact1.put("Last name", "Smith");
        contact1.put("Phone", "4433214423");
        contact1.put("City", "Tysons");
        contact1.put("Street", "400 Main Street");
        contact1.put("Country", "United States");
        contact1.put("State", "VA");
        contact1.put("Zip Code", "22102");
        contact1.put("Sales Group", "true");

        System.out.println("contact1 = " + contact1);

        WebElement firstName = driver.findElement(By.xpath("(//input[@data-name='field__first-name'])[1]"));
        WebElement lastName = driver.findElement(By.xpath("(//input[@data-name='field__last-name'])[1]"));
        WebElement phone = driver.findElement(By.name("oro_contact_form[phones][0][phone]"));
        WebElement street = driver.findElement(By.name("oro_contact_form[addresses][0][street]"));
        WebElement city = driver.findElement(By.name("oro_contact_form[addresses][0][city]"));
        WebElement state = driver.findElement(By.xpath("//input[@data-name='field__region-text']"));
        WebElement zipCode = driver.findElement(By.name("oro_contact_form[addresses][0][postalCode]"));
        WebElement salesGroup = driver.findElement(By.xpath("(//input[@data-name='field__1'])[2]"));

        WebElement country = driver.findElement(By.name("oro_contact_form[addresses][0][country]"));
        Select countryDropdwn = new Select(country);
        //this is special class in Selenium to handle dropDown
        countryDropdwn.selectByVisibleText(contact1.get("Country"));
        if(contact1.get("Sales Group") .equalsIgnoreCase("true")){
            salesGroup.click();
        }
        firstName.sendKeys(contact1.get("First name"));
        lastName.sendKeys(contact1.get("Last name"));
        phone.sendKeys(contact1.get("Phone"));
        street.sendKeys(contact1.get("Street"));
        city.sendKeys(contact1.get("City"));
        state.sendKeys(contact1.get("State"));
        zipCode.sendKeys(contact1.get("Zip Code"));
        salesGroup.sendKeys(contact1.get(""));

        driver.quit();
    }
}
