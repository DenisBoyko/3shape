package helpers;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MainPage;

public class LoginFormMethod {
    private final WebDriver driver;

    public LoginFormMethod(WebDriver driver){
        this.driver = driver;

    }

    public void loginValidDataLoginPage(String name, String password, WebDriver driver) throws Exception {
        MainPage mainPage = new MainPage(this.driver);
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.loginField.sendKeys(name);

        loginPage.passwordField.sendKeys(password);
        loginPage.submitButton.click();
        WebLibrary.isElementPresent(mainPage.productReleasesButton);
    }



}
