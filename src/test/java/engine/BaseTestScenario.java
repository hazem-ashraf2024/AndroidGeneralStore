package engine;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.qameta.allure.Attachment;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public abstract class BaseTestScenario {
    public AndroidDriver driver;
    UiAutomator2Options options;
    AppiumDriverLocalService service;
    Wait<AndroidDriver> wait;
   @BeforeClass(alwaysRun = true)
    public void testScenarioSetup() throws URISyntaxException, MalformedURLException {
       options = new UiAutomator2Options()
               .setDeviceName("127.0.0.1:5554")
               .setApp("C:\\Users\\ashra\\IdeaProjects\\AndroidGeneralStore\\src\\test\\resources\\GeneralStore.apk");
       options.setCapability("chromedriverAutodownload", true);

//               .setChromedriverExecutable("C:\\Users\\ashra\\Downloads\\Compressed\\chromedriver.exe")
       service = new AppiumServiceBuilder()
               .withIPAddress("127.0.0.1")
               .usingPort(4723)
               .build();
       service.start();
       driver =new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
       wait= new FluentWait<>(driver)
               .withTimeout(Duration.ofSeconds(100))
               .pollingEvery(Duration.ofMillis(200))
               .ignoring(NoSuchElementException.class)
               .ignoring(StaleElementReferenceException.class);
   }
    @AfterMethod(alwaysRun = true)
    public void captureScreenshotOnFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                saveScreenshot(screenshotBytes, result.getName());
            } catch (Exception e) {
                System.out.println("Failed to capture screenshot: " + e.getMessage());
            }
        }
    }

    // Allure attachment
    @Attachment(value = "{testName} - Screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot, String testName) {
        return screenShot;
    }

    @AfterClass(alwaysRun = true)
   public void testScenarioTearDown(){
       driver.quit();
       service.stop();
   }
}
