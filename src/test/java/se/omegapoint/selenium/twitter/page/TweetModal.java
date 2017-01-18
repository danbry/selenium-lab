package se.omegapoint.selenium.twitter.page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page object representing the tweet modal.
 */
public class TweetModal {
    private final WebDriver driver;

    private final By tweetButton = By.cssSelector(".modal-tweet-form-container .btn.primary-btn.tweet-action");
    private final By tweetTextBox = By.id("tweet-box-global");


    public TweetModal(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOnTweetModal() {
        try {
            WebElement element = driver.findElement(tweetTextBox);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void enterTweet(String text) {
        WebElement element = driver.findElement(tweetTextBox);
        element.clear();
        element.sendKeys(text);
    }

    public boolean isTweetButtonEnabled() {
        WebElement element = driver.findElement(tweetButton);
        return element.isEnabled();
    }

    public void clickTweetButton() {
        WebElement element = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.elementToBeClickable(tweetButton));
        element.click();
    }
}
