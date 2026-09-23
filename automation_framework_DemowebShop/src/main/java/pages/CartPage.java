package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
    super (driver);  
    }

    // Locators

    @FindBy(linkText = "Shopping cart")
    private WebElement shoppingCartLink;

    @FindBy(name = "removefromcart")
    private WebElement removeCheckBox;

    @FindBy(name = "updatecart")
    private WebElement updateCartButton;

    @FindBy(id = "termsofservice")
    private WebElement termsOfServiceCheckBox;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(name = "CountryId")
    private WebElement countryDropdown;

    // Business Methods

    public void openShoppingCart() {
        shoppingCartLink.click();
    }

    public void removeProduct() {
        removeCheckBox.click();
        updateCartButton.click();
    }

    public void acceptTermsOfService() {
        if (!termsOfServiceCheckBox.isSelected()) {
            termsOfServiceCheckBox.click();
        }
    }

    public void clickCheckout() {
        checkoutButton.click();
    }

    public void proceedToCheckout() {
        acceptTermsOfService();
        clickCheckout();
    }
}