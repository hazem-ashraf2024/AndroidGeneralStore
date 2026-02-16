package engine;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

public abstract class BaseTestCaseWithPropertiesFile {
    public AndroidDriver driver;
    UiAutomator2Options options;
    AppiumDriverLocalService service;
    Wait<AndroidDriver> wait;
   @BeforeMethod
    public void testScenarioWithPropFileSetup() throws URISyntaxException, IOException {
       Properties prop= new Properties();
       InputStream file =
               new FileInputStream("C:\\Users\\ashra\\IdeaProjects\\AndroidGeneralStore\\src\\main\\resources\\data.properties");
       prop.load(file);
       options = new UiAutomator2Options()
               .setDeviceName(prop.getProperty("deviceName"))
               .setApp(prop.getProperty("appPath"));
       options.setCapability("chromedriverAutodownload", true);

//               .setChromedriverExecutable("C:\\Users\\ashra\\Downloads\\Compressed\\chromedriver.exe")
       service = new AppiumServiceBuilder()
               .withIPAddress(prop.getProperty("ipAddress"))
               .usingPort(Integer.parseInt(prop.getProperty("port")))
               .build();
       service.start();
       driver =new AndroidDriver(new URI(prop.getProperty("URI")).toURL(),options);
       wait= new FluentWait<>(driver)
               .withTimeout(Duration.ofSeconds(10))
               .pollingEvery(Duration.ofMillis(200))
               .ignoring(NoSuchElementException.class)
               .ignoring(StaleElementReferenceException.class);
   }
   @AfterMethod
   public void testScenarioWithPropFileTearDown(){
       driver.quit();
       service.stop();
   }
}
