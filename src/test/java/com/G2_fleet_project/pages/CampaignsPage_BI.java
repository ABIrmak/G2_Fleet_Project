package com.G2_fleet_project.pages;

import com.G2_fleet_project.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CampaignsPage_BI extends BasePage {
    public CampaignsPage_BI() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@title='Filters']")
    public WebElement filtersLink;

    @FindBy(css = "button.ui-multiselect.ui-corner-all.select-filter-widget")
    public WebElement manageFiltersBtn;

    @FindBy(xpath = "(//ul[@class='ui-multiselect-checkboxes ui-helper-reset fixed-li'])//input")
    public List<WebElement> filterlist;
}
