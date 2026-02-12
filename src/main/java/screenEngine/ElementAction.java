package screenEngine;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class ElementAction {
    protected final AndroidDriver driver;
    protected final Wait<AndroidDriver> wait;
    // Constructor
    public ElementAction(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new FluentWait<AndroidDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }
    // Wait and Click method
    public void waitAndClick(By element) {
        wait.until(d -> {
            d.findElement(element).click();
            return true;
        });
    }

    // Wait and Send Keys method
    public void waitAndSendKeys(By element, String text) {
        wait.until(d -> {
            d.findElement(element).sendKeys(text);
            return true;
        });
    }
    public boolean waitAndCheckDisplayed(By element) {
        return wait.until(d -> {
            d.findElement(element).isDisplayed();
            return true;
        });

    }

    public String waitAndGetText(By element) {
        return wait.until(d -> d.findElement(element).getText());
    }
}
