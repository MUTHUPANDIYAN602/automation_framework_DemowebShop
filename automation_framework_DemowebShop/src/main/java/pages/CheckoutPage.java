package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CheckoutPage extends BasePage {

  
    public CheckoutPage(WebDriver driver) {
         super(driver);
    }

    // Billing Address
    @FindBy(css = "input.button-1.new-address-next-step-button")
    private WebElement billingContinueBtn;

    // Shipping Address
    @FindBy(css = "input.button-1.shipping-address-next-step-button")
    private WebElement shippingAddressContinueBtn;

    // Shipping Method
    @FindBy(css = "input.button-1.shipping-method-next-step-button")
    private WebElement shippingMethodContinueBtn;

    // Payment Method
    @FindBy(css = "input.button-1.payment-method-next-step-button")
    private WebElement paymentMethodContinueBtn;

    // Payment Information
    @FindBy(css = "input.button-1.payment-info-next-step-button")
    private WebElement paymentInfoContinueBtn;

    // Confirm Order
    @FindBy(css = "input.button-1.confirm-order-next-step-button")
    private WebElement confirmOrderBtn;

    // Order Success
    @FindBy(css = "div.title strong")
    private WebElement orderSuccessMessage;

    // Business Methods

    public void continueBilling() {
        billingContinueBtn.click();
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
}