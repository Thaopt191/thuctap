package Core;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class DriverFactory {
    public static AndroidDriver getAndroidDriver(URL url, DesiredCapabilities desiredCapabilities) {
        return new AndroidDriver(url, desiredCapabilities);
    }
}