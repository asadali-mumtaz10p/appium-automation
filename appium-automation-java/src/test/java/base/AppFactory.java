package base;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import utils.configReader;

import java.net.MalformedURLException;
import java.net.URL;

public class AppFactory {
    public static AppiumDriver appiumDriver;
    public static configReader configReader;

    @BeforeTest
    @Parameters({"platformName", "platformVersion", "deviceName"})
    public void initializer(String platformName, String platformVersion, String deviceName) throws MalformedURLException {
        try{
            configReader  = new configReader();
            System.out.println("Initializing Appium Driver");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", platformName);
            capabilities.setCapability("platformVersion", platformVersion);
            capabilities.setCapability("deviceName", deviceName);
            capabilities.setCapability("automationName", "UiAutomator2");
            capabilities.setCapability("app", System.getProperty("user.dir") + "/app/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
            capabilities.setCapability("noReset", "false");
            capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
            capabilities.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");
            capabilities.setCapability("newCommandTimeout", "300");
            appiumDriver = new AppiumDriver(new URL("http://127.0.0.1:4723"),capabilities);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error initializing Appium Driver");
        }

    }
    @AfterTest
    public void quitDriver(){
        appiumDriver.quit();
    }

}
