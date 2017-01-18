package se.omegapoint.selenium.twitter.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import se.omegapoint.selenium.twitter.infra.Config;

/**
 * The Firefox browser
 */
public class Firefox implements BrowserDriver {
    public WebDriver getDriverInstance() {
        System.setProperty("webdriver.gecko.driver", Config.getStringValue(Config.Value.BROWSER_FIREFOX_DRIVER_PATH));
        //DesiredCapabilities legacyCapabilities = DesiredCapabilities.firefox();
        //legacyCapabilities.setCapability("marionette", true);
        //return new FirefoxDriver(legacyCapabilities);
        return new FirefoxDriver();
    }
}
