package utilities;

	import java.time.Duration;
	import java.util.Set;

	import org.openqa.selenium.Alert;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;
	public class Webdriver_Utilities {
	

	    // Maximize Browser
	    public void maximizeWindow(WebDriver driver) {
	        driver.manage().window().maximize();
	    }

	    // Implicit Wait
	    public void implicitWait(WebDriver driver, int seconds) {
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	    }

	    // Select by Visible Text
	    public void selectByVisibleText(WebElement element, String text) {
	        Select select = new Select(element);
	        select.selectByVisibleText(text);
	    }

	    // Select by Value
	    public void selectByValue(WebElement element, String value) {
	        Select select = new Select(element);
	        select.selectByValue(value);
	    }

	    // Select by Index
	    public void selectByIndex(WebElement element, int index) {
	        Select select = new Select(element);
	        select.selectByIndex(index);
	    }

	    // Mouse Hover
	    public void mouseHover(WebDriver driver, WebElement element) {
	        Actions actions = new Actions(driver);
	        actions.moveToElement(element).perform();
	    }

	    // Double Click
	    public void doubleClick(WebDriver driver, WebElement element) {
	        Actions actions = new Actions(driver);
	        actions.doubleClick(element).perform();
	    }

	    // Right Click
	    public void rightClick(WebDriver driver, WebElement element) {
	        Actions actions = new Actions(driver);
	        actions.contextClick(element).perform();
	    }

	    // Accept Alert
	    public void acceptAlert(WebDriver driver) {
	        Alert alert = driver.switchTo().alert();
	        alert.accept();
	    }

	    // Dismiss Alert
	    public void dismissAlert(WebDriver driver) {
	        Alert alert = driver.switchTo().alert();
	        alert.dismiss();
	    }

	    // Scroll to Element
	    public void scrollToElement(WebDriver driver, WebElement element) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", element);
	    }

	    // Switch Window
	    public void switchWindow(WebDriver driver, String partialTitle) {

	        Set<String> windows = driver.getWindowHandles();

	        for (String window : windows) {

	            driver.switchTo().window(window);

	            if (driver.getTitle().contains(partialTitle)) {
	                break;
	            }
	        }
	    }
	}

