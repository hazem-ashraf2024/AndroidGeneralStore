package screenEngine;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public abstract class BaseScreen {
    protected final  AndroidDriver driver;
    protected final Wait<AndroidDriver> wait;
    protected final ElementAction elementAction;
    // Constructor
    public BaseScreen(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new FluentWait<AndroidDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        elementAction= new ElementAction(driver);
    }



}
