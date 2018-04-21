package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import pages.MainPage;

public class LoginPageMethod {
    WebDriver driver;
    public LoginPageMethod(WebDriver driver){
        this.driver = driver;
    }


    public void loginPageMethod(String login, String password) throws Exception {
        LoginPage loginPage = new pages.LoginPage(driver);
        MainPage mainPage = new MainPage(driver);

        loginPage.loginField.sendKeys(login);
        loginPage.passwordField.sendKeys(password);
        loginPage.submitButton.click();
        WebLibrary.waitIfElementVisible(10, mainPage.mainPageTitle,driver);

    }
}
