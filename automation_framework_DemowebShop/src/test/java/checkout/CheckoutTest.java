package checkout;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ProductPage;
import pages.SearchPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void verifyCheckout() {

        SearchPage searchPage = new SearchPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        searchPage.searchProduct("Build your own cheap computer");

        driver.findElement(By.linkText("Build your own cheap computer")).click();

        productPage.clickAddToCart();

        cartPage.openShoppingCart();

        cartPage.proceedToCheckout();

        checkoutPage.completeCheckout();

        Assert.assertTrue(checkoutPage.getOrderSuccessMessage().contains("Your order has been successfully processed!"));
    }
}