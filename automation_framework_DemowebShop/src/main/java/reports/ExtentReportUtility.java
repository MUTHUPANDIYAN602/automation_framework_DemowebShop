package reports;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import constants.FrameworkConstants;

public class ExtentReportUtility {

    private static ExtentReports extent;

    public static ExtentReports getReportObject() {

        if (extent == null) {
        	
        	String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        	
        	 String reportPath =FrameworkConstants.REPORT_PATH+ "DemoWebShopReport_"+ timestamp+ ".html";
        	
        	 ExtentSparkReporter spark =new ExtentSparkReporter(reportPath);

            spark.config().setReportName("Demo Web Shop Automation");

            spark.config().setDocumentTitle("Automation Test Report");

            extent = new ExtentReports();

            extent.attachReporter(spark);

            extent.setSystemInfo("Tester", "MUTHUPANDIYAN");
            extent.setSystemInfo("Framework", "Selenium + TestNG");
            extent.setSystemInfo("Language", "Java");

        }

        return extent;
    }
}