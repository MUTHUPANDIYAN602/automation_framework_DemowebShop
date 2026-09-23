package utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtility {

    @DataProvider(name = "loginData")
    public static Object[][] getLoginData() {

        return ExcelUtility.getMultipleDataFromExcel("Login");
    }

    @DataProvider(name = "registerData")
    public static Object[][] getRegisterData() {

        return ExcelUtility.getMultipleDataFromExcel("Register");
    }

    @DataProvider(name = "searchData")
    public static Object[][] getSearchData() {

        return ExcelUtility.getMultipleDataFromExcel("searchdata");
    }
    
    @DataProvider(name = "newreg")
    public static Object[][] getnewreg() {

        return ExcelUtility.getMultipleDataFromExcel("newreg");
    }
    
    @DataProvider(name = "usedmail")
    public static Object[][] getusedmail() {

        return ExcelUtility.getMultipleDataFromExcel("usedmail");
    }
    
    @DataProvider(name = "emptfield")
    public static Object[][] getemptfield() {

        return ExcelUtility.getMultipleDataFromExcel("emptfield");
    }
    
    @DataProvider(name = "difpass")
    public static Object[][] getdifpass() {

        return ExcelUtility.getMultipleDataFromExcel("difpass");
    }
    
    @DataProvider(name = "wrongmail")
    public static Object[][] getwrongmail() {

        return ExcelUtility.getMultipleDataFromExcel("wrongmail");
    }
    
    
}