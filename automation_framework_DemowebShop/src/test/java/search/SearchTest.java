package search;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.SearchPage;
import utilities.DataProviderUtility;

public class SearchTest extends BaseTest{
	
	 @Test(dataProvider = "searchData",dataProviderClass = DataProviderUtility.class)
 	public void searchProduct(String product) {

 	    SearchPage search = new SearchPage(driver);

 	    search.searchProduct(product);
 	}
}
