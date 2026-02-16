package testCases.landingScreenTestCases;


import engine.BaseTestCase;
import engine.TakeScreenShot;
import generalStoreScreens.LandingScreen;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class LandingScreenTestSuitWithScreenShotTests extends BaseTestCase {

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
        String expectedErrorMessage = "please enter your name";
        Assert.assertEquals( actualErrorMessage,expectedErrorMessage,"error message not displayed ");
    }
    
    @AfterMethod
    public void captureScreenshotOnFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            TakeScreenShot takeScreenShot = new TakeScreenShot(driver);
            try {
                takeScreenShot.takeScreenShot();
                System.out.println("Screenshot captured for failed test: " + result.getName());
            } catch (Exception e) {
                System.out.println("Failed to capture screenshot: " + e.getMessage());
            }
        }
    }
}
