package Page.Object;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OrderDetailPageObject {
    @FindBy(xpath = "//*[@id='baseDlvpFrame0']/dd[1]/strong")
    public MobileElement USER_INFO;

    @FindBy(xpath = "//*[@id='baseDlvpFrame0']/dd[4]/strong")
    public MobileElement SHIPPING_ADDRESS;

    @FindBy(xpath = "//span[@class='fixed-price-area']")
    public MobileElement FIXED_PRICE;

    @FindBy(xpath = "//span[@id='total_dc_amt_span']")
    public MobileElement DISCOUNT_PRICE;

    @FindBy(xpath = "//button[@id='view-payment-method']")
    public MobileElement BTN_CHANGE_PAYMENT_METHOD;

    @FindBy(xpath = "//*[@id='payTypLst']//a[@data-viewid='cash']")
    public MobileElement BTN_BANK_TRANSFER;

    @FindBy(xpath = "//select[@id='pay_slt_bank']")
    public MobileElement SELECT_BANK_BOOK_LIST;

    @FindBy(xpath = "//input[@id='pay_user_bank']")
    public MobileElement INPUT_DEPOSITOR;

    @FindBy(xpath = "//input[@id='pay_sms_acc']")
    public MobileElement CHECK_BOX_PAY_SMS_ACC;

    @FindBy(xpath = "//input[@id='pay_sms_cmp']")
    public MobileElement CHECK_BOX_PAY_SMS_CMP;

    @AndroidFindBys({
            @AndroidFindBy(id="android:id/text1")
    })
    public List<MobileElement> listPopUpItems;

    @FindBy(xpath = "//input[@id='rdo_rcpt_n']")
    public MobileElement RADIO_BUTTON_NO;

    @FindBy(xpath = "//button[@id='btn-save-method']")
    public MobileElement BTN_COMPLETED_PAYMENT;

    @FindBy(xpath = "//input[@id='order_ok_chk']")
    public MobileElement CHECK_BOX_ORDER_OK;

    @FindBy(xpath = "//*[@id='btn_order_sheet_payment']")
    public MobileElement BTN_ORDER;

    @FindBy(xpath = "//div[@class='check-terms-and-condition-agree']//input[@class='checkbox-item']")
    public MobileElement CHECK_BOX_AGREE_TERM;

    @FindBy(xpath = "//a[@class='function-gift-item-option-change']")
    public MobileElement BTN_SELECT_GIFT_OPTION_CHANGE;

    @FindBy(xpath = "//a[@class='function-free-gift-selection-finish']")
    public MobileElement BTN_FINISH_GIFT_SELECTION;

    @AndroidFindBy(id = "gsshop.mobile.v2:id/btn_ok")
    public MobileElement BTN_OK;

}
