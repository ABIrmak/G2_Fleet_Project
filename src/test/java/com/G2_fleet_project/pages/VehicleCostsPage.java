package com.G2_fleet_project.pages;

import com.G2_fleet_project.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VehicleCostsPage extends BasePage {

    public VehicleCostsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//span[@class='grid-header-cell__label'])[1]")
    public WebElement typeHeader;
    @FindBy(xpath = "(//span[@class='grid-header-cell__label'])[2]")
    public WebElement totalPriceHeader;
    @FindBy(xpath = "(//span[@class='grid-header-cell__label'])[3]")
    public WebElement dateHeader;
    @FindBy(xpath = "//button[@class='btn btn-default btn-small dropdown-toggle']//input[@type='checkbox']")
    public WebElement selectAllCheckbox;
    @FindBy(xpath = "//label[normalize-space()='of 11 |']")
    public WebElement pageNumber;
    @FindBy(xpath = "//i[@class='fa-chevron-right hide-text']")
    public WebElement nextPageButton;
}
