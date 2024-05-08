package com.G2_fleet_project.step_definitions;

import com.G2_fleet_project.utilities.BrowserUtils;
import com.G2_fleet_project.utilities.ConfigurationReader;
import com.G2_fleet_project.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

/**
 * In this class we will be able to create "pre" and "post" condition for ALL the SCENARIOS and even STEPS.
 */
public class Hooks {
    /**
     * Executes before each scenario.<br>
     * <u>Currently:</u><br>
     * - Opens the driver using "browser" type from the configuration file.<br>
     * - Sets up a 20s implicit wait.<br>
     * - Goes to the "url" page from the configuration file.
     */
    @Before
    public void setupMethod(){
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    /**
     * Executes after each scenario.<br>
     * <u>Currently:</u><br>
     * - Takes a screenshot on scenario failure and attaches it to the report.<br>
     * - Sleeps for 2 seconds.<br>
     * - Closes the current driver.<br>
     */
    @After
    public void teardownMethod(Scenario scenario){
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        BrowserUtils.sleep(2);
        Driver.closeDriver();
    }
}
