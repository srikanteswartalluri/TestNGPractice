

import java.io.File;
        import java.net.MalformedURLException;
        import java.net.URL;
        import java.util.List;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.remote.CapabilityType;
        import org.openqa.selenium.remote.DesiredCapabilities;
        import org.openqa.selenium.remote.RemoteWebDriver;
        import org.testng.annotations.*;

public class ContacManagerTest {
    public static void main(String[] args) throws MalformedURLException {


        WebDriver driver;

//location of the app
//        File app = new File("C:\\Users\\NEERAJ\\Downloads", "ContactManager.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device", "Android");
        capabilities.setCapability("deviceName", "One Plus two");
        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("udid", "9fc8fa10");
//        capabilities.setCapability("appPackage", "com.oneplus.calculator");
//        capabilities.setCapability("appActivity", "com.oneplus.calculator.Calculator");
        //To create an object of Desired Capabilities
//        DesiredCapabilities capability = new DesiredCapabilities();
////OS Name
//        capability.setCapability("device","Android");
//        capability.setCapability(CapabilityType.BROWSER_NAME, "");
////Mobile OS version. In My case its running on Android 4.2
//        capability.setCapability(CapabilityType.VERSION, "6.0");
//      //  capability.setCapability("app", app.getAbsolutePath());
////To Setup the device name
//        capability.setCapability("deviceName","Moto G");
//        capability.setCapability("platformName","Android");
//set the package name of the app
        capabilities.setCapability("appPackage", "com.android.contacts");
        //set the Launcher activity name of the app
        capabilities.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");
//driver object with new Url and Capabilities
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        System.out.println("App launched");
        // locate Add Contact button and click it
        WebElement addContactButton = driver.findElement(By.id("com.android.contacts:id/floating_action_button"));
        addContactButton.click();
        driver.findElement(By.name("Keep local")).click();


        //locate input fields and type name and email for a new contact and save it
        List<WebElement> textFields = driver.findElements(By.className("android.widget.EditText"));
        textFields.get(0).sendKeys("testname");
        textFields.get(1).sendKeys("9999999999");
        textFields.get(2).sendKeys("testemail@domain.com");
        driver.findElement(By.name("Save")).click();
        //insert assertions here

    }

}