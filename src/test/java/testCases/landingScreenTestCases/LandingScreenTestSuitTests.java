package testCases.landingScreenTestCases;


import engine.BaseTestCase;
import generalStoreScreens.LandingScreen;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;



public class LandingScreenTestSuitTests extends BaseTestCase {
    @Epic("General Store App Tests") // high-level module or feature set
    @Feature("Form Filling Feature") // specific functionality being tested
    @Story("Verify Filling Form Successfully") // detailed scenario/user story
    @Severity(SeverityLevel.NORMAL) // impact/severity of this test
    @Description("Test verifies that the user can fill the form successfully with valid data and submit it.")
    @Test(dataProvider = "landingScreenValidDataProvider",dataProviderClass = LandingScreenTestData.class)
    public void verifyFillingFormSuccessfully(String country,String userName){
        boolean isFormSubmittedSuccessfully= new LandingScreen(driver)
        .fillLandingScreenForm(country,userName)
        .verifyGetProductListScreen();
        Assert.assertTrue(isFormSubmittedSuccessfully,"form not submitted successfully");
    }
    @Epic("General Store App Tests") // high-level module or feature set
    @Feature("Form Filling Feature") // specific functionality being tested
    @Story("Verify Username Toast Message Text As Expected") // detailed scenario/user story
    @Severity(SeverityLevel.NORMAL) // impact/severity of this test
    @Description("test verifies that the user can see toast error message when user name is not provided.")
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
