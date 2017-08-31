package Page;

import Core.OrderInfo;
import Page.Object.OrderDetailPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class OrderDetailPage extends CommonPage {
    private OrderDetailPageObject orderDetailPageObject = new OrderDetailPageObject();
    private WebDriver orderDetailPageWebView;
    private OrderInfo orderInfo = new OrderInfo();

    public OrderDetailPage(AppiumDriver<MobileElement> driver) throws Exception {
        super(driver);
        orderDetailPageWebView = getLastWebViewContext();
        PageFactory.initElements(new AppiumFieldDecorator(orderDetailPageWebView), orderDetailPageObject);
    }

    public void isCheckBoxAgreeTermPresent() throws Exception {
        getLastWebViewContext();
        if(isElementPresent(orderDetailPageObject.CHECK_BOX_AGREE_TERM)){
            orderDetailPageObject.CHECK_BOX_AGREE_TERM.click();
        }
    }

    public void isSelectGiftOptionChangePresent(){
        if(isElementPresent(orderDetailPageObject.BTN_SELECT_GIFT_OPTION_CHANGE)){
            orderDetailPageObject.BTN_SELECT_GIFT_OPTION_CHANGE.click();
            waitForElement(orderDetailPageObject.BTN_FINISH_GIFT_SELECTION, 15).click();
        }
    }

    //Step 7: check the default applicant date from consult detail page item
    //1. user name
    //2. phone number
    //3. address
    public void checkDefaultInfo() {
        //Assert Order Info
        Assert.assertEquals(checkIfElementValueNotNull(waitForElement(orderDetailPageObject.USER_INFO, 20)), true);
        Assert.assertEquals(checkIfElementValueNotNull(waitForElement(orderDetailPageObject.SHIPPING_ADDRESS, 20)), true);
        Assert.assertEquals(checkIfElementValueNotNull(waitForElement(orderDetailPageObject.FIXED_PRICE, 20)), true);
        Assert.assertEquals(checkIfElementValueNotNull(waitForElement(orderDetailPageObject.DISCOUNT_PRICE, 20)), true);
        Assert.assertEquals(checkIfElementValueNotNull(waitForElement(orderDetailPageObject.BTN_CHANGE_PAYMENT_METHOD, 20)), true);
        this.orderInfo.setDiscount(orderDetailPageObject.DISCOUNT_PRICE.getText());
        this.orderInfo.setFixedPrice(orderDetailPageObject.FIXED_PRICE.getText());
        this.orderInfo.setShippingAddress(orderDetailPageObject.SHIPPING_ADDRESS.getText().replace("\n"," "));
    }

    public OrderInfo getOrderInfo(){
        return this.orderInfo;
    }

    public void clickChangePaymentMethod(){
        waitForElement(orderDetailPageObject.BTN_CHANGE_PAYMENT_METHOD, 30).click();
    }

    public void clickBankTransfer(){
        waitForElement(orderDetailPageObject.BTN_BANK_TRANSFER, 10).click();
    }

    public void assertBankBookItems(){
        Assert.assertEquals(checkIfElementValueNotNull(waitForElement(orderDetailPageObject.SELECT_BANK_BOOK_LIST, 20)), true);
        Assert.assertEquals(checkIfElementValueNotNull(waitForElement(orderDetailPageObject.INPUT_DEPOSITOR, 20)), true);
        Assert.assertEquals(checkIfElementValueNotNull(waitForElement(orderDetailPageObject.CHECK_BOX_PAY_SMS_ACC, 20)), true);
        Assert.assertEquals(checkIfElementValueNotNull(waitForElement(orderDetailPageObject.CHECK_BOX_PAY_SMS_CMP, 20)), true);
    }

    public void clickBankBookList(){
        waitForElement(orderDetailPageObject.SELECT_BANK_BOOK_LIST, 10).click();
    }

    public void selectItemInPopUp(String item) throws Exception {
        driver.context("NATIVE_APP");
        List<MobileElement> itemsList = orderDetailPageObject.listPopUpItems;
        int i = 0;
        int size = itemsList.size();
        String strFirstItem = itemsList.get(i).getText();

        while(strFirstItem.contains(item)==false) {
            if(i == itemsList.size() - 1){
                scrollDown();
                itemsList = driver.findElements(By.id("android:id/text1"));
                size = itemsList.size()+1;
                i = -1;
            }
            size = size -1;
            i++;
            strFirstItem = itemsList.get(i).getText();
        }

        itemsList.get(i).click();

        //back to Webview and corresponding WindowHandle
        orderDetailPageWebView = getLastWebViewContext();  //getWebViewContext(4);
    }
    public void checkDepositorInput(){
        if(waitForElement(orderDetailPageObject.INPUT_DEPOSITOR, 10).getText() == null){
            orderDetailPageObject.INPUT_DEPOSITOR.clear();
            orderDetailPageObject.INPUT_DEPOSITOR.sendKeys("Thi test");
        }
        Assert.assertEquals(checkIfElementValueNotNull(orderDetailPageObject.INPUT_DEPOSITOR), true);
    }

    public void selectPaySmsAcc(){
        if(waitForElement(orderDetailPageObject.CHECK_BOX_PAY_SMS_ACC, 10).isSelected() == false){
            orderDetailPageObject.CHECK_BOX_PAY_SMS_ACC.click();
        }
    }

    public void selectPaySmsCmp(){
        if(waitForElement(orderDetailPageObject.CHECK_BOX_PAY_SMS_CMP, 10).isSelected() == false){
            orderDetailPageObject.CHECK_BOX_PAY_SMS_CMP.click();
        }
    }

    public void selectNoCashReceipt(){
        if(waitForElement(orderDetailPageObject.RADIO_BUTTON_NO, 10).isSelected() == false){
            orderDetailPageObject.RADIO_BUTTON_NO.click();
        }
    }

    public void clickCompletedPayment() throws Exception {
        waitForElement(orderDetailPageObject.BTN_COMPLETED_PAYMENT, 10).click();
        if(isAlertPresent()) {
            driver.context("NATIVE_APP");
            waitForElement(orderDetailPageObject.BTN_OK).click();
            getWebViewContext(1);
        }
    }

    public void clickAgreeCheckBox(){
        waitForElement(orderDetailPageObject.CHECK_BOX_ORDER_OK, 10).click();
    }

    public void clickOrderButton(){
        waitForElement(orderDetailPageObject.BTN_ORDER, 10).click();
    }
}
