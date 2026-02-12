package generalStoreScreens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import screenEngine.BaseScreen;
import screenEngine.ElementAction;
import screenEngine.Gestures;

public class LandingScreen extends BaseScreen {
    Gestures gestures;
    By selectCountryDropDown = AppiumBy.id("android:id/text1");
//    By egyptCountry = AppiumBy.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Egypt']");
//    By albaniaCountry = AppiumBy.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Albania']");
    By yourNameTextField = AppiumBy.id("com.androidsample.generalstore:id/nameField");
    By genderRadioButton = AppiumBy.id("com.androidsample.generalstore:id/radioMale");
    By letsShopButton = AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop");
    By errorNameToastMessage = AppiumBy.xpath("//android.widget.Toast[1]");


    public LandingScreen(AndroidDriver driver) {
        super(driver);
        this.gestures = new Gestures(driver);
    }
    public ProductListScreen fillLandingScreenForm(String country,String userNAme){
        elementAction. waitAndClick(selectCountryDropDown);
        gestures.scrollAction(country);
        elementAction.  waitAndClick(AppiumBy.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='"+country+"']"));
        elementAction.  waitAndSendKeys(yourNameTextField, userNAme);
        elementAction.waitAndClick(genderRadioButton);
        elementAction.  waitAndClick(letsShopButton);
        return new ProductListScreen(driver);
    }
    public LandingScreen fillLandingScreenFormWithoutUserName(String country){
        elementAction. waitAndClick(selectCountryDropDown);
        gestures.scrollAction( country);
        elementAction. waitAndClick(AppiumBy.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='"+country+"']"));
//        waitAndSendKeys(yourNameTextField, "Test User");
//        driver.hideKeyboard();
        elementAction. waitAndClick(genderRadioButton);
        elementAction. waitAndClick(letsShopButton);
        return this;
    }
    public String toastGetText(){
        return wait.until(d -> d.findElement(errorNameToastMessage).getText());
    }

    }


