package com.G2_fleet_project.step_definitions;

import com.G2_fleet_project.pages.CampaignsPage_BI;
import com.G2_fleet_project.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

public class US14_CampaignFilterCheckboxesSteps {
    CampaignsPage_BI campaignsPage_BI = new CampaignsPage_BI();

    @Given("user navigates to campaigns page")
    public void user_navigates_to_campaigns_page() {
        campaignsPage_BI.waitUntilLoaderScreenDisappear();
        campaignsPage_BI.navigateToModule("Marketing", "Campaigns");
    }

    @Then("user clicks the filters link")
    public void user_clicks_the_filters_link() {
        WebElement filtersLink = campaignsPage_BI.filtersLink;
        campaignsPage_BI.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickablility(filtersLink, 10);
        filtersLink.click();
    }

    @Given("user presses the manage filters button")
    public void user_presses_the_manage_filters_button() {
        WebElement filtersBtn = campaignsPage_BI.manageFiltersBtn;
        BrowserUtils.waitForClickablility(filtersBtn, 10);
        filtersBtn.click();
    }

    @Then("user should see that the five filter options are checked by default")
    public void user_should_see_that_the_five_filter_options_are_checked_by_default() {
        for (int i = 0; i < campaignsPage_BI.filterlist.size(); i++) {
            Assert.assertTrue(campaignsPage_BI.filterlist.get(i).isSelected());
        }
    }

    @Then("user should be able to unselect the five filter options separately")
    public void user_should_be_able_to_unselect_the_five_filter_options_separately() {
        for (int i = 0; i < campaignsPage_BI.filterlist.size(); i++) {
            for (int j = 0; j < 10; j++) {
                try {
                    campaignsPage_BI.filterlist.get(i).click();
                    break;
                }
                catch (StaleElementReferenceException e) {
                    BrowserUtils.sleep(1);
                }
            }
            Assert.assertFalse(campaignsPage_BI.filterlist.get(i).isSelected());
        }
    }
}
