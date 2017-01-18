package se.omegapoint.selenium.twitter.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import se.omegapoint.selenium.twitter.infra.Config;

/**
 * The Chrome browser
 */
public class Chrome implements BrowserDriver {
    public WebDriver getDriverInstance()
    {
        System.setProperty("webdriver.chrome.driver", Config.getStringValue(Config.Value.BROWSER_CHROME_DRIVER_PATH));
        return new ChromeDriver();
    }
}