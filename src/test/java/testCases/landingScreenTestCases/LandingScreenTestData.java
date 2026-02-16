package testCases.landingScreenTestCases;

import org.testng.annotations.DataProvider;

public class LandingScreenTestData {
    @DataProvider
    public Object [][] landingScreenValidDataProvider(){
        return new Object[][]{
                {"Albania","test user name"}
        };
    }
    @DataProvider
    public Object [][] landingScreenInvalidDataProvider(){
        return new Object[][]{
                {"Albania"}
        };
    }
}
