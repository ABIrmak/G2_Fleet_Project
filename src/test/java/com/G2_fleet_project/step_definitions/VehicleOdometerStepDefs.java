package com.G2_fleet_project.step_definitions;

import com.G2_fleet_project.pages.BasePage;
import com.G2_fleet_project.pages.VehicleOdometerPage;
import com.G2_fleet_project.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.time.Duration;

public class VehicleOdometerStepDefs {

    VehicleOdometerPage vehicleOdometerPage = new VehicleOdometerPage();
    private BasePage basePage;

    @When("user go to Fleet menu and Vehicle Odometer submenu")
    public void user_go_to_fleet_menu_and_vehicle_odometer_submenu() {
        vehicleOdometerPage.navigateToModule("Fleet", "Vehicle Odometer");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Then("user see the error message {string}")
    public void user_see_the_error_message(String errorMessage) {
        Assert.assertTrue(vehicleOdometerPage.errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage, vehicleOdometerPage.errorMessage.getText());
    }

    @Then("user see the default page as {string}.")
    public void userSeeTheDefaultPageAs(String expectedPageNumber) {
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(vehicleOdometerPage.actualPageNumber.isDisplayed());
        Assert.assertEquals(expectedPageNumber, vehicleOdometerPage.actualPageNumber.getAttribute("value"));
    }

    @Then("user see the View Per Page as {string} by default.")
    public void userSeeTheViewPerPageAsByDefault(String expectedViewPerPageButton) {
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(vehicleOdometerPage.actualViewPerPageButton.isDisplayed());
        Assert.assertEquals(expectedViewPerPageButton, vehicleOdometerPage.actualViewPerPageButton.getText());
    }
}
