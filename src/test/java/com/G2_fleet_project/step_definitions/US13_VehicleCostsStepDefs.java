package com.G2_fleet_project.step_definitions;

import com.G2_fleet_project.pages.LoginPage;
import com.G2_fleet_project.pages.VehicleCostsPage;
import com.G2_fleet_project.utilities.ConfigurationReader;
import com.G2_fleet_project.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class US13_VehicleCostsStepDefs {

    VehicleCostsPage vehicleCostsPage = new VehicleCostsPage();

    LoginPage loginPage = new LoginPage();

//    String storeManagerUsername = ConfigurationReader.getProperty("store_manager_username");
//    String storeManagerPassword = ConfigurationReader.getProperty("store_manager_password");
//    String salesManagerUsername = ConfigurationReader.getProperty("sales_manager_username");
//    String salesManagerPassword = ConfigurationReader.getProperty("sales_manager_password");

    @When("user go to Fleet menu and Vehicle Odometer submenu")
    public void user_go_to_fleet_menu_and_vehicle_odometer_submenu() {
        vehicleCostsPage.navigateToModule("Fleet", "Vehicle Costs");
    }
    @Then("user can see {string} columns.")
    public void user_can_see_columns(String expectedHeaders) {

        List <WebElement> headers = Driver.getDriver().findElements(By.xpath("//span[@class='grid-header-cell__label']"));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        List <String> stringHeaders = new ArrayList<>();
        for (WebElement each : headers) {
            stringHeaders.add(each.getText());
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



        Assert.assertEquals(("["+ expectedHeaders + "]"), stringHeaders);
    }

    //--------------------------------------------------

    @When("user can check the first checkbox")
    public void user_can_check_the_first_checkbox() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("user see that all Vehicle Costs is selected on the Vehicle Costs page")
    public void user_see_that_all_vehicle_costs_is_selected_on_the_vehicle_costs_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    //--------------------------------------------------

    @When("user can uncheck the first checkbox")
    public void user_can_uncheck_the_first_checkbox() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("user see that all Vehicle Costs is not selected on the Vehicle Costs page")
    public void user_see_that_all_vehicle_costs_is_not_selected_on_the_vehicle_costs_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



}
