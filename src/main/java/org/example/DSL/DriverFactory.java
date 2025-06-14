package org.example.DSL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static WebDriver driver;

    private DriverFactory() {}

    public static WebDriver getDriver() {
        if (driver == null) {
            String GECKO_DRIVER_PATH = System.getProperty("user.dir") + "/src/main/resources/webdriver/geckodriver.exe";
            System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_PATH);
            driver = new FirefoxDriver();
        }
        return driver;
    }

    public static void killDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

}
