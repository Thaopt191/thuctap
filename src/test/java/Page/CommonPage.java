package Page;

import Core.TestHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class CommonPage {
    public AppiumDriver driver;
    public CommonPage(AppiumDriver<MobileElement> driver) {
    }

    public WebElement waitForPageToLoad(WebElement webElement, int seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, seconds);
            return wait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (Exception e) {
            e.getMessage();
        }
        return webElement;
    }

    public WebElement waitForPageToLoad(WebElement webElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 15);
            return wait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (Exception e) {
            e.getMessage();
        }
        return webElement;
    }

    public WebElement waitForElement(WebElement webElement, int seconds) {
        try {
            return waitForPageToLoad(webElement, seconds);
        } catch (Exception e) {
            e.getMessage();
        }
        return webElement;
    }

    public WebElement waitForElement(WebElement webElement) {
        try {
            return waitForPageToLoad(webElement);
        } catch (Exception e) {
            e.getMessage();
        }
        return webElement;
    }

    public WebDriver getWebViewContext(int order) throws Exception{
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> contextNames = driver.getContextHandles();
        Set<String> windowHandles = driver.context((String) contextNames.toArray()[1]).getWindowHandles();
        return driver.context((String) contextNames.toArray()[1]).switchTo().window((String)windowHandles.toArray()[order]);
    }

    public WebDriver getLastWebViewContext() throws Exception{
        //switch window handle
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> contextNames = driver.getContextHandles();
        Set<String> windowHandles = driver.context((String) contextNames.toArray()[1]).getWindowHandles();
        Object lastElement = TestHelper.getLastElement(windowHandles);

        if(windowHandles.size() == driver.context((String) contextNames.toArray()[1]).getWindowHandles().size()){
            return driver.context((String) contextNames.toArray()[1]).switchTo().window(lastElement.toString());
        }
        else{
            windowHandles = driver.context((String) contextNames.toArray()[1]).getWindowHandles();
            lastElement = TestHelper.getLastElement(windowHandles);
            return driver.context((String) contextNames.toArray()[1]).switchTo().window(lastElement.toString());
        }
    }

    public boolean checkIfElementValueNotNull(WebElement element){
        if(element.getText() != null){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            if(element != null)
                return element.isDisplayed();
            return false;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isReachPageSucessful(WebElement webElement){
        if(isElementPresent(waitForElement(webElement, 30))){
            return true;
        }
        else return false;
    }

    public void scrollDown() {
        Dimension size = driver.manage().window().getSize();
        int x = size.getWidth() / 2;
        int starty = (int) (size.getHeight() * 0.60);
        int endy = (int) (size.getHeight() * 0.10);
        try {
            Thread.sleep(2000);
            driver.swipe(x, starty, x, endy, 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public boolean isAlertPresent()
    {
        try
        {
            driver.switchTo().alert();
            return true;
        }   // try
        catch (NoAlertPresentException Ex)
        {
            return false;
        }   // catch
    }
}
