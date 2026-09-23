package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

    // Generate Random Number
    public int getRandomNumber() {

        Random random = new Random();

        return random.nextInt(10000);
    }

    // Current Date
    public String getCurrentDate() {

        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        return sdf.format(date);
    }

    // Current Time
    public String getCurrentTime() {

        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("HH-mm-ss");

        return sdf.format(date);
    }

    // Timestamp
    public String getTimeStamp() {

        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_HHmmss");

        return sdf.format(date);
    }

    // Unique Email
    public String generateEmail() {

        return "muthu" + getRandomNumber() + "@gmail.com";
    }
}