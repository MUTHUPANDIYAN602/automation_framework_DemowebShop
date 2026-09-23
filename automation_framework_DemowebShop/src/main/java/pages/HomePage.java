package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	

	 public HomePage(WebDriver driver) {
		    super(driver);
		}

	    @FindBy(linkText = "Register")
	    private WebElement registerLink;
	 
	    @FindBy(linkText = "Log in")
	    private WebElement loginLink;

	    @FindBy(linkText = "Log out")
	    private WebElement logoutLink;
	    
	    @FindBy(partialLinkText = "Shopping")
	    private WebElement shoppinglink;
	    
	    
	    public void clickRegister() {
	        registerLink.click();
	    }

	    public void clickLogin() {
	        loginLink.click();
	    }

	    public void clickLogout() {
	        logoutLink.click();
	        
	    }
	    
	    public void clickShopping() {
	    	shoppinglink.click();
	    }
	    
	    public boolean isLogoutDisplayed() {

	        try {
	            return logoutLink.isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }
	}
