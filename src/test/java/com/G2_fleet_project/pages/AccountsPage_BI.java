package com.G2_fleet_project.pages;

import com.G2_fleet_project.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountsPage_BI extends BasePage {
    public AccountsPage_BI() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='filter-item oro-drop']/div[1]")
    public List<WebElement> filterOptions;
}
