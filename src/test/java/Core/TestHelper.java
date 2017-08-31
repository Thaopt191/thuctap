package Core;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

public class TestHelper {
    public static int random(int max){
        Random rand = new Random();
        return rand.nextInt(max) + 0;
    }
    public static int random(int max, int except){
        Random rand = new Random();
        int randomVal = rand.nextInt(max) + 0;
        if (randomVal == except)
            randomVal++;
        return randomVal;
    }

    public static WebDriver getNativeContext(WebDriver webDriver){
        return ((AndroidDriver)webDriver).context("NATIVE_APP");
    }

    public static WebDriver getWebViewContext(WebDriver webDriver, int num){
        return ((AndroidDriver)webDriver).context("WEBVIEW_"+num);
    }


    public static Object getLastElement(final Collection c) {
        final Iterator itr = c.iterator();
        Object lastElement = itr.next();
        while(itr.hasNext()) {
            lastElement=itr.next();
        }
        return lastElement;
    }


}