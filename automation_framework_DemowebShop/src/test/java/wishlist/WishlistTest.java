package wishlist;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ProductPage;
import pages.SearchPage;
import pages.WishlistPage;

public class WishlistTest extends BaseTest {

    @Test
    public void verifyAddProductToWishlist() {

        SearchPage searchPage = new SearchPage(driver);
        ProductPage productPage = new ProductPage(driver);
        WishlistPage wishlistPage = new WishlistPage(driver);

        searchPage.searchProduct("Build your own cheap computer");

        driver.findElement(By.linkText("Build your own cheap computer")).click();

        productPage.clickAddToWishlist();

        wishlistPage.openWishlist();

        Assert.assertTrue(driver.getTitle().contains("Wishlist"));

        Reporter.log("Wishlist Test Passed", true);
    }
}