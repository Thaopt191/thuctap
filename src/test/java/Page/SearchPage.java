package Page;

import Core.Product;
import Core.ProductType;
import Core.TestHelper;
import Page.Object.SearchPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SearchPage extends CommonPage{
    private SearchPageObject searchPageObject = new SearchPageObject();
    private WebDriver searchPageWebView;

    public SearchPage(AppiumDriver<MobileElement> driver) throws Exception {
        super(driver);
        searchPageWebView = getWebViewContext(1);
        PageFactory.initElements(new AppiumFieldDecorator(searchPageWebView), searchPageObject);
    }
    public ProductDetailPage clickOnAProduct() throws Exception {
        Document document = Jsoup.parse(searchPageWebView.getPageSource());
        Elements productItems = document.getElementsByClass("product-item");
        Map<ProductType, List<Product>> productList = productItems.stream().map(product -> {
            Product newProduct = new Product();
            newProduct.setId(product.id());
            newProduct.setName(product.getElementsByClass("productName").text());
            newProduct.setPrice(product.getElementsByClass("infoPrice").get(0).text());
            if (newProduct.getPrice().contains("상담전용상품"))
                if (newProduct.getName().contains("TV쇼핑"))
                    newProduct.setType(ProductType.RENTAL_ON_AIR);
                else
                    newProduct.setType(ProductType.RENTAL);
            else
                newProduct.setType(ProductType.NORMAL);
            return newProduct;
        }).collect(Collectors.groupingBy(Product::getType));

        Product product = productList.get(ProductType.RENTAL).get(TestHelper.random(productList.get(ProductType.RENTAL).size()));
        WebElement productElement = searchPageWebView.findElement(By.id(product.getId()));
        productElement.click();

        return new ProductDetailPage(driver, product);
    }

}
