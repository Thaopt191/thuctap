package Page;


import Page.Object.ItemConsultDetailPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ItemConsultDetailPage extends CommonPage {
    private ItemConsultDetailPageObject itemConsultDetailPageObject = new ItemConsultDetailPageObject();
    private WebDriver itemConsultDetailPageWebView;

    public ItemConsultDetailPage(AppiumDriver<MobileElement> driver) throws Exception {
        super(driver);
        itemConsultDetailPageWebView = getWebViewContext(1);
        PageFactory.initElements(new AppiumFieldDecorator(itemConsultDetailPageWebView), itemConsultDetailPageObject);
    }

    //Step 7: check the default applicant date from consult detail page item
    //1. user name
    //2. phone number
    //3. address
    public void checkDefaultInfo(){
        Assert.assertEquals(checkIfElementValueNotNull(itemConsultDetailPageObject.USER_INFO), true);
        Assert.assertEquals(checkIfElementValueNotNull(itemConsultDetailPageObject.SHIPPING_ADDRESS_1), true);
        Assert.assertEquals(checkIfElementValueNotNull(itemConsultDetailPageObject.SHIPPING_ADDRESS_2), true);
        Assert.assertEquals(checkIfElementValueNotNull(itemConsultDetailPageObject.CELL_PHONE_2_1), true);
        Assert.assertEquals(checkIfElementValueNotNull(itemConsultDetailPageObject.CELL_PHONE_NUMBER_2), true);
        Assert.assertEquals(checkIfElementValueNotNull(itemConsultDetailPageObject.TEL_PHONE_1_1), true);
        Assert.assertEquals(checkIfElementValueNotNull(itemConsultDetailPageObject.TEL_PHONE_2), true);
    }

    //Step 8: Click consult complete button
    public void clickConsultComplete(){
        waitForElement(itemConsultDetailPageObject.BTN_CONSULT_COMPLETE, 10).click();
    }

    // assert item : consult number
    public void checkConsultNumber(){
        Assert.assertEquals(checkIfElementValueNotNull(itemConsultDetailPageObject.CONSULT_NUMBER), true);
    }
}
