package com.BriteERP.pages;

import com.BriteERP.utilities.ConfigurationReader;
import com.BriteERP.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
        public LoginPage(){
            PageFactory.initElements(Driver.getDriver(), this);}

        @FindBy(id = "login")
        @CacheLookup
        public WebElement userNameElement;

        @FindBy(id = "password")
        @CacheLookup
        public WebElement passwordElement;

        @FindBy(xpath="//button[@type='submit']")
        public WebElement loginButtonElement;


        public void login(String username, String password){
            userNameElement.sendKeys(username);
            passwordElement.sendKeys(password);
            loginButtonElement.click();
        }

        public void login(){
            String username = ConfigurationReader.getProperty("username");
            String password = ConfigurationReader.getProperty("password");
            userNameElement.sendKeys(username);
            passwordElement.sendKeys(password);
            loginButtonElement.click();
        }

}
