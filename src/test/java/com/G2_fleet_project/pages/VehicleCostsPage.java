package com.G2_fleet_project.pages;

import com.G2_fleet_project.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
}
