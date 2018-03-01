import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidEmulatorTest {
    public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device", "Android");
        capabilities.setCapability("deviceName", "EmulatorDevice");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        //click on button 9
        driver.findElement(By.id("com.android.calculator2:id/digit_9")).click();

        //Click on +
        driver.findElement(By.id("com.android.calculator2:id/op_add")).click();

        //click on 3

        driver.findElement(By.id("com.android.calculator2:id/digit_3")).click();

        //click on =

        driver.findElement(By.id("com.android.calculator2:id/eq")).click();

        //get the result

        String result = driver.findElement(By.id("com.android.calculator2:id/formula")).getText();


        System.out.println("result is : " + result);






    }
}
