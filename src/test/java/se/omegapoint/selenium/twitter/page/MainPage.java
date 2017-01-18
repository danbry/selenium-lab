package se.omegapoint.selenium.twitter.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page object for the main page for Twitter.
 */
public class MainPage {
    private final WebDriver driver;

    private final By tweetButton = By.id("global-new-tweet-button");
    private final By numberOfTweets = By.cssSelector(".DashboardProfileCard-content " +
            ".ProfileCardStats .ProfileCardStats-statValue");
    private final By userDropdownMenu = By.id("user-dropdown-toggle");
    private final By logoutButton = By.cssSelector(".js-signout-button .dropdown-link");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOnMainPage() {
        try {
            driver.findElement(tweetButton);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickTweetButton() {
        driver.findElement(tweetButton).click();
    }

    public void clickOpenUserDropdownMenu() {
        WebElement element = (new WebDriverWait(driver, 2))
                .until(ExpectedConditions.elementToBeClickable(userDropdownMenu));
        element.click();
    }

    public void clickLogoutButton() {
        WebElement element = (new WebDriverWait(driver, 2))
                .until(ExpectedConditions.elementToBeClickable(logoutButton));
        element.click();
    }

    public int getCurrentNumberOfTweets() {
        return Integer.parseInt(driver.findElement(numberOfTweets).getText());
    }
}
