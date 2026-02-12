package engine;

import generalStoreScreens.LandingScreen;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public abstract class BaseProductListScreenTests extends BaseTestScenario {
    String country="Albania";
    String userName="test user name";
    @BeforeMethod
    public void productScreenTestCaseSetup(){
       boolean isProductScreenDisplayed= new LandingScreen(driver)
                .fillLandingScreenForm(country,userName)
                .verifyGetProductListScreen();
        Assert.assertTrue(isProductScreenDisplayed);
    }
}
