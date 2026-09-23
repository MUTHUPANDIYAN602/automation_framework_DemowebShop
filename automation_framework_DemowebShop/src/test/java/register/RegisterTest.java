package register;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.RegisterPage;
import utilities.DataProviderUtility;

public class RegisterTest extends BaseTest {

    @Test(dataProvider = "newreg",dataProviderClass = DataProviderUtility.class,priority = 1)
    public void verifyValidRegistration(String gender,String firstName, String lastName,String email,String password, String confirmPassword) {

    	HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        homePage.clickRegister();

        registerPage.register(gender,firstName,lastName,email, password,confirmPassword);
        Assert.assertEquals(registerPage.getRegistrationSuccessMessage(),"Your registration completed");

        Reporter.log("Registration Successful",true);
        homePage.clickLogout();
        homePage.clickRegister();
    }
    @Test(dataProvider = "usedmail",dataProviderClass = DataProviderUtility.class,priority = 4)
    public void verifyExistingemail(String gender,String firstName, String lastName,String email,String password, String confirmPassword) {
    	
    	
    	HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        homePage.clickRegister();

        registerPage.register(gender,firstName,lastName,email, password,confirmPassword);

        // Verify success
        Assert.assertEquals(registerPage.getRegistrationErrorMessage(),"The specified email already exists");
       
        Reporter.log("Existing Email Validation Passed",true);
        homePage.clickLogout();
        homePage.clickRegister();
    
    }
    
    @Test(dataProvider = "emptfield",dataProviderClass = DataProviderUtility.class,priority = 2)
    
    public void verifyEmptyFieldRegistration(String gender,String firstName, String lastName,String email,String password, String confirmPassword) {

    	HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        homePage.clickRegister();

        registerPage.register(gender,firstName,lastName,email, password,confirmPassword);
        Assert.assertEquals(registerPage.getfieldErrorMessage(),"First name is required.");

        Reporter.log("Registration failed",true);
        homePage.clickLogout();
        homePage.clickRegister();
    }
    
@Test(dataProvider = "difpass",dataProviderClass = DataProviderUtility.class,priority = 3)
    
    public void verifyDifferentpasswordRegistration(String gender,String firstName, String lastName,String email,String password, String confirmPassword) {

    	HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        homePage.clickRegister();

        registerPage.register(gender,firstName,lastName,email, password,confirmPassword);
        Assert.assertEquals(registerPage.getpasswordErrorMessage(),"The password and confirmation password do not match.");

        Reporter.log("Registration failed",true);
        homePage.clickLogout();
        homePage.clickRegister();
    }

@Test(dataProvider = "wrongmail",dataProviderClass = DataProviderUtility.class,priority = 5)

public void verifyWrongMailRegistration(String gender,String firstName, String lastName,String email,String password, String confirmPassword) {

	HomePage homePage = new HomePage(driver);
    RegisterPage registerPage = new RegisterPage(driver);

    homePage.clickRegister();

    registerPage.register(gender,firstName,lastName,email, password,confirmPassword);
    Assert.assertEquals(registerPage.getworngmailMessage(),"Wrongemail");

    Reporter.log("Registration failed",true);
    homePage.clickLogout();
}
    }
