package base;

import org.openqa.selenium.WebDriver;

import java.sql.SQLOutput;

public class AppDriver {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return driver.get();
    }
    public  static void setDriver(WebDriver Driver){
        driver.set(Driver);
        System.out.println("Driver is set");
    }
}
