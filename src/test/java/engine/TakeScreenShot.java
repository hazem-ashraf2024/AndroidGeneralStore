package engine;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TakeScreenShot {
    AndroidDriver driver;
    public TakeScreenShot(AndroidDriver driver) {
        this.driver = driver;
    }
    
    public void takeScreenShot() throws IOException {
        File source = driver.getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotPath = "C:\\Users\\ashra\\IdeaProjects\\AndroidGeneralStore\\src\\test\\java\\screenShots\\screen_" + timestamp + ".png";
        FileUtils.copyFile(source, new File(screenshotPath));
    }
}
