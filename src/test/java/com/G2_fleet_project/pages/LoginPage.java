package com.G2_fleet_project.pages;

import com.G2_fleet_project.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "prependedInput")
    public WebElement usernameTextBox;

    @FindBy(id = "prependedInput2")
    public WebElement passwordTextBox;

    @FindBy(name = "_submit")
    public WebElement submitBtn;

    @FindBy(xpath = "//div[.='Invalid user name or password.']")
    public WebElement invalidUsernameOrPasswordText;

    /**
     * Logs from the login page using the specified username and password.
     * @param usernameStr Username to log in with.
     * @param passwordStr Password to log in with.
     */
    public void login(String usernameStr, String passwordStr) {
        usernameTextBox.sendKeys(usernameStr);
        passwordTextBox.sendKeys(passwordStr);
        submitBtn.click();
    }
}
