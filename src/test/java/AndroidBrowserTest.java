import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidBrowserTest {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device", "Android");
        capabilities.setCapability("deviceName", "One Plus two");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("udid", "9fc8fa10");
        capabilities.setCapability("browserName", "Chrome");
        //WebDriver driver = new AndroidDriver();
        WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("http://www.google.com");

        driver.findElement(By.name("q")).sendKeys("Browser test on mobile");

        driver.findElement(By.name("q")).submit();



    }
}
