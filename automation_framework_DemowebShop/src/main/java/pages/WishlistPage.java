package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage extends BasePage {

    public WishlistPage(WebDriver driver) {
    	super(driver);
    }

    // Locators

    @FindBy(linkText = "Wishlist")
    private WebElement wishlistLink;

    @FindBy(name = "removefromcart")
    private WebElement removeCheckbox;

    @FindBy(name = "updatecart")
    private WebElement updateWishlistButton;

    @FindBy(name = "addtocart")
    private WebElement addToCartCheckbox;

    @FindBy(name = "addtocartbutton")
    private WebElement addToCartButton;

    // Business Methods

    public void openWishlist() {
        wishlistLink.click();
    }

    public void removeProduct() {
        removeCheckbox.click();
        updateWishlistButton.click();
    }

    public void addProductToCart() {
        addToCartCheckbox.click();
        addToCartButton.click();
    }
}