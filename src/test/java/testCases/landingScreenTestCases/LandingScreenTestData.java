package testCases.landingScreenTestCases;

import engine.ReadFromJson;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class LandingScreenTestData {
    @DataProvider
    public Object[][] landingScreenValidDataProvider() {
        return new Object[][]{
                {"Albania", "test user name"}
        };
    }

    @DataProvider
    public Object[][] landingScreenInvalidDataProvider() {
        return new Object[][]{
                {"Albania"}
        };
    }

    @DataProvider
    public Object[][] dataFromJson() throws IOException {
        String filePath = "C:\\Users\\ashra\\IdeaProjects\\AndroidGeneralStore\\src\\test\\resources\\eCommerce.json";
        List<HashMap<String, String>> data = new ReadFromJson().readJsonFile(filePath);
        return new Object[][]{{data.get(0)}, {data.get(1)}};
    }
}
