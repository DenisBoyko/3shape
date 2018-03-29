import data.Authorization;
import helpers.WebLibrary;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GeneralPage;
import pages.LoginPage;


public class threeShapeTest {
    WebDriver driver;
    @Before
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.get("https://partner.3shape.com/en/login");
        driver.manage().window().maximize();
        WebLibrary.waitImplicitly(10,driver);
    }

    @After
    public void afterTest() {
        driver.quit();
    }


    @Test
    public void validLoginTest() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        GeneralPage generalPage = new GeneralPage(driver);
        Authorization authorization = new Authorization();

        loginPage.loginField.sendKeys(authorization.validLoginFullAccess);
        loginPage.passwordField.sendKeys(authorization.validPasswordFullAccess);
        loginPage.submitButton.click();

        Thread.sleep(1000);
        WebLibrary.isElementPresent(generalPage.softwareButton);
    }

    @Test
    public void InValidLoginTest() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        Authorization authorization = new Authorization();

        loginPage.loginField.sendKeys(authorization.InValidLoginFullAccess);
        loginPage.passwordField.sendKeys(authorization.InValidPassword);
        loginPage.submitButton.click();

        Thread.sleep(3000);
        Assert.assertEquals("Username or password is not valid.",loginPage.errorAuthorizationMessege.getText());
    }


    @Test
    public void fullAccessPagesTest() throws Exception {
        //Login with Full access user.
        //All tabs should be available for this user

        LoginPage loginPage = new LoginPage(driver);
        GeneralPage generalPage = new GeneralPage(driver);
        Authorization authorization = new Authorization();

        loginPage.loginField.sendKeys(authorization.validLoginFullAccess);
        loginPage.passwordField.sendKeys(authorization.validPasswordFullAccess);
        loginPage.submitButton.click();
        Thread.sleep(1000);

        WebLibrary.isElementPresent(generalPage.searchButton);
        WebLibrary.isElementPresent(generalPage.productReleasesButton);
        WebLibrary.isElementPresent(generalPage.softwareButton);
        WebLibrary.isElementPresent(generalPage.resellerToolBoxButton);

        WebLibrary.isElementPresent(generalPage.marketingLibraryButton);
        WebLibrary.isElementPresent(generalPage.supportButton);
        WebLibrary.isElementPresent(generalPage.academyButton);
        WebLibrary.isElementPresent(generalPage.contctButton);
        WebLibrary.isElementPresent(generalPage.loguotButton);


    }


}
