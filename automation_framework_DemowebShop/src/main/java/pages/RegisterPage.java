package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{

    public RegisterPage(WebDriver driver) {
    	super(driver);
    }

    // Locators

    @FindBy(id = "gender-male")
    private WebElement maleRadioButton;

    @FindBy(id = "gender-female")
    private WebElement femaleRadioButton;

    @FindBy(id = "FirstName")
    private WebElement firstNameTextField;

    @FindBy(id = "LastName")
    private WebElement lastNameTextField;

    @FindBy(id = "Email")
    private WebElement emailTextField;

    @FindBy(id = "Password")
    private WebElement passwordTextField;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordTextField;

    @FindBy(id = "register-button")
    private WebElement registerButton;

    @FindBy(className = "result")
    private WebElement registrationSuccessMessage;
    
    @FindBy(css = ".message-error")
    private WebElement registrationErrorMessage;
    
    @FindBy(xpath = "//span[@class='field-validation-error']")
    private WebElement fieldErrorMessage;
    
    @FindBy(xpath = "//span[@for='ConfirmPassword']")
    private WebElement passwordErrorMessage;

    @FindBy(xpath = "//span[@for='Email']")
    private WebElement worngmailMessage;
    
    // Business Methods

    public void selectMaleGender() {
        maleRadioButton.click();
    }

    public void selectFemaleGender() {
        femaleRadioButton.click();
    }

    public void enterFirstName(String firstName) {
        firstNameTextField.clear();
        firstNameTextField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameTextField.clear();
        lastNameTextField.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        emailTextField.clear();
        emailTextField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordTextField.clear();
        passwordTextField.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        confirmPasswordTextField.clear();
        confirmPasswordTextField.sendKeys(confirmPassword);
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public String getRegistrationSuccessMessage() {
        return registrationSuccessMessage.getText();
    }
    
    
    public String getRegistrationErrorMessage() {
        return registrationErrorMessage.getText();
    }
    
    public String getfieldErrorMessage() {
        return fieldErrorMessage.getText();
    }

    public String getpasswordErrorMessage() {
        return passwordErrorMessage.getText();
    }
    
    public String getworngmailMessage() {
        return worngmailMessage.getText();
    }
    
    // Complete Registration Method

    public void register(String gender,
                         String firstName,
                         String lastName,
                         String email,
                         String password,
                         String confirmPassword) {

        if (gender.equalsIgnoreCase("male")) {
            selectMaleGender();
        } else {
            selectFemaleGender();
        }

        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterPassword(password);
        enterConfirmPassword(confirmPassword);

        clickRegisterButton();
    }
}