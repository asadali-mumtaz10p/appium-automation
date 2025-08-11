package pages;

import base.AppDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;

public class loginPage {

    public loginPage(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(accessibility = "test-Username")
    public WebElement userNameTextField;
    @AndroidFindBy(accessibility = "test-Password")
    public WebElement passwordField;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"LOGIN\"]")
    public WebElement loginButton;

    public void enterUserName(String userName){
        userNameTextField.sendKeys(userName);
    }
    public void enterPassword(String Password){
        passwordField.sendKeys(Password);
    }
    public void clickLoginButton(){
        loginButton.click();
    }
}
