package com.cybertek.pages;

import com.cybertek.base.VytrackPageBase;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
        public LoginPage() {
                //page object classes needs constructor
                //we have to call the below line     PageFactory.initElements();
                // it comes from selenium and pass a driver object and this class as a param
                //this --> calls the instance of the class
                PageFactory.initElements(Driver.getDriver(), this);
        }

        //FindBy --> we provide the locator for WebElement
        //process of creating a copy of id in my test
        @FindBy(id = "prependedInput")
        public WebElement username;

        @FindBy(id = "prependedInput2")
        public WebElement password;

        @FindBy(id = "_submit")
        public WebElement login;

        @FindBy(css = ".alert-error>div")
        public WebElement errorMsg;

        public void login(String username, String password) {
                this.username.sendKeys(username);
                this.password.sendKeys(password);
                login.click();
        }
}
