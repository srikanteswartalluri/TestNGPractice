
import java.net.URL;
import java.util.List;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;





public class IOSTestBrowserstack {
    public static String accessKey = "e5Tr2M54gE1xjmwkNwvU";
    public static String userName = "srikanteswararao1";

    public static void main(String args[]) throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("device", "iPhone 7 Plus");
        caps.setCapability("os_version", "10.3");
        caps.setCapability("app", "bs://f938e378cf7750c0a5234fb1b7241cbb88b7a1f9");


        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);

        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement loginButton = driver.findElement(By.id("Log In"));
        wait.until(
                ExpectedConditions.elementToBeClickable(loginButton)
        );
        loginButton.click();

        wait = new WebDriverWait(driver, 30);
        WebElement  emailTextField= driver.findElement(By.id("Email address"));
          wait.until(
                ExpectedConditions.elementToBeClickable(emailTextField));
        emailTextField.sendKeys("hello@browserstack.com");

        driver.findElement(By.id("Next")).click();
        Thread.sleep(5000);

        List<WebElement> textElements = driver.findElements(By.xpath("//XCUIElementTypeStaticText"));
        assert(textElements.size() > 0);
        String matchedString = "";
        for(WebElement textElement : textElements) {
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