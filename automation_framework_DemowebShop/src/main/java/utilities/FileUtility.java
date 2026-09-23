package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import constants.FrameworkConstants;

public class FileUtility {

    public static String getProperty(String key) {

        Properties property = new Properties();

        try (FileInputStream fis =
                new FileInputStream(FrameworkConstants.PROPERTY_PATH)) {

            property.load(fis);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return property.getProperty(key);
    }
}