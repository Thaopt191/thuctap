package Page;

import Core.OrderInfo;
import Page.Object.OrderConfirmPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderConfirmPage extends CommonPage {
    private OrderConfirmPageObject orderConfirmPageObject = new OrderConfirmPageObject();
    private OrderInfo orderInfo;
    public OrderConfirmPage(AppiumDriver<MobileElement> driver, OrderInfo orderInfo) {
        super(driver);
        this.orderInfo = orderInfo;
        PageFactory.initElements(new AppiumFieldDecorator(driver), orderConfirmPageObject);
    }
    public void assertInformation(){
        OrderInfo orderConfirmationOrderInfo = new OrderInfo();
        orderConfirmationOrderInfo.setShippingAddress(waitForElement(orderConfirmPageObject.TXT_SHIPPING_ADDRESS, 10).getText());
        orderConfirmationOrderInfo.setFixedPrice(waitForElement(orderConfirmPageObject.TXT_PRICE, 10).getText());
        orderConfirmationOrderInfo.setDiscount(waitForElement(orderConfirmPageObject.TXT_DISCOUNT, 10).getText());
        Assert.assertEquals(orderInfo.getShippingAddress(), orderConfirmationOrderInfo.getShippingAddress(), "Compare two address");
        Assert.assertEquals(orderInfo.getFixedPrice(), orderConfirmationOrderInfo.getFixedPrice(), "Compare two price");
        Assert.assertEquals(orderInfo.getDiscount(), orderConfirmationOrderInfo.getDiscount(), "Compare two discount");
    }

    public void clickViewOrderList(){
        waitForElement(orderConfirmPageObject.BTN_MY_ORDER_LIST, 10).click();
    }

    public String getOrderNumber(){
        return waitForElement(orderConfirmPageObject.TXT_ORDER_NUMBER, 10).getText().replace("주문번호 : ","");
    }
}
