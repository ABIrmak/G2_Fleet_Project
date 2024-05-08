package com.G2_fleet_project.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    private Driver(){}

    // Thread variable to hold the driver. Each thread will have its own copy of the driver.
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    /**
    Create a re-usable utility method which will return the same driver instance once we call it.
    If an instance doesn't exist, it will create first, and then it will always return same instance (singleton design).
     */
    public static WebDriver getDriver(){
        // If the driver doesn't exist yet, create it.
        if(driverPool.get() == null){
            /*
            Read the "browser" from the "configuration.properties" file.
            This way, we can control which browser is opened from outside our code.
             */
            String browserType = ConfigurationReader.getProperty("browser");

            /*
            Depending on the browserType returned from the "configuration.properties",
            the switch statement will determine the "case", and open the matching browser.
             */
            switch (browserType){
                case "chrome":
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
            }
        }

        // Return the new/existing driver.
        return driverPool.get();
    }


    /**
     * Custom ".quit()" method to quit browsers. Sets the driver back to null.
     */
    public static void closeDriver(){
        if (driverPool.get()!=null){
            // This line will terminate the currently existing driver completely. It will not exist going forward.
            driverPool.get().quit();
            // We assign the value back to "null" so that the "singleton design" can create a new one if needed.
            driverPool.remove();
        }
    }
}
