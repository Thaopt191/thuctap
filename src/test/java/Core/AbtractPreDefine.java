package Core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.util.StringUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class AbtractPreDefine {
    public AppiumDriver driver;
    public String buildVersion;

    public AppiumDriver<MobileElement> getDriver() {
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public void startUp() throws MalformedURLException {
        String appiumIp = System.getProperty("serverIp");

        if (StringUtils.isEmpty(appiumIp)) {
            appiumIp = "127.0.0.1";
        }

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-T331");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        //desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Thien\\Documents\\test-automation-script\\src\\main\\resources\\apk\\gsshop-android-m-debug-unaligned_0317.apk");
        desiredCapabilities.setCapability("--override-session", true);
        desiredCapabilities.setCapability("newCommandTimeout", "7200");
        desiredCapabilities.setCapability("resetKeyboard", true);
        desiredCapabilities.setCapability("unicodeKeyboard", true);

        //caps.setCapability("appPackage", "gsshop.mobile.v2");
        //caps.setCapability("appActivity", "com.android.calculator2.Calculator");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "gsshop.mobile.v2");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "gsshop.mobile.v2.intro.IntroActivity");
        URL url = new URL("http://"+appiumIp+":4723/wd/hub");
        driver = getDriverAndroid(DriverFactory.getAndroidDriver(url, desiredCapabilities));
        driver.resetApp();
    }

    @AfterMethod(alwaysRun = true)
    public void shutDown() {
        driver.quit();
    }

    public String getChromeDriverPath(String buildVersion) {
        String chromeDriverPath = System.getProperty("user.dir");
        String osName = System.getProperty("os.name").split(" ")[0].toUpperCase(Locale.ENGLISH);
        if (osName.contains(OSName.MAC.toString())) {
            chromeDriverPath = chromeDriverPath + "/chromedriver/mac/" + buildVersion + ".x/chromedriver";
        } else if (osName.contains(OSName.WIN.toString())) {
            chromeDriverPath = chromeDriverPath + "\\chromedriver\\win\\" + buildVersion + ".x\\chromedriver.exe";
        } else {
            chromeDriverPath = chromeDriverPath + "/chromedriver/linux/" + buildVersion + ".x/chromedriver";
        }

        return chromeDriverPath;
    }

    public String getBuildVersion(String buildVersion) {
        return buildVersion.split("\\.")[0];
    }

    public AndroidDriver getDriverAndroid(AndroidDriver androidDriver)  {
        driver = androidDriver;
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.SECONDS);
        return (AndroidDriver) driver;
    }
}
