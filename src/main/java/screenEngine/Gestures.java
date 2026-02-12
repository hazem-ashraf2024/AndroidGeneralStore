package screenEngine;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class Gestures {
    private final AndroidDriver driver;

    // Constructor to receive driver instance from tests
    public Gestures(AndroidDriver driver) {
        this.driver = driver;
    }

    // Long Press on element using JavaScript Executor
    public void longPress(WebElement element, int durationInMillies) {

        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of(
                        "elementId", ((RemoteWebElement) element).getId(),
                        "duration", durationInMillies
                )
        );
    }

    // Scroll Action using Android UIAutomator - scrolls until text is found
    public WebElement scrollAction(String partialText) {
     return   driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".setMaxSearchSwipes(10)" +
                                ".scrollIntoView(new UiSelector()" +
                                ".textContains(\"" + partialText + "\"))"
                )
        );
    }

    // Swipe on Element using elementId and JavaScript Executor
    public void swipeOnElement(By element, String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
                ImmutableMap.of(
                        "elementId", ((RemoteWebElement) driver.findElement(element)).getId(),
                        "direction", direction,
                        "percent", 0.3
                )
        );
    }


    // Drag and Drop using JavaScript Executor
    public void dragAndDrop(By element, int x_Axis, int y_Axis) {
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) driver.findElement(element)).getId(),
                "endX", x_Axis,
                "endY", y_Axis
        ));
    }
}


