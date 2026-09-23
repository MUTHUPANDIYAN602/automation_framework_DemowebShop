package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;

    private static final int MAX_RETRY = 2;

    @Override
    public boolean retry(ITestResult result) {

        if (count < MAX_RETRY) {

            count++;

            System.out.println(
                    "RETRYING TEST : "
                    + result.getMethod().getMethodName()
                    + " | RETRY COUNT : "
                    + count
            );

            return true;
        }

        System.out.println(
                "FINAL ATTEMPT FAILED : "
                + result.getMethod().getMethodName()
        );

        return false;
    }

    public boolean isFinalAttempt() {

        return count >= MAX_RETRY;
    }
    
    public int getRetryCount() {
        return count;
    }
}