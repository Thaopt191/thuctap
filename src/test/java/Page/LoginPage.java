package Page;


import Page.Object.LoginPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends CommonPage {
    private LoginPageObject loginPageObject = new LoginPageObject();

    public LoginPage(AppiumDriver<MobileElement> driver){
        super(driver);
        driver.context("NATIVE_APP");
        PageFactory.initElements(new AppiumFieldDecorator(driver), loginPageObject);
    }

    public ItemConsultDetailPage doLogin(String userID, String password) throws Exception {
        waitForElement(loginPageObject.EDIT_LOGIN_ID, 10).sendKeys(userID);
        waitForElement(loginPageObject.EDIT_LOGIN_PASSWORD, 10).sendKeys(password);
        waitForElement(loginPageObject.BTN_LOGIN, 10).click();
        return new ItemConsultDetailPage(driver);
    }

    public OrderDetailPage doLogin1(String userID, String password) throws Exception {
        waitForElement(loginPageObject.EDIT_LOGIN_ID, 10).sendKeys(userID);
        waitForElement(loginPageObject.EDIT_LOGIN_PASSWORD, 10).sendKeys(password);
        waitForElement(loginPageObject.BTN_LOGIN, 10).click();
        return new OrderDetailPage(driver);
    }


    public void performLogin(String userID, String password) throws Exception {
        waitForElement(loginPageObject.EDIT_LOGIN_ID, 10).sendKeys(userID);
        waitForElement(loginPageObject.EDIT_LOGIN_PASSWORD, 10).sendKeys(password);
        waitForElement(loginPageObject.BTN_LOGIN, 10).click();
    }

    public void checkMoveToPageSuccess(){
        Assert.assertTrue(isReachPageSucessful(loginPageObject.EDIT_LOGIN_ID));
    }

}
