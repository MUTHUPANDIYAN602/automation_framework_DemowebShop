package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
    	super(driver);
    	}

    // Locators

    @FindBy(id = "small-searchterms")
    private WebElement searchTextField;

    @FindBy(css = "input[value='Search']")
    private WebElement searchButton;

    @FindBy(className = "search-results")
    private WebElement searchResult;

    // Business Methods

    public void enterProductName(String productName) {
        searchTextField.clear();
        searchTextField.sendKeys(productName);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void searchProduct(String productName) {
        enterProductName(productName);
        clickSearchButton();
    }

    public void searchUsingEnterKey(String productName) {
        searchTextField.clear();
        searchTextField.sendKeys(productName, Keys.ENTER);
    }

    public String getSearchResult() {
        return searchResult.getText();
    }
}
