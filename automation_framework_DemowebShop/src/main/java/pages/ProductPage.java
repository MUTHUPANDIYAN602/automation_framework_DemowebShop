package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductPage extends BasePage{

    public ProductPage(WebDriver driver) {
    	super(driver);
    }

    // Locators

    @FindBy(css = "input[value='Add to cart']")
    private WebElement addToCartButton;

    @FindBy(css = "input[value='Add to wishlist']")
    private WebElement addToWishlistButton;

    @FindBy(css = "input[value='Add to compare list']")
    private WebElement addToCompareButton;

    @FindBy(css = "span.price-value")
    private WebElement productPrice;

    @FindBy(css = "div.product-name h1")
    private WebElement productName;

    // Business Methods

    public void clickAddToCart() {
        addToCartButton.click();
    }

    public void clickAddToWishlist() {
        addToWishlistButton.click();
    }

    public void clickAddToCompare() {
        addToCompareButton.click();
    }

    public String getProductName() {
        return productName.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }
}