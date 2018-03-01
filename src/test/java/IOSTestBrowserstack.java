
import java.net.URL;
        import java.util.List;
        import java.net.MalformedURLException;

        import org.openqa.selenium.support.ui.WebDriverWait;
        import org.openqa.selenium.remote.DesiredCapabilities;
        import org.openqa.selenium.support.ui.ExpectedConditions;

        import io.appium.java_client.MobileBy;
        import io.appium.java_client.ios.IOSDriver;
        import io.appium.java_client.ios.IOSElement;

public class IOSTestBrowserstack {
    public static String accessKey = "e5Tr2M54gE1xjmwkNwvU";
    public static String userName = "srikanteswararao1";

    public static void main(String args[]) throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("device", "iPhone 7 Plus");
        caps.setCapability("os_version", "10.3");
        caps.setCapability("app", "bs://f938e378cf7750c0a5234fb1b7241cbb88b7a1f9");


        IOSDriver driver = new IOSDriver(new URL("http://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);

        IOSElement loginButton = (IOSElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Log In")));
        loginButton.click();
        IOSElement emailTextField = (IOSElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Email address")));
        emailTextField.sendKeys("hello@browserstack.com");

        driver.findElementByAccessibilityId("Next").click();
        Thread.sleep(5000);

        List<IOSElement> textElements = driver.findElementsByXPath("//XCUIElementTypeStaticText");
        assert(textElements.size() > 0);
        String matchedString = "";
        for(IOSElement textElement : textElements) {
            String textContent = textElement.getText();
            if(textContent != null && textContent.contains("not registered")) {
                matchedString = textContent;
            }
        }

        System.out.println(matchedString);
        assert(matchedString.contains("not registered on WordPress.com"));

        driver.quit();
    }
}