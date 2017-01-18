package se.omegapoint.selenium.twitter.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * The Safari browser
 */
public class Safari implements BrowserDriver {
    public WebDriver getDriverInstance() {
        return new SafariDriver();
    }
}
