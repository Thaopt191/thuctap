package Page;

import Page.Object.SplashPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class SplashPage extends CommonPage {
    private SplashPageObject splashPageObject = new SplashPageObject();

    public SplashPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), splashPageObject);
    }

    public void agreeWithGsshopContent(){
        waitForElement(splashPageObject.CONFIRM_WITH_CONTENT, 20).click();
    }

    public HomePage acceptPushNotification(){
        waitForElement(splashPageObject.ACCEPT_PUSH_NOTIFICATION, 20).click();
        return new HomePage(driver);

    }
}
