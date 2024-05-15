package com.G2_fleet_project.step_definitions;

import com.G2_fleet_project.pages.AccountsPage_BI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class US12_AccountsFilterSteps {
    AccountsPage_BI accountsPageBi = new AccountsPage_BI();

    @Given("user navigates to accounts page")
    public void user_navigates_to_accounts_page() {
        accountsPageBi.waitUntilLoaderScreenDisappear();
        accountsPageBi.navigateToModule("Customers", "Accounts");
    }

    @Then("user sees the eight filter items")
    public void user_sees_the_eight_filter_items(List<String> expectedOptions) {
        List<String> actualOptions = new ArrayList<>();
        for (WebElement filterOption : accountsPageBi.filterOptions) {
            String text = filterOption.getAttribute("innerText").trim();
            text = text.substring(0, text.indexOf(':'));
            actualOptions.add(text);
        }
        Assert.assertEquals(expectedOptions, actualOptions);
    }
}
