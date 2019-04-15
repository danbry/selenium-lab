package se.omegapoint.selenium.twitter.test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import se.omegapoint.selenium.twitter.browser.BrowserDriver;
import se.omegapoint.selenium.twitter.browser.BrowserSelector;

import java.util.concurrent.TimeUnit;

/**
 * The base test setting up and tearing down the specified WebDriver.
 */
public abstract class BaseTest {

    protected WebDriver driver;

    protected BrowserDriver getBrowser() {
        return BrowserSelector.getConfiguredBrowser();
    }

    protected void refreshPage() {
        //driver.navigate().to(driver.getCurrentUrl());
        driver.navigate().refresh();
        isAlertPresentThenAccept();
    }

    protected boolean isAlertPresentThenAccept() {
        try {
            driver.switchTo().alert().accept();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    @Before
    public void setUp() throws Exception {
        driver = getBrowser().getDriverInstance();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
    }


    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
