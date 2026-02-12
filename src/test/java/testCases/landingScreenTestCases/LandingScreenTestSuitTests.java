package testCases.landingScreenTestCases;

import engine.BaseTestCase;
import generalStoreScreens.LandingScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LandingScreenTestSuitTests extends BaseTestCase {
    @Test
    public void verifyFillingFormSuccessfully(){
        boolean isFormSubmittedSuccessfully= new LandingScreen(driver)
        .fillLandingScreenForm("Egypt","Test Username")
        .verifyGetProductListScreen();
        Assert.assertTrue(isFormSubmittedSuccessfully,"form not submitted successfully");
    }
    @Test
    public void verifyUsernameToastMessageTextAsExpected(){
      String actualErrorMessage= new LandingScreen(driver)
                .fillLandingScreenFormWithoutUserName("Albania")
                .toastGetText();
        String expectedErrorMessage = "Please enter your name";
        Assert.assertEquals( actualErrorMessage,expectedErrorMessage,"error message not displayed ");
    }
}
