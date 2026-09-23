package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
    	super(driver);
    }

    // Locators
    @FindBy(id = "Email")
    private WebElement emailTextField;

    @FindBy(id = "Password")
    private WebElement passwordTextField;

    @FindBy(css = "input[value='Log in']")
    private WebElement loginButton;

    @FindBy(css = ".validation-summary-errors")
    private WebElement loginErrorMessage;

    // Business Methods

    public void enterEmail(String email) {
        emailTextField.clear();
        emailTextField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordTextField.clear();
        passwordTextField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public String getLoginErrorMessage() {
        return loginErrorMessage.getText();
    }
    
}
