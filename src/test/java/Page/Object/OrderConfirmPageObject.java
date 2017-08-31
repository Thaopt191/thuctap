package Page.Object;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmPageObject {
    @FindBy(xpath = "//p[@class='order-number']/em")
    public MobileElement TXT_ORDER_NUMBER;

    @FindBy(xpath = "//dl[@class='delivery-information']/dd[5]")
    public MobileElement TXT_SHIPPING_ADDRESS;

    @FindBy(xpath = "//dl[@class='amount-information']/dd[1]/em")
    public MobileElement TXT_PRICE;

    @FindBy(xpath = "//dl[@class='amount-information']/dd[2]/em")
    public MobileElement TXT_DISCOUNT;

    @FindBy(xpath = "//a[@class='link-order-delivery-query']")
    public MobileElement BTN_MY_ORDER_LIST;

}
