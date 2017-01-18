#Selenium Lab
## Setup
The following steps needs to be performed to run the tests
* Install Java 8
* Install Maven
* Install a Java development environments, preferably IntelliJ. The community edition can be downloaded at: https://www.jetbrains.com/idea/download/
* Install Google Chrome browser
* Download the Google Chrome Selenium driver from: https://sites.google.com/a/chromium.org/chromedriver/downloads
* Optional: Install Firefox browser and the Mozilla Gecko driver from: https://github.com/mozilla/geckodriver/releases

### IntelliJ
If IntelliJ is installed you can do the following:
 1. Clone the git repository: `git clone https://github.com/danbry/selenium-lab.git`
 2. Download all the dependencies (will be automatically done by IntelliJ)
 3. Update the test configuration, described below.
 3. Run the tests
 
 

 ## The Twitter tests
 The tests are structured using the PageObject pattern (to read more: https://martinfowler.com/bliki/PageObject.html). 
 
 ### Test code structure
 The code and configuration is located in the src/test folder in package se.omegapoint.selenium.twitter
 * browser - contains classes for configuring the different browsers
 * infra - contains helper classes for the tests
 * page - contains the page objects
 * test - contains the test cases (using JUnit)
    * BaseTest - A base class for the tests to extend
    * LoginTest - Will do a correct login and an incorrect one
    * ProfileTest - Will do a login and go the the profile page
    * TwitterTest - Will send a correct Tweet and try to send a Tweet with 144 characters which will fail.
 
 ### Test configuration
 To run the tests the configuration file config.properties must be updated. It's stored in src/test/resources
 * Update the browser driver paths to the location where you installed the drivers
 * You will also have to provide a valid Twitter account username and password. All tests except the TwitterTest/correctTweet won't cause any updates but that test will actually send a real Tweet. I'd recommend that you create a test Twitter account if you want to run it. 
 