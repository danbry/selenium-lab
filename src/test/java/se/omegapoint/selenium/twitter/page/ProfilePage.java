package se.omegapoint.selenium.twitter.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import se.omegapoint.selenium.twitter.infra.Config;

/**
 * Page object for the profile page for Twitter.
 */
public class ProfilePage {

    private final WebDriver driver;
    private final By numberOfTweets = By.cssSelector(".ProfileNav " +
            "a[data-nav=tweets] .ProfileNav-value");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToPage(String userName) {
        driver.get(LoginPage.baseUrl + "/" + userName);
    }

    public void goToPageForConfiguredUsername() { goToPage(Config.getStringValue(Config.Value.USERNAME)); }

    public int getCurrentNumberOfTweets() {
        return Integer.parseInt(driver.findElement(numberOfTweets).getText());
    }
}
