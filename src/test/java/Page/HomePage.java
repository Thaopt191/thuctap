package Page;

import Page.Object.HomePageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;

import java.util.concurrent.TimeUnit;

public class HomePage extends CommonPage {
    HomePageObject homePageObject=new HomePageObject();
    public HomePageObject getHomePageObject() {
        return homePageObject;
    }

    public HomePage(AppiumDriver<MobileElement> driver) {
        super(driver);
        driver.context("NATIVE_APP");
        PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), homePageObject);
    }

    public void closePromotionNotification() throws Exception {
        try {
            waitForElement(homePageObject.BTN_PROMOTION_CLOSE, 20).click();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void clickSearchBox() throws Exception {
        waitForElement(homePageObject.BTN_SEARCH_DROPDOWN, 30).click();
    }

    public SearchPage searchData(String inputData) throws Exception {
        waitForElement(homePageObject.EDIT_SEARCH_BOX, 15).click();
        waitForElement(homePageObject.EDIT_SEARCH_BOX, 15).sendKeys(inputData);
        waitForElement(homePageObject.BTN_SEARCH).click();
        return new SearchPage(driver);
    }

    public void checkDefaultTabName(){
        Assert.assertEquals(isElementPresent(homePageObject.DEFAULT_TAB), true);
    }

    public void assertOnAirTimer(){
        Assert.assertEquals(isElementPresent(homePageObject.ON_AIR_TIMER), true);
    }
    public String getOnAirTimer(){
        int minutes = Integer.parseInt(homePageObject.ON_AIR_TIMER.getText().substring(3,5));
        int hour = Integer.parseInt(homePageObject.ON_AIR_TIMER.getText().substring(0,2));
        String strHour = Integer.toString((hour*60)+ minutes);
        return strHour;
    }

    public void clickPurchase(){
        waitForElement(homePageObject.BTN_PURCHASE, 15).click();
    }


    public void checkButtonText4Skip(String buttonText, MobileElement mobileElement){
        Assert.assertEquals(isElementPresent(mobileElement), true);
        if (!buttonText.equals(mobileElement.getText())) {
            throw new SkipException("현재 "+ buttonText +" 상태가 아닙니다.");
        }
    }

}
