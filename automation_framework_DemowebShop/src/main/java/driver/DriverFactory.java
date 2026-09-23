package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver(String browser) {

        if (driver == null) {

            if (browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            }
            else if (browser.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            }
            else {
                throw new IllegalArgumentException("Invalid Browser : " + browser);
            }
        }

        return driver;
    }

    public static void quitDriver() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}