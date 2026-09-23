package listeners;

import java.util.concurrent.ConcurrentHashMap;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import reports.ExtentReportUtility;
import retry.RetryAnalyzer;
import utilities.ScreenshotUtility;

public class TestListener implements ITestListener {

    // Extent Report object
    private static final ExtentReports extent = ExtentReportUtility.getReportObject();

    // Stores one parent ExtentTest for each test method
    private static final ConcurrentHashMap<String, ExtentTest> testMap = new ConcurrentHashMap<>();

    // Stores current attempt node
    private static final ConcurrentHashMap<String, ExtentTest> attemptMap = new ConcurrentHashMap<>();

    // CREATE UNIQUE KEY FOR EACH TEST

    private String getTestKey(ITestResult result) {

        return result.getTestClass().getName() + "."+ result.getMethod().getMethodName();
    }
    
    // SUITE START

    @Override
    public void onStart(ITestContext context) {

        System.out.println( "========== TESTNG EXECUTION STARTED ==========");
    }

    // TEST START

    @Override
    public void onTestStart(ITestResult result) {

        String key = getTestKey(result);

        testMap.computeIfAbsent(key, k ->
                extent.createTest(result.getTestClass().getName() + " - " + result.getMethod().getMethodName()));

        ExtentTest parentTest = testMap.get(key);

        int attemptNumber = getAttemptNumber(result);

        ExtentTest attemptTest = parentTest.createNode("Attempt " + attemptNumber);

        attemptTest.info("Test execution started");

        attemptMap.put(key, attemptTest);


        System.out.println( "TEST STARTED : " + result.getMethod().getMethodName()+ " | Attempt : "+ attemptNumber );
    }

    // TEST SUCCESS
 
    @Override
    public void onTestSuccess(ITestResult result) {

        String key = getTestKey(result);

        ExtentTest attemptTest = attemptMap.get(key);

        if (attemptTest != null) {

            attemptTest.pass("Test Passed Successfully");
        }
        System.out.println("TEST PASSED : "+ result.getMethod().getMethodName() );

        attemptMap.remove(key);
    }

    // TEST FAILURE

    @Override
    public void onTestFailure(ITestResult result) {

        String key = getTestKey(result);

        ExtentTest attemptTest = attemptMap.get(key);

        if (attemptTest == null) {
            return;
        }
        
        // Mark attempt as failed
        attemptTest.fail("Test Failed");


        // Attach exception
        if (result.getThrowable() != null) {

            attemptTest.fail(result.getThrowable() );
        }

        // CHECK FINAL RETRY

        RetryAnalyzer retryAnalyzer = null;

        try {

            retryAnalyzer =(RetryAnalyzer) result.getMethod().getRetryAnalyzer(result);

        } catch (Exception e) {

            System.out.println("Unable to get RetryAnalyzer : "+ e.getMessage());
        }

        boolean finalAttempt =retryAnalyzer == null|| retryAnalyzer.isFinalAttempt();

        // SCREENSHOT ONLY ON FINAL FAILED ATTEMPT

        if (finalAttempt) {

            try {

                Object testInstance = result.getInstance();


                if (testInstance instanceof BaseTest) {

                    BaseTest baseTest = (BaseTest) testInstance;


                    if (baseTest.getDriver() != null) {

                        String screenshotPath = ScreenshotUtility.captureScreenshot(baseTest.getDriver(), result.getMethod().getMethodName());

                        if (screenshotPath != null) {

                            attemptTest.addScreenCaptureFromPath(screenshotPath);
                        }
                    }
                }

            } catch (Exception e) {

                attemptTest.warning("Unable to capture screenshot : " + e.getMessage());
            }

            attemptMap.remove(key);
        }


        System.out.println("TEST FAILED : "+ result.getMethod().getMethodName() );
    }

    // TEST SKIPPED
   
    @Override
    public void onTestSkipped(ITestResult result) {

        String key = getTestKey(result);

        ExtentTest attemptTest = attemptMap.get(key);


        if (attemptTest != null) {

            attemptTest.skip("Test Skipped" );


            if (result.getThrowable() != null) {

                attemptTest.skip(result.getThrowable());
            }
        }


        System.out.println("TEST SKIPPED : "+ result.getMethod().getMethodName() );

        attemptMap.remove(key);
    }
    // GET ATTEMPT NUMBER

    private int getAttemptNumber(ITestResult result) {

        RetryAnalyzer retryAnalyzer = null;

        try {

            retryAnalyzer =(RetryAnalyzer) result.getMethod().getRetryAnalyzer(result);

        } catch (Exception e) {

            return 1;
        }


        if (retryAnalyzer == null) {

            return 1;
        }

        return retryAnalyzer.getRetryCount() + 1;
    }

    // SUITE FINISH

    @Override
    public void onFinish(ITestContext context) {

        System.out.println("========== TESTNG EXECUTION COMPLETED ==========" );
    }
}