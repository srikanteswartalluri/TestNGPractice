import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidRealDeviceTest {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device", "Android");
        capabilities.setCapability("deviceName", "One Plus two");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("udid", "9fc8fa10");
        capabilities.setCapability("appPackage", "com.oneplus.calculator");
        capabilities.setCapability("appActivity", "com.oneplus.calculator.Calculator");

        WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        //click on 9
        driver.findElement(By.id("com.oneplus.calculator:id/digit_9")).click();
        //click on x
        driver.findElement(By.id("com.oneplus.calculator:id/op_mul")).click();
        //click on 8
        driver.findElement(By.id("com.oneplus.calculator:id/digit_8")).click();
        //click on =
        driver.findElement(By.id("com.oneplus.calculator:id/eq")).click();

        String result = driver.findElement(By.id("com.oneplus.calculator:id/formula")).getText();

        System.out.println("result is " + result);





    }
}
