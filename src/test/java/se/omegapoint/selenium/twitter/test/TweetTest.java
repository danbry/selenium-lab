package se.omegapoint.selenium.twitter.test;

import com.google.common.base.Strings;
import org.junit.jupiter.api.Test;
import se.omegapoint.selenium.twitter.infra.Config;
import se.omegapoint.selenium.twitter.page.LoginPage;
import se.omegapoint.selenium.twitter.page.MainPage;
import se.omegapoint.selenium.twitter.page.TweetModal;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


public class TweetTest extends BaseTest {

  /**
   * Tests to create tweets
   */
  @Test
  public void correctTweet() throws Exception {

      if (!Config.getBooleanValue(Config.Value.TWITTER_TEST_ACCOUNT)) {
          fail("Since this is an updating test it will only run with a test Twitter account");
      }

      LoginPage loginPage = new LoginPage(driver);

      //Go to login page
      loginPage.goToPage();

      //Perform login
      loginPage.doLoginWithConfiguredUsernameAndPassword();

      MainPage mainPage = new MainPage(driver);
      //Verify that we are on the main page
      assertTrue(mainPage.isOnMainPage(), "Not on main page");

      //Get number of tweets before new tweet
      int numberOfTweetsBeforeNewTweet = mainPage.getCurrentNumberOfTweets();

      //Click on tweet button
      mainPage.clickTweetButton();

      //Check that the tweet modal is open
      TweetModal tweetModal = new TweetModal(driver);
      assertTrue(tweetModal.isOnTweetModal(), "Expect to have tweet modal");

      //Enter tweet text and click button
      tweetModal.enterTweet("Tweet created by Selenium test on " + new Date());
      tweetModal.clickTweetButton();

      Thread.sleep(1000);

      //Refresh page to update number of tweets
      refreshPage();

      //Get number of tweets after new tweet
      int numberOfTweetsAfterNewTweet = mainPage.getCurrentNumberOfTweets();

      //Check that the number of tweets increased
      assertTrue(numberOfTweetsBeforeNewTweet + 1 == numberOfTweetsAfterNewTweet,
              "The number of tweets should have been increased");
  }

  /**
   * Test that it's not possible to create a tweet with too many characters
   */
  @Test
  public void tweetWithTooManyCharacters() {
      LoginPage loginPage = new LoginPage(driver);

      //Go to login page
      loginPage.goToPage();

      //Perform login
      loginPage.doLoginWithConfiguredUsernameAndPassword();

      MainPage mainPage = new MainPage(driver);
      //Verify that we are on the main page
      assertTrue(mainPage.isOnMainPage(), "Not on main page");

      //Click on tweet button
      mainPage.clickTweetButton();

      //Check that the tweet modal is open
      TweetModal tweetModal = new TweetModal(driver);
      assertTrue(tweetModal.isOnTweetModal(), "Expect to have tweet modal");

      //Enter tweet text with too many characters and click button
      tweetModal.enterTweet(Strings.repeat("a", 300));
      assertFalse(tweetModal.isTweetButtonEnabled(), "The tweet button should not be enabled");
  }
}
