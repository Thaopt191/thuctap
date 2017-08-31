package Page.Object;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPageObject {
    @AndroidFindBy(id = "gsshop.mobile.v2:id/edit_login_id")
    public MobileElement EDIT_LOGIN_ID;

    @AndroidFindBy(id = "gsshop.mobile.v2:id/edit_password")
    public MobileElement EDIT_LOGIN_PASSWORD;

    @AndroidFindBy(id = "gsshop.mobile.v2:id/btn_login")
    public MobileElement BTN_LOGIN;

}
