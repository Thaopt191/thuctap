package Page;

import Page.Object.SingleOnAirPrdPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SingleOnAirPrdPage extends CommonPage {
    private SingleOnAirPrdPageObject singleOnAirPrdPageObject = new SingleOnAirPrdPageObject();
    private WebDriver singleOnAirPrdPage;
    public SingleOnAirPrdPage(AppiumDriver<MobileElement> driver) throws Exception{
        super(driver);
        singleOnAirPrdPage = getWebViewContext(0);
        PageFactory.initElements(new AppiumFieldDecorator(driver), singleOnAirPrdPageObject);
    }

    public void selectOptions() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        if(isElementPresent(singleOnAirPrdPageObject.SELECT_OPTIONS)) {
            executor.executeScript("arguments[0].click();", singleOnAirPrdPageObject.SELECT_OPTIONS);

            List<MobileElement> optionsList = singleOnAirPrdPageObject.selectOptions;
            for(int i = 0; i < optionsList.size(); i++) {
                String str_options = optionsList.get(i).getText();
                //optionsList.get(i).isEnabled() == true
                if(str_options.equalsIgnoreCase("") == false && !optionsList.get(i).getAttribute("class").equalsIgnoreCase("soldout")){
                    executor.executeScript("arguments[0].click();", optionsList.get(i));
                    break;
                }
            }
        }
    }

    public void clickSingleBuy() throws Exception {
        waitForElement(singleOnAirPrdPageObject.BTN_SINGLE_BUY, 20).click();
    }
}
