package se.omegapoint.selenium.twitter.infra;

import java.io.IOException;
import java.util.Properties;

/**
 * Handles the configuration
 */
public class Config {

    public enum Value {
        TWITTER_TEST_ACCOUNT("twitterTestAccount"),
        BASE64_DECODE_PASSWORD("base64decodePassword"),
        USERNAME("username"),
        PASSWORD("password"),
        BROWSER("browser"),
        BROWSER_CHROME_DRIVER_PATH("browserChromeDriverPath"),
        BROWSER_FIREFOX_DRIVER_PATH("browserFirefoxDriverPath");


        private final String name;
        Value( String name ){
            this.name = name;
        }
        public String getName(){
            return this.name;
        }
    }

    private static Properties config;

    private Config() {}

    private static void readConfig() {
        try {
            Properties properties = new Properties();
            properties.load(Config.class.getClassLoader().getResourceAsStream("config.properties"));
            config = properties;
        } catch (IOException e) {
            throw new IllegalStateException("Couldn't find config file config.properties in classpath");
        }
    }

    public static String getStringValue(Value configValue) {
        if (config == null) {
            readConfig();
        }

        return config.getProperty(configValue.getName());
    }

    public static Boolean getBooleanValue(Value configValue) {
        return Boolean.parseBoolean(Config.getStringValue(configValue));
    }

}
