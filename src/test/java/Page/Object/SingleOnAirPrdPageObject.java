package Page.Object;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class SingleOnAirPrdPageObject {
    @FindBy(xpath = "//label[@class='btn_price']")
    public MobileElement BTN_SINGLE_BUY;

    @FindBy(xpath = "//h2[@class='styledSelect']")
    public MobileElement SELECT_OPTIONS;

    @FindBys({
            @FindBy(xpath = "//*[@id='emptyContainer_0']//ul[@class='select_list_con']/li")
    })
    public List<MobileElement> selectOptions;

}
