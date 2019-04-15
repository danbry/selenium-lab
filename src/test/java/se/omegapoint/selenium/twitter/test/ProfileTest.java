package se.omegapoint.selenium.twitter.test;

import org.junit.jupiter.api.Test;
import se.omegapoint.selenium.twitter.page.LoginPage;
import se.omegapoint.selenium.twitter.page.MainPage;
import se.omegapoint.selenium.twitter.page.ProfilePage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for the profile page
 */
public class ProfileTest extends BaseTest {

    @Test
    public void goToProfilePage() {
        LoginPage loginPage = new LoginPage(driver);

        //Go to login page
        loginPage.goToPage();

        //Perform login
        loginPage.doLoginWithConfiguredUsernameAndPassword();

        MainPage mainPage = new MainPage(driver);
        //Verify that we are on the main page
        assertTrue(mainPage.isOnMainPage(), "Not on main page");

        //Get number of tweets
        int numberOfTweetsOnMainPage = mainPage.getCurrentNumberOfTweets();

        //Go to profile page
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.goToPageForConfiguredUsername();

        int numberOfTweetsOnProfilePage = profilePage.getCurrentNumberOfTweets();

        assertEquals(numberOfTweetsOnMainPage, numberOfTweetsOnProfilePage, "Expect number of tweets to be the same on main page and profile page");
    }
}
