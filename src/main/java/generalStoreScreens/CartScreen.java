package generalStoreScreens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import screenEngine.BaseScreen;
import screenEngine.ElementAction;
import screenEngine.Gestures;

import java.util.List;

public class CartScreen extends BaseScreen {
//locators
    By cartScreenTitleLocator= AppiumBy.id("com.androidsample.generalstore:id/toolbar_title");
    By totalAmountLocator= AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl");
    By productPriceLocator=AppiumBy.id("com.androidsample.generalstore:id/productPrice");
    By productContainerLocator=null;
    By sendMeEmailsLocator= AppiumBy.className("android.widget.CheckBox");
    By termsAndConditionsLocator= AppiumBy.id("com.androidsample.generalstore:id/termsButton");
    By termsAndConditionAlertPopUp=AppiumBy.id("com.androidsample.generalstore:id/alertTitle");
    By compeletePurchaseButton=AppiumBy.id("com.androidsample.generalstore:id/btnProceed");
    By webAfterPurchase=AppiumBy.id("com.androidsample.generalstore:id/webView");
    public CartScreen(AndroidDriver driver) {
        super(driver);
    }
    public String getCartScreenTitle(){
       return elementAction.waitAndGetText(cartScreenTitleLocator);
    }
    public CartScreen getCartScreen(){
         elementAction.waitAndGetText(cartScreenTitleLocator);
        return this;
    }
    public CartScreen checkSendEmail(){
        driver.findElement(sendMeEmailsLocator).click();
return this;
    }
    public String GetSendEmailChechBoxStatus(){
        return driver.findElement(sendMeEmailsLocator).getAttribute("checked");
    }
    public CartScreen longClickOnTermsAndConditions(){
        wait.until(d->{
            new Gestures(driver)
                    .longPress(driver.findElement(termsAndConditionsLocator),2000);
            return true;
        });
        return this;
    }
    public Double getCartProductPriceByName(String productName){
        productContainerLocator = AppiumBy.xpath("//android.widget.LinearLayout[android.widget.TextView[@text='" + productName + "']]");
        return   Double.parseDouble(driver.findElement(productContainerLocator)
                .findElement(productPriceLocator)
                .getText().replace("$",""));

    }

    public Double getTotalAmountCalculated() {
        By productPriceLocator = AppiumBy.xpath(
                "//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productPrice']"
        );

        List<WebElement> priceElements = driver.findElements(productPriceLocator);
        double totalAmount = 0.0;

        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText()
                    .replace("$", "")
                    .trim();
            totalAmount += Double.parseDouble(priceText);
        }

        return totalAmount;
    }

    public Double getTotalCartAmount(){
     return  Double.parseDouble(driver.findElement(totalAmountLocator)
              .getText().replace("$ ",""));
    }
    public boolean verifyTermsPopUDisplayed(){
        return new ElementAction(driver).
                waitAndCheckDisplayed(termsAndConditionAlertPopUp);
    }
    public CartScreen completePurchase(){
        driver.findElement(compeletePurchaseButton).click();
        return this;
    }
    public boolean isAfterPurchaseDisplayed(){
       return elementAction.waitAndCheckDisplayed(webAfterPurchase);
    }
    public CartScreen inAppBrowserHandle(){
        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.findElement(By.xpath("//input[@name='q']"))
                .sendKeys("test handle mobile browser"+ Keys.ENTER);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");
        return this;
    }
}
