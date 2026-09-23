package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import constants.FrameworkConstants;
import driver.DriverFactory;
import pages.HomePage;
import pages.LoginPage;
import reports.ExtentReportUtility;
import utilities.FileUtility;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected HomePage homePage;
    protected LoginPage loginPage;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {

        Reporter.log("========== TEST SUITE STARTED ==========", true);
        
        ExtentReportUtility.getReportObject();

        Reporter.log("Extent Report initialized", true);
    }
    
    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void openBrowser(@Optional("chrome") String browser) {

        driver = DriverFactory.getDriver(browser);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameworkConstants.IMPLICIT_WAIT));

        wait = new WebDriverWait(driver,Duration.ofSeconds(FrameworkConstants.EXPLICIT_WAIT));

        driver.get(FileUtility.getProperty("url"));

        Reporter.log("Application launched successfully", true);
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {

        DriverFactory.quitDriver();

        Reporter.log("Browser closed successfully", true);
    }
    
    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
 
        ExtentReportUtility.getReportObject().flush();
        
        Reporter.log("========== TEST SUITE EXECUTION COMPLETED ==========", true);
    }
}
