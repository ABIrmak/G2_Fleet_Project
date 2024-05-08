package com.G2_fleet_project.step_definitions;

import com.G2_fleet_project.pages.BasePage;
import com.G2_fleet_project.pages.LoginPage;
import com.G2_fleet_project.utilities.BrowserUtils;
import com.G2_fleet_project.utilities.ConfigurationReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        // Login page is navigated tp automatically by the "@Before" method!
    }

    @Given("user logged in as {string}")
    public void user_logged_in_as(String userType) {
        // Get the appropriate username/password from the configuration file (according to the "userType").
        String username;
        String password;
        switch (userType.toLowerCase()) {
            case "driver" -> {
                username = ConfigurationReader.getProperty("driver_username");
                password = ConfigurationReader.getProperty("driver_password");
            }
            case "sales manager" -> {
                username = ConfigurationReader.getProperty("sales_manager_username");
                password = ConfigurationReader.getProperty("sales_manager_password");
            }
            case "store manager" -> {
                username = ConfigurationReader.getProperty("store_manager_username");
                password = ConfigurationReader.getProperty("store_manager_password");
            }
            default -> {
                username = null;
                password = null;
            }
        }

        // Login with the username and password
        loginPage.login(username, password);
    }

    @Then("user should be able to see the dashboard")
    public void user_should_be_able_to_see_the_dashboard() {
        BrowserUtils.waitForTitleContains("Dashboard");
        BrowserUtils.verifyTitle("Dashboard");
    }

    @Given("user logs in with {string} as the username and {string} as the password")
    public void user_logs_in_with_as_the_username_and_as_the_password(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("user should fail to log in")
    public void user_should_fail_to_log_in() {
        BrowserUtils.verifyElementDisplayed(loginPage.invalidUsernameOrPasswordText);
    }
}
