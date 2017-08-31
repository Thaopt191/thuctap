package Page.Object;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SplashPageObject {
    @AndroidFindBy(id = "gsshop.mobile.v2:id/btn_ok")
    public MobileElement BTN_CLOSE_NOTIFICATION;

    @AndroidFindBy(id = "gsshop.mobile.v2:id/btnConfirm")
    public MobileElement CONFIRM_WITH_CONTENT;

    @AndroidFindBy(id = "gsshop.mobile.v2:id/btn_ok")
    public MobileElement ACCEPT_PUSH_NOTIFICATION;

    @AndroidFindBy(id = "gsshop.mobile.v2:id/btn_cancel")
    public MobileElement DO_NOT_ACCEPT_PUSH_NOTIFICATION;
}
