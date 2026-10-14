package checkout;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.LoginBaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.ProductPage;
import utilities.DataProviderUtility;


public class CheckoutTest extends LoginBaseTest {

    @Test(dataProvider = "billaddress",dataProviderClass = DataProviderUtility.class )
    public void verifyCheckout(String city , String address , String zipcode , String phone) throws InterruptedException {

    	HomePage homepage = new HomePage(driver);
    	ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        homepage.clickComputers();

        homepage.clickNotebooks();
       
        productPage.clickAddToCart();

        cartPage.openShoppingCart();

       // cartPage.proceedToCheckout();

      //  checkoutPage.completeCheckout();     
        
        cartPage.acceptTermsOfService();
        
        Thread.sleep(2000);
        cartPage.clickCheckout();
        
        Thread.sleep(3000);
        
        checkoutPage.selectbillcountry();
        checkoutPage.billcity(city);
        checkoutPage.billaddress(address);
        checkoutPage.billzipcode(zipcode);
        checkoutPage.billphone(phone);
        checkoutPage.continueBilling();
        checkoutPage.pickupinstoreBox();
        checkoutPage.continueBilling2();
        checkoutPage.continueShippingAddress();
        checkoutPage.continuePaymentInformation();
        Assert.assertEquals(checkoutPage.getproductname(), "14.1-inch Laptop");
        checkoutPage.confirmOrder(); 
        }
		
	}
    