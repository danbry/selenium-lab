package se.omegapoint.selenium.twitter.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import se.omegapoint.selenium.twitter.infra.Config;

/**
 * The Chrome browser
 */
public class ChromeHeadless implements BrowserDriver {
    public WebDriver getDriverInstance()
    {
        System.setProperty("webdriver.chrome.driver", Config.getStringValue(Config.Value.BROWSER_CHROME_DRIVER_PATH));
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);

        return new ChromeDriver(chromeOptions);
    }
}