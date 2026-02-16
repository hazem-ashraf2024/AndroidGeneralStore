package testCases.landingScreenTestCases;

import engine.BaseTestCase;
import generalStoreScreens.LandingScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class LandingScreenReadFromJsonTest extends BaseTestCase {

    @Test(dataProvider = "dataFromJson",dataProviderClass = LandingScreenTestData.class)
    public void verifyFillingFormSuccessfullyFromJson(HashMap<String,String> data){
        boolean isFormSubmittedSuccessfully= new LandingScreen(driver)
                .fillLandingScreenForm(data.get("country"),data.get("name"))
                .verifyGetProductListScreen();
        Assert.assertTrue(isFormSubmittedSuccessfully,"form not submitted successfully");
    }

}
