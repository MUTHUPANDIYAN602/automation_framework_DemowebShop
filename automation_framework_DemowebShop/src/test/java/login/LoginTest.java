package login;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utilities.DataProviderUtility;

public class LoginTest extends BaseTest {

	@Test(dataProvider = "loginData",dataProviderClass = DataProviderUtility.class)
		public void verifyLogin(String email, String password) {

		    HomePage homePage = new HomePage(driver);

		    LoginPage loginPage = new LoginPage(driver);

		    homePage.clickLogin();

		    loginPage.login(email, password);    
		}
}