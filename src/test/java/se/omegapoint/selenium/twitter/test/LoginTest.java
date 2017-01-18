package se.omegapoint.selenium.twitter.test;

import org.junit.Test;
import se.omegapoint.selenium.twitter.page.LoginPage;
import se.omegapoint.selenium.twitter.page.MainPage;

import static org.junit.Assert.assertTrue;

/**
 * Simple login tests to test the login page.
 */

public class LoginTest extends BaseTest {

    /**
    * Performs a correct login
    */
    @Test
    public void correctLogin() throws Exception {
        LoginPage loginPage = new LoginPage(driver);

        //Go to login page
        loginPage.goToPage();

        //Perform login
        loginPage.doLoginWithConfiguredUsernameAndPassword();

        MainPage mainPage = new MainPage(driver);
        //Verify that we are on the main page
        assertTrue("Not on main page", mainPage.isOnMainPage());
    }


    /**
     * Performs an incorrect login
     */
    @Test
    public void incorrectLogin() throws Exception {
        LoginPage loginPage = new LoginPage(driver);

        //Go to login page
        loginPage.goToPage();

        //Perform incorrect login
        loginPage.doLogin("InvalidUsername", "bogus", false);

        //Checks that the login was incorrect -> still on login page
        assertTrue(loginPage.isOnIncorrectLoginPage());
    }
}
