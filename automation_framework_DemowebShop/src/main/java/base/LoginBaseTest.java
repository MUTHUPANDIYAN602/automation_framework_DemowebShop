package base;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.HomePage;
import pages.LoginPage;
import utilities.FileUtility;

public class LoginBaseTest extends BaseTest{
	
	@BeforeMethod(alwaysRun = true)
    public void loginToApplication() {

        // Initialize Page Objects
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);

        // Click Login Link
        homePage.clickLogin();

        // Login using config.properties credentials
        loginPage.login(
                FileUtility.getProperty("email"),
                FileUtility.getProperty("password"));

        // Verify Login
        Assert.assertTrue(homePage.isLogoutDisplayed(),"Login failed. 'Log out' link is not displayed.");

        Reporter.log("Login successful", true);
    }

    @AfterMethod(alwaysRun = true)
    public void logoutFromApplication() {

        try {

            // Reinitialize HomePage
            homePage = new HomePage(driver);

            if (homePage.isLogoutDisplayed()) {

                homePage.clickLogout();

                Reporter.log("Logout successful", true);
            }

        } catch (Exception e) {

            Reporter.log("Logout skipped", true);
        }
    }

}
