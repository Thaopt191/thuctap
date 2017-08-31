package Page.Object;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class ItemConsultDetailPageObject {
    @FindBy(id = "reciever")
    public MobileElement USER_INFO;

    @FindBy(id = "address1")
    public MobileElement SHIPPING_ADDRESS_1;

    @FindBy(id = "address2")
    public MobileElement SHIPPING_ADDRESS_2;

    @FindBy(id = "Phone2_1")
    public MobileElement CELL_PHONE_2_1;

    @FindBy(id = "customerPhone2")
    public MobileElement CELL_PHONE_NUMBER_2;

    @FindBy(id = "Phone1_1")
    public MobileElement TEL_PHONE_1_1;

    @FindBy(id = "telPhoneNumber2")
    public MobileElement TEL_PHONE_2;

    @FindBy(className = "btn_goto_ordermain")
    public MobileElement BTN_CONSULT_COMPLETE;

    @FindBy(id = "customerPhone2")
    public MobileElement CONSULT_NUMBER;
}
