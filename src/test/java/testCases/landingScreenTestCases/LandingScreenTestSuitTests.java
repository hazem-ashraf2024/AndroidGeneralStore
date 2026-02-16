package testCases.landingScreenTestCases;

import com.google.common.collect.ImmutableMap;
import engine.BaseTestCase;
import engine.BaseTestScenario;
import generalStoreScreens.LandingScreen;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LandingScreenTestSuitTests extends BaseTestCase {

    @Test(dataProvider = "landingScreenValidDataProvider",dataProviderClass = LandingScreenTestData.class)
    public void verifyFillingFormSuccessfully(String country,String userName){
        boolean isFormSubmittedSuccessfully= new LandingScreen(driver)
        .fillLandingScreenForm(country,userName)
        .verifyGetProductListScreen();
        Assert.assertTrue(isFormSubmittedSuccessfully,"form not submitted successfully");
    }
    @Test(dataProvider = "landingScreenInvalidDataProvider",dataProviderClass = LandingScreenTestData.class)
    public void verifyUsernameToastMessageTextAsExpected(String country){
//        driver.executeScript("mobile: startActivity", ImmutableMap.of(
//                "intent", "com.androidsample.generalstore/com.androidsample.generalstore.MainActivity"
//        ));
        String actualErrorMessage= new LandingScreen(driver)
                .fillLandingScreenFormWithoutUserName(country)
                .toastGetText();
        String expectedErrorMessage = "Please enter your name";
        Assert.assertEquals( actualErrorMessage,expectedErrorMessage,"error message not displayed ");
    }
}
