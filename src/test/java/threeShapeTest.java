import data.Authorization;
import helpers.WebLibrary;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.GeneralPage;
import pages.ImplantStudio;
import pages.LoginPage;
import pages.SoftwareUpgrades;
import pages.SofwareAndDocsPage;


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
        WebLibrary.isElementPresent(generalPage.productReleasesButton);
    }

    @Test
    public void InValidLoginTest(){
        LoginPage loginPage = new LoginPage(driver);
        Authorization authorization = new Authorization();

        loginPage.loginField.sendKeys(authorization.InValidLoginFullAccess);
        loginPage.passwordField.sendKeys(authorization.InValidPassword);
        loginPage.submitButton.click();
        Assert.assertEquals("Username or password is not valid.",loginPage.errorAuthorizationMessege.getText());

    }

    @Test
    public void latestVersionChek() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        GeneralPage generalPage = new GeneralPage(driver);
        Authorization authorization = new Authorization();
        SofwareAndDocsPage sofwareAndDocsPage = new SofwareAndDocsPage(driver);
        ImplantStudio implantStudio = new ImplantStudio(driver);
        SoftwareUpgrades softwareUpgrades = new SoftwareUpgrades(driver);

        loginPage.loginField.sendKeys(authorization.validLoginFullAccess);
        loginPage.passwordField.sendKeys(authorization.validPasswordFullAccess);
        loginPage.submitButton.click();
        WebLibrary.waitIfElementVisible(10,generalPage.title,driver);

        generalPage.softwareButton.click();
        WebLibrary.waitIfElementVisible(10,sofwareAndDocsPage.implamtStudioButton,driver);
        sofwareAndDocsPage.implamtStudioButton.click();

        WebLibrary.waitIfElementVisible(10,implantStudio.softwareUpgradeButton,driver);
        implantStudio.softwareUpgradeButton.click();
        Assert.assertEquals("2.17.1.4",softwareUpgrades.latestVersionImolantStudio.getText());




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
        WebLibrary.waitIfElementVisible(10,generalPage.title,driver);

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
