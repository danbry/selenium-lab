package se.omegapoint.selenium.twitter.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import se.omegapoint.selenium.twitter.infra.Config;

import java.util.Base64;

/**
 * Page object representing the login page for Twitter.
 */
public class LoginPage {
    static final String baseUrl = "https://www.twitter.com";
    private final WebDriver driver;

    // Elements on page
    private final By signinEmailInput = By.cssSelector("div.username.field input#signin-email");
    private final By signinPasswordInput = By.cssSelector("input#signin-password.text-input.flex-table-input");
    private final By loginButton = By.cssSelector("button.submit.btn.primary-btn.flex-table-btn");
    private static final String INCORRECT_LOGIN_TITLE = "Login on Twitter";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToPage() {
        driver.get(baseUrl + "/");
    }

    public boolean isOnIncorrectLoginPage() {
        return INCORRECT_LOGIN_TITLE.equalsIgnoreCase(driver.getTitle());
    }

    public void doLogin(String userEmail, String password, Boolean base64DecodePassword) {
        //Fill in user name
        driver.findElement(signinEmailInput).clear();
        driver.findElement(signinEmailInput).sendKeys(userEmail);

        //Fill in password
        if (base64DecodePassword) {
            password = new String(Base64.getDecoder().decode(password));
        }
        driver.findElement(signinPasswordInput).clear();
        driver.findElement(signinPasswordInput).sendKeys(password);

        //Click on login button
        driver.findElement(loginButton).click();
    }

    public void doLoginWithConfiguredUsernameAndPassword() {
        doLogin(Config.getStringValue(Config.Value.USERNAME),
                Config.getStringValue(Config.Value.PASSWORD),
                Config.getBooleanValue(Config.Value.BASE64_DECODE_PASSWORD));
    }


}
