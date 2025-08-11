package specs;

import base.AppFactory;
import org.testng.annotations.Test;
import pages.loginPage;

public class Login extends AppFactory {
    @Test
    public void TestingDriverInitialize() throws InterruptedException {
        String username = "standard_user";
        String password = "secret_sauce";
        loginPage loginPage = new loginPage(AppFactory.appiumDriver);
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        Thread.sleep(5000);
    }
}
