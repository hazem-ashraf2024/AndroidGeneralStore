package engine;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
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
   @BeforeClass
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
               .withTimeout(Duration.ofSeconds(10))
               .pollingEvery(Duration.ofMillis(200))
               .ignoring(NoSuchElementException.class)
               .ignoring(StaleElementReferenceException.class);
   }
   @AfterClass
   public void testScenarioTearDown(){
       driver.quit();
       service.stop();
   }
}
