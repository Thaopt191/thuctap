package Page;

import Core.Product;
import Page.Object.ProductDetailObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage extends CommonPage {
    private ProductDetailObject productDetailObject = new ProductDetailObject();
    private WebDriver productPageWebView;
    private Product product = new Product();
    public ProductDetailPage(AppiumDriver<MobileElement> driver) throws Exception {
        super(driver);
        productPageWebView = getLastWebViewContext();
        PageFactory.initElements(new AppiumFieldDecorator(productPageWebView), productDetailObject);

    }
    public ProductDetailPage(AppiumDriver<MobileElement> driver, Product product) throws Exception {
        super(driver);
        productPageWebView = getLastWebViewContext();
        PageFactory.initElements(new AppiumFieldDecorator(productPageWebView), productDetailObject);
        this.product = product;

    }

    public LoginPage clickBtn(){
        try {
            waitForElement(productDetailObject.BUY_BUTTON).click();
            waitForElement(productDetailObject.CONFIRM_BUTTON).click();
        } catch (Exception e){
            waitForElement(productDetailObject.CONFIRM_BUTTON).click();
        }
        return new LoginPage(driver);
    }

}
