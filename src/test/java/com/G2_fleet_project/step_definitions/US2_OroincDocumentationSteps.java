package com.G2_fleet_project.step_definitions;

import com.G2_fleet_project.pages.DashboardPage;
import com.G2_fleet_project.utilities.ConfigurationReader;
import com.G2_fleet_project.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Set;

public class US2_OroincDocumentationSteps {
    DashboardPage dashboardPage = new DashboardPage();

    @Given("user clicks the get help link")
    public void user_clicks_the_get_help_link() {
        dashboardPage.waitUntilLoaderScreenDisappear();
        dashboardPage.getHelpLink.click();
    }

    @Then("user should see the documentation page open")
    public void user_should_see_the_documentation_page_open() {
        verifyPageOpenWithURL(ConfigurationReader.getProperty("url_documentation"));
    }

    /**
     * Verify if a page with the given URL is currently open. Focus will be kept on the original window before the
     * method call.
     * @param URL URL of the page to check.
     */
    public static void verifyPageOpenWithURL(String URL) {
        // Save the original window handle
        String originalWindow = Driver.getDriver().getWindowHandle();

        // Loop through every window; if URL found, return after switching to the original window
        Set<String> windows = Driver.getDriver().getWindowHandles();
        for (String window : windows) {
            Driver.getDriver().switchTo().window(window);
            String currentURL = Driver.getDriver().getCurrentUrl();
            if (currentURL.equals(URL)) {
                Driver.getDriver().switchTo().window(originalWindow);
                return; // Test passed
            }
        }
        Assert.fail("Page with given URL not found!");
    }
}
