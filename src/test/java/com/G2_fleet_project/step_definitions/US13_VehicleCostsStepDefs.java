package com.G2_fleet_project.step_definitions;

import com.G2_fleet_project.pages.LoginPage;
import com.G2_fleet_project.pages.VehicleCostsPage;
import com.G2_fleet_project.utilities.BrowserUtils;
import com.G2_fleet_project.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class US13_VehicleCostsStepDefs {

    VehicleCostsPage vehicleCostsPage = new VehicleCostsPage();

    @When("user go to Fleet menu and Vehicle Costs submenu")
    public void user_go_to_fleet_menu_and_vehicle_odometer_submenu() {
        vehicleCostsPage.navigateToModule("Fleet", "Vehicle Costs");
        BrowserUtils.waitFor(5);
    }
    @Then("user can see {string} columns.")
    public void user_can_see_columns(String expectedHeaders) {

        List <WebElement> headers = Driver.getDriver().findElements(By.xpath("//span[@class='grid-header-cell__label']"));

        BrowserUtils.waitFor(6);

        List <String> stringHeaders = new ArrayList<>();
        for (WebElement each : headers) {
            String headerText = each.getText().trim();
            if (!headerText.isEmpty()) {
                stringHeaders.add(headerText);
            }
        }

        BrowserUtils.waitFor(6);

        List<String> expectedHeadersList = Arrays.asList(expectedHeaders.split(", "));

        Assert.assertEquals(expectedHeadersList, stringHeaders);
    }


    @When("user can check the first checkbox")
    public void user_can_check_the_first_checkbox() {
        Assert.assertTrue(vehicleCostsPage.selectAllCheckbox.isEnabled());
    }
    @Then("user see that all Vehicle Costs is selected on the Vehicle Costs page")
    public void user_see_that_all_vehicle_costs_is_selected_on_the_vehicle_costs_page() {

        BrowserUtils.waitForVisibility(vehicleCostsPage.pageNumber, 10);
        String pageNumberText = vehicleCostsPage.pageNumber.getText();
        String totalPagesText = pageNumberText.replaceAll("[^0-9]", ""); // Extract digits
        int totalPages = Integer.parseInt(totalPagesText);

        BrowserUtils.waitForClickablility(vehicleCostsPage.selectAllCheckbox, 10);
        vehicleCostsPage.selectAllCheckbox.click();

        for (int i = 1; i <= totalPages; i++) {
            List<WebElement> allCheckboxes = Driver.getDriver().findElements(By.xpath("//tr[@class='grid-row row-click-action']//input[@type='checkbox']"));

            if (!allCheckboxes.isEmpty()) {
                BrowserUtils.waitForVisibility(allCheckboxes.get(0), 10);
                for (WebElement checkbox : allCheckboxes) {
                    Assert.assertTrue(checkbox.isSelected());
                }
            }

            if (i < totalPages) {
                BrowserUtils.waitForVisibility(vehicleCostsPage.nextPageButton, 10);
                vehicleCostsPage.nextPageButton.click();
                vehicleCostsPage.waitUntilLoaderScreenDisappear();
            }
        }
    }

    @When("user can uncheck the first checkbox")
    public void user_can_uncheck_the_first_checkbox() {
        vehicleCostsPage.selectAllCheckbox.click();
    }

    @Then("user see that all Vehicle Costs is not selected on the Vehicle Costs page")
    public void user_see_that_all_vehicle_costs_is_not_selected_on_the_vehicle_costs_page() {
        BrowserUtils.waitForVisibility(vehicleCostsPage.pageNumber, 10);
        String pageNumberText = vehicleCostsPage.pageNumber.getText();
        String totalPagesText = pageNumberText.replaceAll("[^0-9]", ""); // Extract digits
        int totalPages = Integer.parseInt(totalPagesText);

        BrowserUtils.waitForClickablility(vehicleCostsPage.selectAllCheckbox, 10);
        vehicleCostsPage.selectAllCheckbox.click();

        for (int i = 1; i <= totalPages; i++) {
            List<WebElement> allCheckboxes = Driver.getDriver().findElements(By.xpath("//tr[@class='grid-row row-click-action']//input[@type='checkbox']"));

            if (!allCheckboxes.isEmpty()) {
                BrowserUtils.waitForVisibility(allCheckboxes.get(0), 10);
                for (WebElement checkbox : allCheckboxes) {
                    Assert.assertTrue(!checkbox.isSelected());
                }
            }

            if (i < totalPages) {
                BrowserUtils.waitForVisibility(vehicleCostsPage.nextPageButton, 10);
                vehicleCostsPage.nextPageButton.click();
                vehicleCostsPage.waitUntilLoaderScreenDisappear();
            }
        }
    }
}

