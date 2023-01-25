package com.automation.web.config;

import com.automation.web.exceptions.StopTestException;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import org.codehaus.jettison.json.JSONException;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * WebDriverProvider provides the required driver handle based on the requested browser type
 */
public class WebDriverProvider implements Provider<WebDriver> {
    @Inject
    @Named("browser")
    private String browser;

    @Override
    public WebDriver get() {

        WebDriver returnDriver = null;

        try {
            String selectedBrowser = browser.toLowerCase();

            switch (selectedBrowser) {
                case "chrome":
                    returnDriver = DriverFactory.getChromeWebDriver();
                    break;
                case "internet explorer":
                    returnDriver = DriverFactory.getIEWebDriver();
                    break;
                case "safari":
                    returnDriver = DriverFactory.getSafariWebDriver();
                    break;
                case "firefox":
                    returnDriver = DriverFactory.getFireFoxDriver();
                    break;
                case "microsoftedge":
                    returnDriver = DriverFactory.getEdgeDriver();
                    break;
                default:
                    break;
            }

        } catch (IOException | StopTestException | JSONException e) {
            e.printStackTrace();
        }

        return returnDriver;
    }
}
