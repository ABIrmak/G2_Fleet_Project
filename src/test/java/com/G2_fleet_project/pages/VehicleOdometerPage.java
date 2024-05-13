package com.G2_fleet_project.pages;

import com.G2_fleet_project.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehicleOdometerPage extends BasePage {

    public VehicleOdometerPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "(//div[@class='message'])[2]")
    public WebElement errorMessage;

    @FindBy (xpath = "(//button[@data-toggle='dropdown'])[1]")
    public WebElement actualViewPerPageButton;

    @FindBy(xpath = "//input[@value='1']")
    public WebElement actualPageNumber;

}
