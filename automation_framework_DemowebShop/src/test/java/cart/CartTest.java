package cart;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.LoginBaseTest;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

	public class CartTest extends LoginBaseTest{

	    @Test(priority = 1)
	    public void addProductToCart() {

	        ProductPage productPage = new ProductPage(driver);
	        CartPage cartPage = new CartPage(driver);
	        HomePage homepage = new HomePage(driver);
	        
	        homepage.clickComputers();
	        
	        homepage.clickNotebooks();
	       
	        productPage.clickAddToCart();

	        cartPage.openShoppingCart();
	        
	    }
	
	
	@Test(priority = 2)
    public void removeProductfromCart() {

        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        HomePage homepage = new HomePage(driver);
        
        cartPage.openShoppingCart();
        
        cartPage.removeProduct();
        
        cartPage.clickupdateCart();
    }
	
	 @Test(priority = 3)
	    public void proceedToCheckout() {

	        ProductPage productPage = new ProductPage(driver);
	        CartPage cartPage = new CartPage(driver);
	        HomePage homepage = new HomePage(driver);
	        
	        homepage.clickComputers();
	        
	        homepage.clickNotebooks();
	       
	        productPage.clickAddToCart();

	        cartPage.openShoppingCart();
	        
	        cartPage.ClickCountry();
	        
	        cartPage.selectcountry();
	        
	        cartPage.proceedToCheckout();
	        Assert.assertEquals(false, null);
	    }
}


