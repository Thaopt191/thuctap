package Page.Object;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailObject {
    @FindBy(className = "buy_button")
    public MobileElement BUY_BUTTON;

    @FindBy(className = "btn_price2")
    public MobileElement CONFIRM_BUTTON;
}
