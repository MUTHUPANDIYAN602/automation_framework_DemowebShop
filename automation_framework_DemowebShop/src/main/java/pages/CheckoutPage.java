package pages;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckoutPage extends BasePage {

  
    public CheckoutPage(WebDriver driver) {
         super(driver);
    }

    // Billing Address
    @FindBy(css = "input.button-1.new-address-next-step-button")
    private WebElement billingContinueBtn;

    @FindBy(xpath = "(//input[@class='button-1 new-address-next-step-button'])[2]")
    private WebElement billingContinueBtn2;
    // Shipping Address
    @FindBy(xpath = "//input[@class='button-1 payment-method-next-step-button']")
    private WebElement shippingAddressContinueBtn;

    // Shipping Method
    @FindBy(xpath = "//input[@class='button-1 shipping-method-next-step-button']")
    private WebElement shippingMethodContinueBtn;

    // Payment Method
    @FindBy(xpath  = "//input[@class='button-1 payment-method-next-step-button']")
    private WebElement paymentMethodContinueBtn;

    // Payment Information
    @FindBy(xpath = "//input[@class='button-1 payment-info-next-step-button']")
    private WebElement paymentInfoContinueBtn;

    // Confirm Order
    @FindBy(xpath = "//input[@class='button-1 confirm-order-next-step-button']")
    private WebElement confirmOrderBtn;

    // Order Success 
    @FindBy(css = "div.title strong")
    private WebElement orderSuccessMessage;
    
    
    @FindBy(id = "BillingNewAddress_CountryId")
    private WebElement billcountrydropdown;
    
    
   @FindBy(id = "BillingNewAddress_City" )
   private WebElement billcity;
   
   @FindBy(id = "BillingNewAddress_Address1" )
   private WebElement billaddress;
   
   @FindBy(id = "BillingNewAddress_ZipPostalCode" )
   private WebElement billzipcode;
   
   @FindBy(id = "BillingNewAddress_PhoneNumber" )
   private WebElement billphone;
   
   @FindBy(id = "PickUpInStore")
   private WebElement pickupinstore;
   
   @FindBy(xpath = "//a[@class='product-name']")
   private WebElement productname;
   

    // Business Methods

    public void continueBilling() {
        billingContinueBtn.click();
    }
    
    public void continueBilling2() {
        billingContinueBtn2.click();
    }
    
    public void continueShippingAddress() {
        shippingAddressContinueBtn.click();
    }

    public void continueShippingMethod() {
        shippingMethodContinueBtn.click();
    }

    public void continuePaymentMethod() {
        paymentMethodContinueBtn.click();
    }

    public void continuePaymentInformation() {
        paymentInfoContinueBtn.click();
    }

    public void confirmOrder() {
        confirmOrderBtn.click();
    }

    public String getOrderSuccessMessage() {
        return orderSuccessMessage.getText();
    }

    public void completeCheckout() {

        continueBilling();

        continueShippingAddress();

        continueShippingMethod();

        continuePaymentMethod();

        continuePaymentInformation();

        confirmOrder();
    }
    
    public void selectbillcountry() {
    	
    	Select select = new Select(billcountrydropdown);
    	
    	select.selectByVisibleText("India");
    }
    
    public void billaddress(String address) {
    	billaddress.click();
    	billaddress.sendKeys(address);
    }
    
    public void billcity(String city) {
    	billcity.clear();
    	billcity.sendKeys(city);
    }
    
    public void billzipcode(String zipcode) {
    	billzipcode.clear();
    	billzipcode.sendKeys(zipcode);
    }
    
    public void billphone(String phone) {
    	billphone.click();
    	billphone.sendKeys(phone);
    }
    
    
    public void pickupinstoreBox() {
       pickupinstore.click();
    }
    
    
    public void checkout(String city , String address , String zipcode , String phone) {
    	billcity(city);
    	billaddress(address);
    	billzipcode(zipcode);
    	billphone(phone);
    }
    
    public String getproductname() {
    	
    	return productname.getText();
    	
    }   
 }