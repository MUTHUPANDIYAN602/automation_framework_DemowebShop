	package cart;

	import org.testng.annotations.Test;

	import base.BaseTest;
	import pages.CartPage;
	import pages.ProductPage;
	import pages.SearchPage;

	public class CartTest extends BaseTest {

	    @Test
	    public void addProductToCart() {

	        SearchPage searchPage = new SearchPage(driver);
	        ProductPage productPage = new ProductPage(driver);
	        CartPage cartPage = new CartPage(driver);

	        searchPage.searchProduct("Build your own cheap computer");

	        driver.findElement(org.openqa.selenium.By.linkText("Build your own cheap computer")).click();

	        productPage.clickAddToCart();

	        cartPage.openShoppingCart();

	        cartPage.proceedToCheckout();
	    }
	}

