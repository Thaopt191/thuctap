package Page.Object;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePageObject {
    @AndroidFindBy(id = "gsshop.mobile.v2:id/promotion_close")
    public MobileElement BTN_PROMOTION_CLOSE;

    @AndroidFindBy(id = "gsshop.mobile.v2:id/btn_search")
    public MobileElement BTN_SEARCH;

    @AndroidFindBy(id = "gsshop.mobile.v2:id/button_search")
    public MobileElement BTN_SEARCH_DROPDOWN;

    @AndroidFindBy(id = "gsshop.mobile.v2:id/layout_search_bar")
    public MobileElement EDIT_SEARCH_BOX;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='오늘추천']")
    public MobileElement DEFAULT_TAB;

    @AndroidFindBy(id = "gsshop.mobile.v2:id/txt_remain_time")
    public MobileElement ON_AIR_TIMER;

    @AndroidFindBy(id = "gsshop.mobile.v2:id/btn_pay")
    public MobileElement BTN_PURCHASE;

}
